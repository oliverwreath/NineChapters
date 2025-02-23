package com.AmazonSession.leetcode.algorithms;

import com.util.ListNode;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC234PalindromeLinkedList {

  public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }

    ArrayList<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }

    return isPalindrome(list);
  }

  private boolean isPalindrome(ArrayList<Integer> list) {
    if (list == null || list.size() < 2) {
      return true;
    }
    int n = list.size();
    int remainder = n % 2;
    int half = n / 2;
    for (int i = 0; i < half; i++) {
      if (!list.get(i).equals(list.get(n - 1 - i))) {
        return false;
      }
    }

    return true;
  }
}
