package com.oliver.LinkedList;

/**
 * Created by Yanliang Han on 2016/6/26.
 */
public class DeleteDuplicatesBak {

    public static void main(String[] args) {
        testDeleteDuplicates();
    }

    private static void testDeleteDuplicates() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates(head));
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                int target = fast.val;
                while (fast != null && fast.val == target) {
                    fast = fast.next;
                }
                slow.next = fast;
            } else {
                slow = fast;
                fast = fast.next;
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
