package com.leetcode;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver Approach 1: Rotate Groups of Four Cells. Approach 2: Reverse on Diagonal and then Reverse Left to
 * Right.
 */
@Slf4j
public class LC86PartitionList {

  public ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null)
      return head;

    ListNode dummy1 = new ListNode(-1);
    ListNode dummy2 = new ListNode(-1);
    ListNode p = head, p1 = dummy1, p2 = dummy2;
    while (p != null) {
      if (p.val < x) {
        p1.next = p;
        p1 = p1.next;
      } else {
        p2.next = p;
        p2 = p2.next;
      }
      p = p.next;
    }
    p2.next = null;
    p1.next = dummy2.next;
    return dummy1.next;
  }
}
