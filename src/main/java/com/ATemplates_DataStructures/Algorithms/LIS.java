package com.ATemplates_DataStructures.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LIS {
    private static final Logger logger = LoggerFactory.getLogger(LIS.class);

    public static void main(String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            if (N < 1) {
                System.out.println(0);
                continue;
            }
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }

            // DP
            int[] dp = new int[N];
            dp[0] = 1;
            int globalMax = 1;
            for (int i = 1; i < N; i++) {
                dp[i] = 1;
                int max = 0;
                for (int j = 0; j < i; j++) {
                    if (A[j] < A[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] += max;
                globalMax = Math.max(globalMax, dp[i]);
            }
//            System.out.println(Arrays.toString(dp));

            System.out.println(globalMax);
        }
    }

//    private static void testLIS() {
//        LIS LIS = new LIS();
//        MyLogger.info("result 2 v.s. " + LIS.longestIncreasingContinuousSubsequence("12"));
//        MyLogger.info("result 1 v.s. " + LIS.longestIncreasingContinuousSubsequence("10"));
//    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
    }

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
