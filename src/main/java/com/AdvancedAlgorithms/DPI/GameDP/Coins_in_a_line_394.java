package com.AdvancedAlgorithms.DPI.GameDP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Ok actually my math is as good as cheating.
 * <p>
 * TIME: O(1)
 * SPACE: O(1)
 * <p>
 * Version 2: DP Approach Babe!
 * <p>
 * TIME: O(n)
 * SPACE: O(n)
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
        // filter abnormal cases
        if (n <= 0) {
            return false;
        }

        // dp logic
        boolean[] dp = new boolean[Math.max(n + 1, 4)];
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 3];
        }

        // return the final result
        return dp[n];
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
