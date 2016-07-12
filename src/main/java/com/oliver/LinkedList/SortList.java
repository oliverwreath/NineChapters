package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class SortList {
    private final static Logger logger = LoggerFactory.getLogger(SortList.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testSortList();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testSortList() {
        ListNode head = new ListNode(8);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        logger.info("{}", sortList(head));

        ListNode head2 = new ListNode(8);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        logger.info("{}", sortList(head2));

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(3);
        head3.next.next = new ListNode(2);
        logger.info("{}", sortList(head3));

        logger.info("{}", sortList(null));
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head.next = head1;
                head1 = head1.next;
            } else {
                head.next = head2;
                head2 = head2.next;
            }
            head = head.next;
        }

        if (head1 != null) {
            head.next = head1;
        } else if (head2 != null) {
            head.next = head2;
        }

        return dummy.next;
    }

    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null;
        ListNode left = sortList(head);

        return mergeList(left, right);
    }
}
