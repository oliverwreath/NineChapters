package com.lintcode.LinkedList;

import com.util.ListNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
@Slf4j
public class Partition {

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    testPartition();
    log.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
  }

  private static void testPartition() {
    ListNode head1 = new ListNode(1);
    head1.next = new ListNode(4);
    head1.next.next = new ListNode(3);
    head1.next.next.next = new ListNode(2);
    head1.next.next.next.next = new ListNode(5);
    head1.next.next.next.next.next = new ListNode(2);
    log.info("{}", partition(head1, 3));

    ListNode head2 = new ListNode(1);
    log.info("{}", partition(head2, 1));

    ListNode head3 = new ListNode(1);
    log.info("{}", partition(head3, 2));

    log.info("{}", partition(null, 0));
  }

  public static ListNode partition(ListNode head, int x) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode leftDummy = new ListNode(0);
    ListNode leftFast = leftDummy;
    ListNode rightDummy = new ListNode(0);
    ListNode rightFast = rightDummy;

    while (head != null) {
      if (head.val >= x) {
        rightFast.next = head;
        rightFast = rightFast.next;
      } else {
        leftFast.next = head;
        leftFast = leftFast.next;
      }
      head = head.next;
    }

    rightFast.next = null;
    leftFast.next = rightDummy.next;

    return leftDummy.next;
  }

  /**
   * 样例
   给定链表 1->4->3->2->5->2->null，并且 x=3

   返回 1->2->2->4->3->5->null
   */
}
