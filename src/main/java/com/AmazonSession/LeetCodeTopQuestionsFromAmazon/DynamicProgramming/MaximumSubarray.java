package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Just single loop, get the current sum and Max.
 * <p>
 * TIME: O(N)
 * SPACE: O(1)
 * <p>
 * Version 2: TBD.
 */
public class MaximumSubarray {
    private static final Logger logger = LoggerFactory.getLogger(MaximumSubarray.class);

    public static void main(String[] args) {
        MaximumSubarray thisClass = new MaximumSubarray();
        thisClass.testBestTimeToBuyAndSellStock();
    }

    private void testBestTimeToBuyAndSellStock() {
        logger.info("result {} v.s. {}", "6", maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    public int maxSubArray(int[] nums) {
        // filter abnormal cases
        if (nums == null || nums.length < 1) {
            return 0;
        }

        // dp logic
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }

        // return the final result
        return max;
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
