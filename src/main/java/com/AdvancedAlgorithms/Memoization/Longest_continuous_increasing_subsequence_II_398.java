package com.AdvancedAlgorithms.Memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * version 1: Simply working.
 */
public class Longest_continuous_increasing_subsequence_II_398 {
    private final static Logger logger = LoggerFactory.getLogger(Longest_continuous_increasing_subsequence_II_398.class);

    public static void main(String[] args) {
        Longest_continuous_increasing_subsequence_II_398 thisClass = new Longest_continuous_increasing_subsequence_II_398();
        thisClass.testLongest_continuous_increasing_subsequence_II_398();
    }

    private void testLongest_continuous_increasing_subsequence_II_398() {
        logger.info("result {} v.s. {}", "25", longestContinuousIncreasingSubsequence2(new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 24, 23, 6},
                {15, 18, 25, 22, 7},
                {14, 19, 20, 21, 8},
                {13, 12, 11, 10, 9}
        }));
    }

    public int longestContinuousIncreasingSubsequence2(int[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // dp logic
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[2][n];

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
