package com.AdvancedAlgorithms.GameDP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Ok actually my math is as good as cheating.
 * <p>
 * TIME: O(1)
 * SPACE: O(1)
 */
public class Coins_in_a_line_394 {
    private final static Logger logger = LoggerFactory.getLogger(Coins_in_a_line_394.class);

    public static void main(String[] args) {
        Coins_in_a_line_394 thisClass = new Coins_in_a_line_394();
        thisClass.testCoins_in_a_line_394();
    }

    private void testCoins_in_a_line_394() {
        logger.info("result {} v.s. {}", "true", firstWillWin(1));
        logger.info("result {} v.s. {}", "true", firstWillWin(2));
        logger.info("result {} v.s. {}", "false", firstWillWin(3));
        logger.info("result {} v.s. {}", "true", firstWillWin(4));
        logger.info("result {} v.s. {}", "true", firstWillWin(5));
    }

    public boolean firstWillWin(int n) {
        return ! (n % 3 == 0);
        // filter abnormal cases
//        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
//            return 0;
//        }
//
//        // dp logic
//        int m = grid.length, n = grid[0].length;
//        int[][] dp = new int[2][n];
//
//        // return the final result
//        return -1;
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
