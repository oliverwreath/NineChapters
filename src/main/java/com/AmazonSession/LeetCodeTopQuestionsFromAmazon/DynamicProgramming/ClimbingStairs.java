package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. The most classic simple DP ever.
 * <p>
 * TIME: O(N)
 * SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
public class ClimbingStairs {
    private final static Logger logger = LoggerFactory.getLogger(ClimbingStairs.class);

    public static void main(String[] args) {
        ClimbingStairs thisClass = new ClimbingStairs();
        thisClass.testClimbingStairs();
    }

    private void testClimbingStairs() {
        logger.info("result {} v.s. {}", "2", climbStairs(2));
        logger.info("result {} v.s. {}", "3", climbStairs(3));
    }

    public int climbStairs(int n) {
        // filter abnormal cases
        if (n < 1) {
            return 1;
        }

        // dp logic
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
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
