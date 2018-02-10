package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No114_UniquePaths {
    private final static Logger logger = LoggerFactory.getLogger(No114_UniquePaths.class);

    public static void main(String[] args) {
        testNo392_HouseRobber();
    }

    private static void testNo392_HouseRobber() {
        No114_UniquePaths No392_HouseRobber = new No114_UniquePaths();
        MyLogger.info("result 6 v.s. " + No392_HouseRobber.uniquePaths(3, 3));
        MyLogger.info("result 35 v.s. " + No392_HouseRobber.uniquePaths(4, 5));
    }

    public int uniquePaths(int m, int n) {
        // filter abnormal cases
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] dp = new int[2][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i % 2][j] = 1;
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
                }
            }
        }

        // return the final result
        return dp[(m - 1) % 2][n - 1];
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
