package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No668_OnesAndZeroes {
    private static final Logger logger = LoggerFactory.getLogger(No668_OnesAndZeroes.class);

    public static void main(String[] args) {
        No668_OnesAndZeroes No668_OnesAndZeroes = new No668_OnesAndZeroes();
        No668_OnesAndZeroes.testNo668_OnesAndZeroes();
    }

    private void testNo668_OnesAndZeroes() {
        MyLogger.info("result 4 v.s. " + findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }

    int findMaxForm(String[] A, int m, int n) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        this.A = A;
        this.flag = new boolean[A.length];
        this.dp = new int[A.length + 1][m + 1][n + 1];
        for (int i = 1; i <= A.length; i++) {
            int[] cost = getCost(i - 1);
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    if (cost[0] <= j && cost[1] <= k) {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], 1 + dp[i - 1][j - cost[0]][k - cost[1]]);
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }

        return dp[A.length][m][n];
    }

    private int[] getCost(int i) {
        int[] cost = new int[2];
        for (int index = 0; index < A[i].length(); index++) {
            if (A[i].charAt(index) == '0') {
                cost[0]++;
            } else {
                cost[1]++;
            }
        }
        return cost;
    }

    String[] A;
    boolean[] flag;
    int[][][] dp;

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
