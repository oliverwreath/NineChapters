package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Single loop adding up digits and handle carry along the way.
 * <p>
 * TIME: O(N)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
public class AddTwoNumbers {
    private static final Logger logger = LoggerFactory.getLogger(AddTwoNumbers.class);

    public static void main(String[] args) {
        AddTwoNumbers thisClass = new AddTwoNumbers();
        thisClass.testAddTwoNumbers();
    }

    private void testAddTwoNumbers() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(6);

        logger.info("result {} v.s. {}", "", addTwoNumbers(node, node2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // filter abnormal cases
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        // dp logic
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        short carry = 0;
        while (l1 != null || l2 != null) {
            head.next = new ListNode(-1);
            head = head.next;
            head.val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            if (head.val > 9) {
                head.val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        // handle possible carry == 1
        if (carry == 1) {
            head.next = new ListNode(1);
        }

        // return the final result
        return pre.next;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
