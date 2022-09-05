package com.leetcode.DP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC70ClimbingStairs {
  public static void main(String[] arg) {
    new LC70ClimbingStairs().testHouseRobber_198();
  }

  private void testHouseRobber_198() {
    log.info("{}", climbStairs(-1));
    log.info("{}", climbStairs(0));
    log.info("{}", climbStairs(1));
    log.info("{}", climbStairs(2));
    log.info("{}", climbStairs(3));
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
