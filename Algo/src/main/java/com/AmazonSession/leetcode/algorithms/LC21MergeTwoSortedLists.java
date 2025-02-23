package com.AmazonSession.leetcode.algorithms;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC21MergeTwoSortedLists {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode(-1), scanner = dummy;
    ListNode l1 = list1, l2 = list2;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        scanner.next = l1;
        l1 = l1.next;
      } else {
        scanner.next = l2;
        l2 = l2.next;
      }
      scanner = scanner.next;
    }
    if (l1 == null)
      scanner.next = l2;
    else
      scanner.next = l1;
    return dummy.next;
  }
}
