package com.lintCode.LinkedList;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/5/2016.
 */
public class CopyRandomList {
    private static final Logger logger = LoggerFactory.getLogger(CopyRandomList.class);

    public static void main(String[] arg) {
        testCopyRandomList();
    }

    private static void testCopyRandomList() {
        RandomListNode head = new RandomListNode(1);
        head.next = new RandomListNode(2);
        head.next.next = new RandomListNode(3);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next;
        logger.info("result = {}", copyRandomList(head));

        RandomListNode head1 = new RandomListNode(-1);
        head1.next = new RandomListNode(0);
        head1.next.next = new RandomListNode(2);
        logger.info("result = {}", copyRandomList(head1));
    }

    static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode newPre = new RandomListNode(-1);
        {
            RandomListNode nodeIterator = head;
            RandomListNode newPreIterator = newPre;
            while (nodeIterator != null) {
                newPreIterator.next = new RandomListNode(nodeIterator.label);
                newPreIterator.next.random = nodeIterator.random;
                map.put(nodeIterator, newPreIterator.next);
                newPreIterator = newPreIterator.next;
                nodeIterator = nodeIterator.next;
            }
        }

        RandomListNode newIterator = newPre.next;
        while (newIterator != null) {
            newIterator.random = map.get(newIterator.random);
            newIterator = newIterator.next;
        }

        return newPre.next;
    }
}
