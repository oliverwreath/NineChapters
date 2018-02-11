package com.LeetCode.Weekly63;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No746_MinCostClimbingStairs {
    private final static Logger logger = LoggerFactory.getLogger(No746_MinCostClimbingStairs.class);

    public static void main(String[] args) {
        testNo746_MinCostClimbingStairs();
    }

    private static void testNo746_MinCostClimbingStairs() {
        No746_MinCostClimbingStairs No746_MinCostClimbingStairs = new No746_MinCostClimbingStairs();
        MyLogger.info("result 15 v.s. " + No746_MinCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));
        MyLogger.info("result 6 v.s. " + No746_MinCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    /**
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        // filter abnormal inputs
        if (cost == null || cost.length < 1) {
            return 0;
        }
        if (cost.length < 2) {
            return cost[0];
        }

        // core logic
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        // return result
//        System.out.println(Arrays.toString(dp));
        return Math.min(dp[len - 1], dp[len - 2]);
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
