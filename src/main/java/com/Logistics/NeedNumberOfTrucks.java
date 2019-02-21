package com.Logistics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
public class NeedNumberOfTrucks {
    private static final Logger logger = LoggerFactory.getLogger(NeedNumberOfTrucks.class);

    public static void main(String[] args) {
        NeedNumberOfTrucks thisClass = new NeedNumberOfTrucks();
        thisClass.testNeedNumberOfTrucks();
    }

    private void testNeedNumberOfTrucks() {
//        logger.info("result {} v.s. {}", "", longestContinuousIncreasingSubsequence2(new int[][]{
//                {1, 2, 3, 4, 5}
//        }));
    }

    public int functionName(int[][] grid) {
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
