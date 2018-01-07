package com.lintCode.DPCourse;

import java.util.Arrays;

/**
 * Created by yanli on 2017-07-06.
 */
public class PaintHouse {
    public static void main(String[] args) {
        PaintHouse paintHouse = new PaintHouse();
        int[][] costs = {{14, 2, 11}, {
                11, 14, 5}, {
                14, 3, 10}};
        MyLogger.debug("10 = " + paintHouse.minCost(costs));
    }

    public int minCost(int[][] costs) {
        // Write your code here
        if (costs == null || costs.length < 1 || costs[0] == null || costs[0].length < 1) {
            return 0;
        }

        // initialize
        int m = costs.length;
        int[][] dp = new int[m][3];
        for (int j = 0; j < 3; j++) {
            dp[0][j] = costs[0][j];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i][2];
        }

        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(dp[i]));
        }
        return Math.min(Math.min(dp[m - 1][0], dp[m - 1][1]), dp[m - 1][2]);
    }

    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
