package com.AdvancedAlgorithms.BinarySearchSweepLineHard.Deque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * deque and space compression. Nicely done!
 */
public class Sliding_window_maximum_362 {
    private final static Logger logger = LoggerFactory.getLogger(Sliding_window_maximum_362.class);

    public static void main(String[] args) {
        Sliding_window_maximum_362 thisClass = new Sliding_window_maximum_362();
        thisClass.testSliding_window_maximum_362();
    }

    private void testSliding_window_maximum_362() {
        logger.info("result {} v.s. {}", "[7,7,8]", maxSlidingWindow(new int[]{1, 2, 7, 7, 8}, 3));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    private Deque<Integer> deque = new ArrayDeque<>();

    private void inQueue(int number) {
        while (!deque.isEmpty() && deque.peekLast() < number) {
            deque.pollLast();
        }
        deque.offer(number);
    }

    private void outQueue(int number) {
        if (!deque.isEmpty() && deque.peekFirst() == number) {
            deque.pollFirst();
        }
    }

    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // filter abnormal cases
        List<Integer> result = new LinkedList<>();
        if (nums == null || nums.length == 0 || k < 1) {
            return result;
        }
        if (k == 1) {
            for (int num : nums) {
                result.add(num);
            }
            return result;
        }

        // Deque with trick
        deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                inQueue(nums[i]);
                continue;
            }

            if (i >= k) {
                outQueue(nums[i - k]);
            }
            inQueue(nums[i]);
            result.add(deque.peekFirst());
        }

        // return the final result
        return result;
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
    }
}
