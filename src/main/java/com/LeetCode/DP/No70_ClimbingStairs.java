package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class No70_ClimbingStairs {
    private static final Logger logger = LoggerFactory.getLogger(No70_ClimbingStairs.class);

    public static void main(String[] arg) {
        new No70_ClimbingStairs().testHouseRobber_198();
    }

    private void testHouseRobber_198() {
        logger.info("{}", climbStairs(-1));
        logger.info("{}", climbStairs(0));
        logger.info("{}", climbStairs(1));
        logger.info("{}", climbStairs(2));
        logger.info("{}", climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 1) {
            return 1;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
