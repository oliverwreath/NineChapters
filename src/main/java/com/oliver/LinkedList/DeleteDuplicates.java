package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli_000 on 16/7/10.
 */
public class DeleteDuplicates {
    private final static Logger logger = LoggerFactory.getLogger(DeleteDuplicates.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testDeleteDuplicates();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testDeleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);
        ListNode resultHead = deleteDuplicates(head);
        logger.info("{}", resultHead);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(1);
        head2.next.next = new ListNode(1);
        head2.next.next.next = new ListNode(2);
        head2.next.next.next.next = new ListNode(3);
        ListNode resultHead2 = deleteDuplicates(head2);
        logger.info("{}", resultHead2);

        ListNode head3 = new ListNode(1);
        ListNode resultHead3 = deleteDuplicates(head3);
        logger.info("{}", resultHead3);

        ListNode resultHead4 = deleteDuplicates(null);
        logger.info("{}", resultHead4);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy.next;

        while (fast != null && fast.next != null) {
            if (fast.val == fast.next.val) {
                // duplication detected
                fast = fast.next;
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                slow.next = fast;
            } else {
                // unique element
                fast = fast.next;
                slow = slow.next;
            }
        }

        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
