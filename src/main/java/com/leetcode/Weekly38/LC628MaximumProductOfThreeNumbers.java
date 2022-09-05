package com.leetcode.Weekly38;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.LinkedList;

/**
 * Author: Oliver
 */
@Slf4j
public class LC628MaximumProductOfThreeNumbers {
  public int maximumProduct(int[] nums) {
    if (nums == null || nums.length < 3)
      return 1;
    if (nums.length == 3)
      return nums[0] * nums[1] * nums[2];

    LinkedList<Integer> positive = new LinkedList<>();
    LinkedList<Integer> negative = new LinkedList<>();
    for (int num : nums) {
      if (num >= 0) {
        positive.add(num);
      } else {
        negative.add(num);
      }
    }

    positive.sort((o1, o2) -> o2 - o1);
    Collections.sort(negative);

//    log.debug(String.valueOf(positive));
//    log.debug(String.valueOf(negative));

    if (negative.isEmpty()) {
      return positive.get(0) * positive.get(1) * positive.get(2);
    } else if (positive.isEmpty()) {
      return negative.get(negative.size()-1) * negative.get(negative.size()-2) * negative.get(negative.size()-3);
    } else {
      int result = Integer.MIN_VALUE;
      if (positive.size() > 2) {
        int tmp = positive.get(0) * positive.get(1) * positive.get(2);
        result = Math.max(result, tmp);
      }
      if (!positive.isEmpty() && negative.size() > 1) {
        int tmp = positive.get(0) * negative.get(0) * negative.get(1);
        result = Math.max(result, tmp);
      }
      return result;
    }
  }
}
