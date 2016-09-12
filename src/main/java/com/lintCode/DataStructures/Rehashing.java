package com.lintCode.DataStructures;

import java.util.Arrays;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/11/2016.
 */
public class Rehashing {
    private final static Logger logger = LoggerFactory.getLogger(Rehashing.class);

    public static void main(String[] arg) {
        testRehashing();
    }

    private static void testRehashing() {
        ListNode[] nodes = new ListNode[4];
        nodes[1] = new ListNode(21);
        nodes[1].next = new ListNode(9);
        nodes[2] = new ListNode(14);
        ListNode[] ret = rehashing(nodes);
        logger.info("{}", Arrays.toString(ret));
    }

    static ListNode[] rehashing(ListNode[] hashTable) {//size >= capacity / 10
        // filter abnormal inputs
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }

        // check if resize is necessary
        int capacity = hashTable.length;
        int size = 0;
        LinkedList<ListNode> nodes = new LinkedList<ListNode>();
        for (int i = 0; i < capacity; i++) {
            ListNode tmpNode = hashTable[i];
            while (tmpNode != null) {
                nodes.add(tmpNode);
                size++;
                tmpNode = tmpNode.next;
            }
        }

        boolean isExpndingNecessary = size >= capacity / 10;
        if (isExpndingNecessary) {
            int newCapacity = 2 * capacity;
            ListNode[] newList = new ListNode[newCapacity];
            for (ListNode node : nodes) {
                int index = (node.val % newCapacity + newCapacity) % newCapacity;
                if (newList[index] != null) {
                    ListNode tmp = newList[index];
                    while (tmp.next != null) {
                        tmp = tmp.next;
                    }
                    tmp.next = new ListNode(node.val);
                } else {
                    newList[index] = new ListNode(node.val);
                }
                node = null;
            }

            return newList;
        }

        return hashTable;
    }
}
