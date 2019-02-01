package com.AdvancedAlgorithms.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * version 1 - nicely done! it's working!
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
        int[][] dpDown = new int[m][n];
        int[][] dpRight = new int[m][n];
        int[][] dp = new int[m][n];
        dpDown[0][0] = matrix[0][0];
        dpRight[0][0] = matrix[0][0];
        dp[0][0] = matrix[0][0];
        for (int j = 1; j < n; j++) {
            dpDown[0][j] = matrix[0][j] == 1 ? 1 : 0;
            dpRight[0][j] = matrix[0][j] == 1 ? 1 + dpRight[0][j - 1] : 0;
            dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
        }
        for (int i = 1; i < m; i++) {
            dpDown[i][0] = matrix[i][0] == 1 ? 1 + dpDown[i - 1][0] : 0;
            dpRight[i][0] = matrix[i][0] == 1 ? 1 : 0;
            dp[i][0] = matrix[i][0] == 1 ? 1 : 0;
            for (int j = 1; j < n; j++) {
                dpDown[i][j] = matrix[i][j] == 1 ? 1 + dpDown[i - 1][j] : 0;
                dpRight[i][j] = matrix[i][j] == 1 ? 1 + dpRight[i][j - 1] : 0;
                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dpDown[i - 1][j]), dpRight[i][j - 1]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            MyLogger.info(Arrays.toString(dpDown[i]));
        }
        MyLogger.info();
        for (int i = 0; i < m; i++) {
            MyLogger.info(Arrays.toString(dpRight[i]));
        }
        MyLogger.info();
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
