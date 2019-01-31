package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Sliding_window_median_360 {
    private final static Logger logger = LoggerFactory.getLogger(Sliding_window_median_360.class);

    public static void main(String[] args) {
        testFind_median_from_data_stream_81();
    }

    private static void testFind_median_from_data_stream_81() {
        logger.info("result {} v.s. {}", "[2,7,7]", medianSlidingWindow(new int[]{1, 2, 7, 8, 5}, 3));
        logger.info("result {} v.s. {}", "[1,2,7,2,2,3,3,4]", medianSlidingWindow(new int[]{1, 2, 7, 7, 2, 10, 3, 4, 5}, 2));
    }

    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public static List<Integer> medianSlidingWindow(int[] nums, int k) {
        // filter abnormal cases
        if (nums == null || nums.length == 0 || k < 1) {
            return new LinkedList<>();
        }
        if (k == 1) {
            List<Integer> list = new LinkedList<>();
            for (int num : nums) {
                list.add(num);
            }
            return list;
        }

        List<Integer> result = new LinkedList<>();
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < k; i++) {
            addAndBalance(nums[i]);
        }
        result.add(maxHeap.peek());

        for (int i = k; i < nums.length; i++) {
            addRemoveAndbalance(nums[i], nums[i - k]);
            result.add(maxHeap.peek());
        }

        // return the final result
        return result;
    }

    private static void addRemoveAndbalance(int num, int toBeDeleted) {
        removeAndBalance(toBeDeleted);
        addAndBalance(num);
    }

    private static void removeAndBalance(int toBeDeleted) {
        if (!minHeap.isEmpty()) {
            if (maxHeap.isEmpty()){
                minHeap.remove(toBeDeleted);
            } else {
                if (minHeap.peek() > toBeDeleted) {
                    maxHeap.remove(toBeDeleted);
                } else {
                    minHeap.remove(toBeDeleted);
                }
            }
        }
        balance();
    }

    private static void addAndBalance(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
        } else {
            if (maxHeap.peek() < num) {
                minHeap.add(num);
            } else {
                maxHeap.add(num);
            }
        }
        balance();
    }

    private static void balance() {
        while (!minHeap.isEmpty() && maxHeap.size() < minHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }

        while (!maxHeap.isEmpty() && maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        }
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
