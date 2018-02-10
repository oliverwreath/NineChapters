package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No436_MaximalSquare {
    private final static Logger logger = LoggerFactory.getLogger(No436_MaximalSquare.class);

    public static void main(String[] args) {
        testNo392_HouseRobber();
    }

    private static void testNo392_HouseRobber() {
        No436_MaximalSquare No392_HouseRobber = new No436_MaximalSquare();
        MyLogger.info("result 1 v.s. " + No392_HouseRobber.maxSquare(new int[][]{
                {1}
        }));
    }

    public int maxSquare(int[][] matrix) {
        // filter abnormal cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = matrix[0][0];
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
            max = Math.max(max, dp[0][j]);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // return the final result
        return max * max;
    }

//    public long houseRobber(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        if (A.length == 1) {
//            return A[0];
//        }
//
//        int len = A.length;
//        long[] dp = new long[len];
//        dp[0] = A[0];
//        dp[1] = Math.max(A[0], A[1]);
//        for (int i = 2; i < len; i++) {
//            dp[i] = Math.max(dp[i - 1], A[i] + dp[i - 2]);
//        }
//
//        // return the final result
//        return dp[len - 1];
//    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
