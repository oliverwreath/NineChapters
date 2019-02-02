package com.AdvancedAlgorithms.DPI.Interval;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Ok w/ memoization.
 * <p>
 * TIME: O(NNN)
 * SPACE: O(NN)
 */
public class Burst_balloons_168 {
    private final static Logger logger = LoggerFactory.getLogger(Burst_balloons_168.class);

    public static void main(String[] args) {
        Burst_balloons_168 thisClass = new Burst_balloons_168();
        thisClass.testBurst_balloons_168();
    }

    private void testBurst_balloons_168() {
        logger.info("result {} v.s. {}", "270", maxCoins(new int[]{4, 1, 5, 10}));
    }

    private long[][] dp;

    public int maxCoins(int[] nums) {
        // filter abnormal cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp logic
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        System.arraycopy(nums, 0, newNums, 1, n);
        dp = new long[n + 1][n + 2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

        // return the final result
        return (int) search(newNums, 0, n + 1);
    }

    private long search(int[] newNums, int start, int end) {
        if (dp[start][end] != -1) {
            return dp[start][end];
        }
        if (start + 1 == end) {
            dp[start][end] = 0;
            return dp[start][end];
        }

        for (int k = start + 1; k < end; k++) {
            dp[start][end] = Math.max(dp[start][end], search(newNums, start, k) + search(newNums, k, end) + newNums[start] * newNums[k] * newNums[end]);
        }
        return dp[start][end];
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
