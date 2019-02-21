package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.BinaryClient;

import java.util.PriorityQueue;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Putting everything into a minHeap, then retrieve them in order.
 * <p>
 * TIME: O(N logN)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
public class MergeKSortedLists {
    private static final Logger logger = LoggerFactory.getLogger(MergeKSortedLists.class);

    public static void main(String[] args) {
        MergeKSortedLists thisClass = new MergeKSortedLists();
        thisClass.testAddTwoNumbers();
    }

    private void testAddTwoNumbers() {
        ListNode node = new ListNode(2);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(6);

        logger.info("result {} v.s. {}", "", mergeKLists(new ListNode[]{node, node2}));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // filter abnormal cases
        if (lists == null || lists.length == 0) {
            return null;
        }

        // dp logic
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (ListNode list : lists) {
            ListNode tmp = list;
            while(tmp!= null) {
                pq.add(tmp.val);
                tmp = tmp.next;
            }
        }
        ListNode pre = new ListNode(-1);
        ListNode head = pre;
        while(!pq.isEmpty()) {
            head.next = new ListNode(pq.poll());
            head = head.next;
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
