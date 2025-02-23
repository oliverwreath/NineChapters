package com.lintcode.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class ReverseList {

  public static void main(String[] arg) {
    testReverseList();
  }

  private static void testReverseList() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    log.info("result = {}", reverse(head));
//        log.info("result = {}", reverse(head));
//        log.info("result = {}", reverse(head));
  }

  static ListNode reverse(ListNode head) {
    // corner cases of inputs
    if (head == null || head.next == null) {
      return head;
    }

    // reverse
    ListNode a = null;
    ListNode b = head;
    ListNode c = head.next;
    while (c != null) {
      b.next = a;
      a = b;
      b = c;
      c = c.next;
    }
    b.next = a;

    // return result
    return b;
  }
}
