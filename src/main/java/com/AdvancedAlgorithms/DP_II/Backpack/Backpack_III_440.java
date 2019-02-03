package com.AdvancedAlgorithms.DP_II.Backpack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Author: Oliver
 * <p>
 * Now every item can use unlimited times.
 * <p>
 * Version 1: Simply Working. Backpack DP.
 * <p>
 * TIME: O(MNN) * due to this unlimited loop
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD. Sliding Array brings the SPACE: O(N)
 */
public class Backpack_III_440 {
    private final static Logger logger = LoggerFactory.getLogger(Backpack_III_440.class);

    public static void main(String[] args) {
        Backpack_III_440 thisClass = new Backpack_III_440();
        thisClass.testBackpack_92();
    }

    private void testBackpack_92() {
        logger.info("result {} v.s. {}", "15", backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
    }

    public int backPackIII(int[] A, int[] V, int m) {
        // filter abnormal cases
        if (A == null || A.length == 0 || V == null || V.length == 0) {
            return 0;
        }

        // dp logic
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        // first row false except the very first one
        Arrays.fill(dp[0], -1);
        dp[0][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            // first col true but 0
            dp[i][0] = 0;
            for (int j = 1; j < m + 1; j++) {
                dp[i][j] = dp[(i - 1)][j];
                int k = 1;
                while (j - k * A[i - 1] >= 0) {
                    if (dp[(i - 1)][j - k * A[i - 1]] != -1) {
                        dp[i][j] = Math.max(dp[i][j], dp[(i - 1)][j - k * A[i - 1]] + k * V[i - 1]);
                    }
                    k++;
                }
            }
        }
        for (int i = 0; i < n + 1; i++) {
            MyLogger.info(Arrays.toString(dp[i]));
        }

        // return the final result
        int max = dp[n][0];
        for (int j = 1; j < m + 1; j++) {
            max = Math.max(max, dp[n][j]);
        }

        return max;
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
