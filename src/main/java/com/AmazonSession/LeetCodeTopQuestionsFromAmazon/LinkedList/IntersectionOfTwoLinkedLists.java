package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Single loop adding up digits and handle carry along the way.
 * <p>
 * TIME: O(N)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD. while loop and swap if reaching the end.
 * <p>
 * TIME: O(N)
 * SPACE: O(1)
 */
public class IntersectionOfTwoLinkedLists {
    private final static Logger logger = LoggerFactory.getLogger(IntersectionOfTwoLinkedLists.class);

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists thisClass = new IntersectionOfTwoLinkedLists();
        thisClass.testAddTwoNumbers();
    }

    private void testAddTwoNumbers() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = node.next.next;

        logger.info("result {} v.s. {}", "", getIntersectionNode(node, node2));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // filter abnormal cases
        if (headA == null || headB == null) {
            return null;
        }

        // dp logic
        ListNode a = headA;
        ListNode b = headB;
        HashSet<ListNode> set = new HashSet<>();
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
            b = b.next;
        }

        // return the final result
        return null;
    }

//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//        // filter abnormal cases
//        if (headA == null || headB == null) {
//            return null;
//        }
//
//        // dp logic
//        ListNode a = headA;
//        ListNode b = headB;
//        while (a != b) {
//            a = a.next == null ? headB : a.next;
//            b = b.next == null ? headA : b.next;
//        }
//
//        // return the final result
//        return a;
//    }

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
