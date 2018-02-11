package com.LeetCode.Weekly49;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LCIS_674 {
    private final static Logger logger = LoggerFactory.getLogger(LCIS_674.class);

    public static void main(String[] args) {
        testLCIS();
    }

    private static void testLCIS() {
        LCIS_674 LCIS_674 = new LCIS_674();
        MyLogger.info("result 3 = " + LCIS_674.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        MyLogger.info("result 1 = " + LCIS_674.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
        MyLogger.info("result 0 = " + LCIS_674.findLengthOfLCIS(new int[]{}));
    }

    /**
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        // filter abnormal cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxLength = 1;
        int n = nums.length;
        int currentLength = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }
        }


        // return the final result
        return maxLength;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
