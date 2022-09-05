package com.leetcode.Weekly_123;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
@Slf4j
public class LC989ArrayForm {
  public List<Integer> addToArrayForm(int[] num, int k) {
    // filter abnormal cases
    LinkedList<Integer> list = new LinkedList<>();
    if (num == null || num.length == 0) {
      while (k > 0) {
        list.addFirst(k % 10);
        k /= 10;
      }
      return list;
    }

    // dp logic
    int m = num.length - 1;
    int carry = 0;
    while (k > 0) {
      int sum = k % 10 + (m >= 0 ? num[m] : 0) + carry;
      carry = sum / 10;
      list.addFirst(sum % 10);
      k /= 10;
      m--;
    }
    for (int i = m; i >= 0; i--) {
      int sum = num[i] + carry;
      carry = sum / 10;
      list.addFirst(sum % 10);
    }
    if (carry > 0) {
      list.addFirst(1);
    }

    // return the final result
    return list;
  }

}
