package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class No198_HouseRobber {
    private static final Logger logger = LoggerFactory.getLogger(No198_HouseRobber.class);

    public static void main(String[] arg) {
        new No198_HouseRobber().testHouseRobber_198();
    }

    private void testHouseRobber_198() {
        logger.info("{}", rob(new int[]{2, 5, 1}));
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        long answer = 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
//        int max = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
//            max = Math.max(max, dp[i]);
        }

        return dp[n - 1];
    }
}
