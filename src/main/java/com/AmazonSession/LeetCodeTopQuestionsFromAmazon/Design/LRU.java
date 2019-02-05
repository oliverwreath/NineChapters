package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.Design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

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
        private Deque<Integer> keyList;
        private HashMap<Integer, Integer> hashMap;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.keyList = new LinkedList<>();
            this.hashMap = new HashMap<>();
        }

        public int get(int key) {
            if (hashMap.containsKey(key)) {
                if (keyList.getFirst() != key) {
                    keyList.remove(Integer.valueOf(key));
                    keyList.addFirst(key);
                }
            }
            MyLogger.info("GET: " + keyList);
            return hashMap.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            if (!hashMap.containsKey(key)) {
                // insert
                if (keyList.size() == capacity) {
                    hashMap.remove(keyList.getLast());
                    keyList.removeLast();
                    keyList.addFirst(key);
                } else {
                    keyList.addFirst(key);
                }
                hashMap.put(key, value);
            } else {
                // update
                if (keyList.getFirst() != key) {
                    keyList.remove(Integer.valueOf(key));
                    keyList.addFirst(key);
                }
                hashMap.put(key, value);
            }
            MyLogger.info("PUT: " + keyList);
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
