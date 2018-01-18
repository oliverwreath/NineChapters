package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No375_GuessNumberHigherOrLowerII {
    private final static Logger logger = LoggerFactory.getLogger(No375_GuessNumberHigherOrLowerII.class);

    public static void main(String[] args) {
        testNo375_GuessNumberHigherOrLowerII();
    }

    private static void testNo375_GuessNumberHigherOrLowerII() {
        No375_GuessNumberHigherOrLowerII No375_GuessNumberHigherOrLowerII = new No375_GuessNumberHigherOrLowerII();
        MyLogger.info("result 1 v.s. " + No375_GuessNumberHigherOrLowerII.getMoneyAmount(2));
        MyLogger.info("result 10 v.s. " + No375_GuessNumberHigherOrLowerII.getMoneyAmount(7));
        MyLogger.info("result 6 v.s. " + No375_GuessNumberHigherOrLowerII.getMoneyAmount(5));
    }

    /**
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        if (n < 2) {
            return 0;
        }

        // core logic
        int[][] dp = new int[n + 1][n + 1];
        for (int T = 1; T < n; T++) {
            for (int start = 1; start <= n - T; start++) {
                int min = Integer.MAX_VALUE;
                for (int k = start + (T) / 2; k < start + T; k++) {
                    min = Math.min(min, k + Math.max(dp[start][k - 1], dp[k + 1][start + T]));
                }
                dp[start][start + T] = min;
            }
        }
        return dp[1][n];
    }

//    /**
//     * @param n
//     * @return
//     */
//    public int getMoneyAmount(int n) {
//        if (n < 2) {
//            return 0;
//        }
//
//        // core logic
//        table = new int[n + 1][n + 1];
//        return dp(1, n);
//    }
//
//    private int[][] table;
//
//    private int dp(int start, int end) {
//        if (start >= end) {
//            return 0;
//        }
//        if (table[start][end] != 0) {
//            return table[start][end];
//        }
//        int min = Integer.MAX_VALUE;
//        for (int i = start; i <= end; i++) {
//            int res = i + Math.max(dp(start, i - 1), dp(i + 1, end));
//            min = Math.min(min, res);
//        }
//        table[start][end] = min;
//
//        return min;
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
