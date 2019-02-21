package com.lintCode.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/3/2016.
 */
public class RemoveNthFromEnd {
    private static final Logger logger = LoggerFactory.getLogger(RemoveNthFromEnd.class);

    public static void main(String[] arg) {
        testRemoveNthFromEnd();
    }

    private static void testRemoveNthFromEnd() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(2);
        logger.info("{}", removeNthFromEnd(head1, 3));

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        logger.info("{}", removeNthFromEnd(head2, 2));
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(0);
        pre.next = head;
        // delete
        ListNode slow = pre;
        ListNode fast = slow;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        // return
        return pre.next;
    }
}
