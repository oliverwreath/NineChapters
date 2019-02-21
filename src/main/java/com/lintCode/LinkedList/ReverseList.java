package com.lintCode.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/4/2016.
 */
public class ReverseList {
    private static final Logger logger = LoggerFactory.getLogger(ReverseList.class);

    public static void main(String[] arg) {
        testReverseList();
    }

    private static void testReverseList() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        logger.info("result = {}", reverse(head));
//        logger.info("result = {}", reverse(head));
//        logger.info("result = {}", reverse(head));
    }

    static ListNode reverse(ListNode head) {
        // corner cases of inputs
        if (head == null || head.next == null) {
            return head;
        }

        // reverse
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

        // return result
        return b;
    }
}
