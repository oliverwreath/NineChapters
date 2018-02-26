package com.ATemplates_DataStructures.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No466_CountLinkedListNode {
    private final static Logger logger = LoggerFactory.getLogger(No466_CountLinkedListNode.class);

    public static void main(String[] args) {
        No466_CountLinkedListNode No466_CountLinkedListNode = new No466_CountLinkedListNode();
        No466_CountLinkedListNode.testNo466_CountLinkedListNode();
    }

    private void testNo466_CountLinkedListNode() {
        MyLogger.info("result 0 v.s. " + countNodes(null));
        MyLogger.info("result 1 v.s. " + countNodes(new ListNode(1)));
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    int countNodes(ListNode head) {
        // filter abnormal cases
        if (head == null) {
            return 0;
        }

        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }

        // return the final result
        return count;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
