package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No392_HouseRobber {
    private final static Logger logger = LoggerFactory.getLogger(No392_HouseRobber.class);

    public static void main(String[] args) {
        testNo392_HouseRobber();
    }

    private static void testNo392_HouseRobber() {
        No392_HouseRobber No392_HouseRobber = new No392_HouseRobber();
        MyLogger.info("result 8 v.s. " + No392_HouseRobber.houseRobber(new int[]{3, 8, 4}));
    }

    public long houseRobber(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }

        int len = A.length;
        long[] dp = new long[2];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for (int i = 2; i < len; i++) {
            dp[i % 2] = Math.max(dp[(i - 1) % 2], A[i] + dp[(i - 2) % 2]);
        }

        // return the final result
        return dp[(len - 1) % 2];
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
