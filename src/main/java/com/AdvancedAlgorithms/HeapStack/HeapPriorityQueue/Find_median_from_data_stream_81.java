package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class Find_median_from_data_stream_81 {
    private final static Logger logger = LoggerFactory.getLogger(Find_median_from_data_stream_81.class);

    public static void main(String[] args) {
        testFind_median_from_data_stream_81();
    }

    private static void testFind_median_from_data_stream_81() {
        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", medianII(new int[]{1, 2, 3, 4, 5}));
        logger.info("result {} v.s. {}", "[4, 4, 4, 3, 3, 3, 3]", medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
        logger.info("result {} v.s. {}", "[2, 2, 20]", medianII(new int[]{2, 20, 100}));
    }

    public static int[] medianII(int[] nums) {
        // filter abnormal cases
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int[] result = new int[nums.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int i = 0;
        for (int num : nums) {
            if (maxHeap.isEmpty()) {
                maxHeap.add(num);
            } else {
                if (maxHeap.size() <= minHeap.size()) {
                    if (num <= minHeap.peek()) {
                        maxHeap.add(num);
                    } else {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    }
                } else {
                    if (num >= maxHeap.peek()) {
                        minHeap.add(num);
                    } else {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    }
                }
            }
            result[i++] = maxHeap.peek();
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
