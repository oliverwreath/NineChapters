package com.AdvancedAlgorithms.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * version 1 - nicely done! it's working!
 * version 2 - nicely done! One dp array.
 */
public class MaximalSquare_436 {
    private final static Logger logger = LoggerFactory.getLogger(MaximalSquare_436.class);

    public static void main(String[] args) {
        MaximalSquare_436 thisClass = new MaximalSquare_436();
        thisClass.testMaximalSquare_436();
    }

    private void testMaximalSquare_436() {
        logger.info("result {} v.s. {}", "4", maxSquare(new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        }));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    public int maxSquare(int[][] matrix) {
        // filter abnormal cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            MyLogger.info(Arrays.toString(dp[i]));
        }

        int max = dp[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dp[i][j]);
            }
        }

        // return the final result
        return max * max;
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
