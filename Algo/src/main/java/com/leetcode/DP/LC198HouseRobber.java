package com.leetcode.DP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC198HouseRobber {

  public static void main(String[] arg) {
    new LC198HouseRobber().testHouseRobber_198();
  }

  private void testHouseRobber_198() {
    log.info("{}", rob(new int[]{2, 5, 1}));
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
