package com.ATemplates_DataStructures.DP.RangeDP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No476_StoneGame {
    private static final Logger logger = LoggerFactory.getLogger(No476_StoneGame.class);

    public static void main(String[] args) {
        No476_StoneGame No476_StoneGame = new No476_StoneGame();
        No476_StoneGame.testNo476_StoneGame();
    }

    private void testNo476_StoneGame() {
        MyLogger.info("result 18 v.s. " + stoneGame(new int[]{4, 1, 1, 4}));
        MyLogger.info("result 8 v.s. " + stoneGame(new int[]{1, 1, 1, 1}));
        MyLogger.info("result 43 v.s. " + stoneGame(new int[]{4, 4, 5, 9}));
    }

    public int stoneGame(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        dp = new int[len][len];
        sum = new int[len][len];
        flag = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            sum[i][i] = A[i];
            for (int j = i + 1; j < len; j++) {
                sum[i][j] = A[j] + sum[i][j - 1];
            }
        }

        // return the final result
        return helper(0, len - 1, A);
    }

    int[][] dp;
    int[][] sum;
    boolean[][] flag;

    int helper(int i, int j, int[] A) {
        if (flag[i][j]) {
            return dp[i][j];
        }
        if (i >= j) {
            return 0;
        }
        flag[i][j] = true;

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, helper(i, k, A) + helper(k + 1, j, A));
        }
        dp[i][j] = sum[i][j] + min;

        return dp[i][j];
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
