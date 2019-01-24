package com.Amazon.LeetCode.Algorithms;

import java.util.ArrayList;

import com.lintCode.LinkedList.ListNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class PalindromeLinkedList {
    private final static Logger logger = LoggerFactory.getLogger(PalindromeLinkedList.class);

    public static void main(String[] arg) {
        new PalindromeLinkedList().testPalindromeLinkedList();
    }

    private void testPalindromeLinkedList() {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(4);
        logger.info("{}", isPalindrome(head));
    }

    public boolean isPalindrome(ListNode head) {
        // write your code here
        // handle extreme cases
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        myLogger.info("findMiddle");
        ListNode right = reverse(middle);
        myLogger.info("reverse");
        ListNode left = head;
        while (right != null) {
            if (left == null) {
                return false;
            } else {
                if (right.val != left.val) {
                    return false;
                }
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    private ListNode findMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = new ListNode(0);
        slow.next = head;
        ListNode fast = new ListNode(0);
        fast.next = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;
        }
        return slow.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
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
        return b;
    }

//    public boolean isPalindrome(ListNode head) {
//        // write your code here
//        // handle extreme cases
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        ArrayList<Integer> list = new ArrayList<>();
//        while (head != null) {
//            list.add(head.val);
//            head = head.next;
//        }
//
//        return isPalindrome(list);
//    }

    private boolean isPalindrome(ArrayList<Integer> list) {
        if (list == null || list.size() < 2) {
            return true;
        }
        int n = list.size();
        int remainder = n % 2;
        int half = n / 2;
        for (int i = 0; i < half; i++) {
            if (!list.get(i).equals(list.get(n - 1 - i))) {
                return false;
            }
        }

        return true;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
