package com.NineChapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClassicalBinarySearch_457 {
    private final static Logger logger = LoggerFactory.getLogger(ClassicalBinarySearch_457.class);

    public static void main(String[] args) {
        ClassicalBinarySearch_457 ClassicalBinarySearch_457 = new ClassicalBinarySearch_457();
        ClassicalBinarySearch_457.testClassicalBinarySearch_457();
    }

    private void testClassicalBinarySearch_457() {
        logger.info("result 1/2 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 2));
        logger.info("result 4/5 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 5));
        logger.info("result -1 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 6));
    }

    public int findPosition(int[] nums, int target) {
        // filter abnormal cases
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        // return the final result
        return -1;
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
