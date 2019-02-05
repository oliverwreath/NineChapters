package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.Design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. HashMap with Deque(LinkedList). But they are not integrated.
 * <p>
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD. Integrated customized DoublyLinkedList.
 */
public class LRU {
    private final static Logger logger = LoggerFactory.getLogger(LRUCache.class);

    public static void main(String[] args) {
        LRU thisClass = new LRU();
        thisClass.testLRU();
    }

    private void testLRU() {
        LRUCache cache = new LRUCache(2 /* capacity */);
        cache.put(1, 1);
        cache.put(2, 2);
        logger.info("result {} v.s. {}", "1", cache.get(1));
        cache.put(3, 3);
        logger.info("result {} v.s. {}", "-1", cache.get(2));
        cache.put(4, 4);
        logger.info("result {} v.s. {}", "-1", cache.get(1));
        logger.info("result {} v.s. {}", "3", cache.get(3));
        logger.info("result {} v.s. {}", "4", cache.get(4));
//        cache.put(1, 1);
//        cache.put(2, 2);
//        cache.get(1);       // returns 1
//        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
//        cache.put(4, 4);    // evicts key 1
//        cache.get(1);       // returns -1 (not found)
//        cache.get(3);       // returns 3
//        cache.get(4);       // returns 4
//        logger.info("result {} v.s. {}", "", longestContinuousIncreasingSubsequence2(new int[][]{
//                {1, 2, 3, 4, 5}
//        }));
    }

    class LRUCache {
        private int capacity;
        private HashMap<Integer, Node> hashMap;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.hashMap = new HashMap<>();
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!hashMap.containsKey(key)) {
                return -1;
            } else {
                Node node = hashMap.get(key);
                refresh(node);
                return hashMap.get(key).val;
            }
        }

        public void put(int key, int value) {
            if (!hashMap.containsKey(key)) {
                // insert
                if (hashMap.size() == capacity) {
                    Node LRUNode = tail.prev;
                    LRUNode.prev.next = LRUNode.next;
                    LRUNode.next.prev = LRUNode.prev;
                    hashMap.remove(LRUNode.key);
                }
                Node node = new Node(key, value);
                Node next = head.next;
                head.next = node;
                node.prev = head;
                next.prev = node;
                node.next = next;
                hashMap.put(key, node);
            } else {
                // update
                Node node = hashMap.get(key);
                node.val = value;
                refresh(node);
            }
        }

        private void refresh(Node node) {
            if (node.prev != head) {
                node.prev.next = node.next;
                node.next.prev = node.prev;
                Node next = head.next;
                head.next = node;
                node.prev = head;
                next.prev = node;
                node.next = next;
            }
        }

        class Node {
            Node prev;
            Node next;
            int key;
            int val;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }

            public Node(Node prev, Node next, int key, int val) {
                this.prev = prev;
                this.next = next;
                this.key = key;
                this.val = val;
            }

            @Override
            public String toString() {
                return "Node{" +
                        "prev=" + prev +
                        ", next=" + next +
                        ", val=" + val +
                        '}';
            }
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = false;
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
