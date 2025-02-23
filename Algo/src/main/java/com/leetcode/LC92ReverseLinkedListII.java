package com.leetcode;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC92ReverseLinkedListII {

  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || head.next == null)
      return head;

    if (left == 1) {
      return reverseFirstN(head, right);
    }
    head.next = reverseBetween(head.next, left - 1, right - 1);
    return head;
  }

  private ListNode succ = null;

  private ListNode reverseFirstN(ListNode head, int n) {
    if (n == 1) {
      succ = head.next;
      return head;
    }

    ListNode last = reverseFirstN(head.next, n - 1);
    head.next.next = head;
    head.next = succ;
    return last;
  }
}
