package com.oliver.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/7/12.
 */
public class Partition {
    private final static Logger logger = LoggerFactory.getLogger(Partition.class);

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        testPartition();
        logger.info("time taken = {}s", (System.currentTimeMillis() - startTime) / 1000.0);
    }

    private static void testPartition() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        logger.info("{}", partition(head, 3));
    }

    public static ListNode partition(ListNode head, int x) {
        return head;
    }

    /**
     * 样例
     给定链表 1->4->3->2->5->2->null，并且 x=3

     返回 1->2->2->4->3->5->null
     */
}
