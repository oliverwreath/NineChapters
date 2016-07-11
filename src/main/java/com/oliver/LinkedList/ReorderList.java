package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class ReorderList {
    private final static Logger logger = LoggerFactory.getLogger(ReorderList.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testReorderList();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testReorderList() {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        reorderList(head1);
        logger.info("{}", head1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        reorderList(head2);
        logger.info("{}", head2);

        ListNode head3 = new ListNode(1);
        reorderList(head3);
        logger.info("{}", head3);

        ListNode head4 = null;
        reorderList(head4);
        logger.info("{}", head4);
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }

        return newHead;
    }

    public static ListNode interleaveList(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        boolean isGoingOne = true;
        while (head1 != null && head2 != null) {
            if (isGoingOne) {
                head.next = head1;
                head1 = head1.next;
                isGoingOne = false;
            } else {
                head.next = head2;
                head2 = head2.next;
                isGoingOne = true;
            }
            head = head.next;
        }

        if (head1 != null) {
            head.next = head1;
        } else {
            head.next = head2;
        }
        return dummy.next;
    }

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        ListNode right = reverseList(middle.next);
        middle.next = null;

        interleaveList(head, right);

        return;
    }
}
