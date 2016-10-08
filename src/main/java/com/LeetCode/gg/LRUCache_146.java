package com.LeetCode.gg;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class LRUCache_146 {
    private final static Logger logger = LoggerFactory.getLogger(LRUCache_146.class);

    public static void main(String[] arg) {
        new LRUCache_146().testLongestAbsoluteFilePath_388();
    }

    private void testLongestAbsoluteFilePath_388() {
//        logger.info("{}", plusOne(new int[]{}));
//        logger.info("{}", plusOne(new int[]{0}));
//        System.out.println();
//        logger.info("{}", plusOne(new int[]{-1}));
//        logger.info("{}", plusOne(new int[]{-6}));
        LRUCache lruCache = new LRUCache(2);
        logger.info("{}", lruCache.get(2));
        lruCache.set(2, 3);
        logger.info("{}", lruCache.get(2));
        lruCache.set(3, 4);
        lruCache.set(4, 5);
        logger.info("{}", lruCache.get(2));
        logger.info("{}", lruCache.get(3));
        lruCache.set(2, 3);
        logger.info("{}", lruCache.get(4));
    }

    public class LRUCache {
        private int capacity;
        private Map<Integer, Integer> map;
        private Deque<Integer> deque;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<Integer, Integer>();
            this.deque = new ArrayDeque<Integer>();
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                deque.remove(key);
                deque.add(key);
                return map.get(key);
            }
            return -1;
        }

        public void set(int key, int value) {
            if (map.containsKey(key)) {
                // update
                map.put(key, value);
                deque.remove(key);
                deque.add(key);
            } else {
                // check capacity before inserting
                if (map.keySet().size() == this.capacity) {
                    // invalidate
                    int invalidatedKey = deque.poll();
                    map.remove(invalidatedKey);
                }
                // insert
                map.put(key, value);
                deque.add(key);
            }
        }
    }
}
