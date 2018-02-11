package com.ATemplates_DataStructures.DP.memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No397_LongestIncreasingContinuousSubsequence {
    private final static Logger logger = LoggerFactory.getLogger(No397_LongestIncreasingContinuousSubsequence.class);

    public static void main(String[] args) {
        testNo397_LongestIncreasingContinuousSubsequence();
    }

    private static void testNo397_LongestIncreasingContinuousSubsequence() {
        No397_LongestIncreasingContinuousSubsequence No397_LongestIncreasingContinuousSubsequence = new No397_LongestIncreasingContinuousSubsequence();
        MyLogger.info("result 4 v.s. " + No397_LongestIncreasingContinuousSubsequence.longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
        MyLogger.info("result 4 v.s. " + No397_LongestIncreasingContinuousSubsequence.longestIncreasingContinuousSubsequence(new int[]{5, 1, 2, 3, 4}));
    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        int len = A.length;
        int max = 0;
        int counter = 1;
        for (int i = 1; i < len; i++) {
            if (A[i] > A[i - 1]) {
                counter++;
            } else {
                max = Math.max(max, counter);
                counter = 1;
            }
        }
        max = Math.max(max, counter);

        int max2 = 0;
        counter = 1;
        for (int i = len - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                counter++;
            } else {
                max2 = Math.max(max2, counter);
                counter = 1;
            }
        }
        max2 = Math.max(max2, counter);

        // return the final result
        return Math.max(max, max2);
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
