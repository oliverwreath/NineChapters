package com.lintcode.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MiddleNode {
  public static void main(String[] arg) {
    testMiddleNode();
  }

  private static void testMiddleNode() {
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(4);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(2);
    head1.next.next.next.next = new ListNode(5);
    head1.next.next.next.next.next = new ListNode(2);
    log.info("{}", middleNode(head1));

    ListNode head2 = new ListNode(1);
    head2.next = new ListNode(2);
    head2.next.next = new ListNode(3);
    head2.next.next.next = new ListNode(4);
    head2.next.next.next.next = new ListNode(5);
    log.info("{}", middleNode(head2));
  }

  static ListNode middleNode(ListNode head) {
    // corner cases
    if (head == null || head.next == null) {
      return head;
    }

    // step 1 - get the length
    int len = 0;
    ListNode dummyHead = head;
    while (dummyHead != null) {
      dummyHead = dummyHead.next;
      len++;
    }

    // step 2 - find the middle
    int mid = len / 2 + len % 2;
    int steps = mid - 1;
    dummyHead = head;
    while (steps > 0) {
      dummyHead = dummyHead.next;
      steps--;
    }

    // return the result
    return dummyHead;
  }
}
