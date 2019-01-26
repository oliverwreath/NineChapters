package com.NineChapters.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LastPositionOfTarget_458 {
    private final static Logger logger = LoggerFactory.getLogger(LastPositionOfTarget_458.class);

    public static void main(String[] args) {
        testFirstPositionOfTarget_14();
    }

    private static void testFirstPositionOfTarget_14() {
        logger.info("result 2 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 2));
        logger.info("result 5 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 5));
        logger.info("result -1 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 6));
    }

    public static int lastPosition(int[] nums, int target) {
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
                left = mid;
            }
        }

        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
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
