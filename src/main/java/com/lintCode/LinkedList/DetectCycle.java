package com.lintCode.LinkedList;

import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/5/2016.
 */
public class DetectCycle {
    private static final Logger logger = LoggerFactory.getLogger(DetectCycle.class);

    public static void main(String[] arg) {
        testDetectCycle();
    }

    private static void testDetectCycle() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = head.next;
        logger.info("result = {}", detectCycle(head));

        ListNode head1 = new ListNode(-1);
        head1.next = new ListNode(0);
        head1.next.next = new ListNode(2);
        logger.info("result = {}", detectCycle(head1));
    }

    static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        HashSet<ListNode> set = new HashSet<ListNode>();
        ListNode iterator = head;
        while (iterator != null) {
            if (set.contains(iterator)) {
                return iterator;
            }
            set.add(iterator);
//            logger.info("set.size() = {}", set.size());
            iterator = iterator.next;
        }

        return null;
    }
}
