package com.AdvancedAlgorithms.DP_II.Backpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Backpack DP. MLE ok.
 * <p>
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD. Sliding Array brings the SPACE: O(N)
 */
public class Backpack_92 {
    private final static Logger logger = LoggerFactory.getLogger(Backpack_92.class);

    public static void main(String[] args) {
        Backpack_92 thisClass = new Backpack_92();
        thisClass.testBackpack_92();
    }

    private void testBackpack_92() {
        logger.info("result {} v.s. {}", "10", backPack(11, new int[]{2, 3, 5, 7}));
        logger.info("result {} v.s. {}", "12", backPack(12, new int[]{2, 3, 5, 7}));
        logger.info("result {} v.s. {}", "83", backPack(90, new int[]{12, 3, 7, 4, 5, 13, 2, 8, 4, 7, 6, 5, 7}));
    }

    public int backPack(int m, int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // dp logic
        int n = A.length;
        boolean[][] dp = new boolean[2][m + 1];
        // first row true
        Arrays.fill(dp[0], false);
        dp[0][0] = true;

        for (int i = 1; i < n + 1; i++) {
            // first col true
            dp[i%2][0] = true;
            for (int j = 1; j < m + 1; j++) {
                dp[i%2][j] = dp[(i - 1)%2][j];
                if (j - A[i - 1] >= 0) {
                    dp[i%2][j] |= dp[(i - 1)%2][j - A[i - 1]];
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            MyLogger.info(Arrays.toString(dp[i]));
        }

        // return the final result
        for (int j = m; j >= 0; j--) {
            if (dp[n%2][j]) {
                return j;
            }
        }

        return -1;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = false;
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
