package com.NineChapters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstPositionOfTarget_14 {
    private final static Logger logger = LoggerFactory.getLogger(FirstPositionOfTarget_14.class);

    public static void main(String[] args) {
        testFirstPositionOfTarget_14();
    }

    private static void testFirstPositionOfTarget_14() {
        logger.info("result 0 v.s. {}", binarySearch(new int[]{1,4,4,5,7,7,8,9,9,10}, 1));
        logger.info("result 2 v.s. {}", binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 3));
        logger.info("result -1 v.s. {}", binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 6));
    }

    public static int binarySearch(int[] nums, int target) {
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

        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
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
