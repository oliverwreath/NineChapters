package com.leetcode;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC206ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null)
      return head;

    ListNode newHead = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
