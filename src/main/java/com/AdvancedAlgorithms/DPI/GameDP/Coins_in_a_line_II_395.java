package com.AdvancedAlgorithms.DPI.GameDP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * <p>
 * TIME: O(n)
 * SPACE: O(n)
 */
public class Coins_in_a_line_II_395 {
    private final static Logger logger = LoggerFactory.getLogger(Coins_in_a_line_II_395.class);

    public static void main(String[] args) {
        Coins_in_a_line_II_395 thisClass = new Coins_in_a_line_II_395();
        thisClass.testCoins_in_a_line_II_395();
    }

    private void testCoins_in_a_line_II_395() {
        logger.info("result {} v.s. {}", "true", firstWillWin(new int[]{1, 2, 2}));
        logger.info("result {} v.s. {}", "false", firstWillWin(new int[]{1, 2, 4}));
    }

    public boolean firstWillWin(int[] values) {
        // filter abnormal cases
        if (values == null || values.length == 0) {
            return false;
        }
        if (values.length < 3) {
            return true;
        }

        // dp logic
        int n = values.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = values[n - 1];
        dp[2] = values[n - 2] + values[n - 1];
        dp[3] = values[n - 3] + values[n - 2];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(
                    Math.min(dp[i - 2], dp[i - 3]) + values[n - i],
                    Math.min(dp[i - 3], dp[i - 4]) + values[n - i] + values[n - i + 1]
            );
        }
//        System.out.println(Arrays.toString(dp));

        // return the final result
        return dp[n] >= Math.min(dp[n - 1], dp[n - 2]);
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
