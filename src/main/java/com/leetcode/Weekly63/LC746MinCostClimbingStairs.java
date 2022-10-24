package com.leetcode.Weekly63;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC746MinCostClimbingStairs {

  public static void main(String[] args) {
    testNo746_MinCostClimbingStairs();
  }

  private static void testNo746_MinCostClimbingStairs() {
    LC746MinCostClimbingStairs LC746MinCostClimbingStairs = new LC746MinCostClimbingStairs();
    log.info("result 15 v.s. " + LC746MinCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));
    log.info("result 6 v.s. " + LC746MinCostClimbingStairs.minCostClimbingStairs(
        new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
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
//        log.debug(Arrays.toString(dp));
    return Math.min(dp[len - 1], dp[len - 2]);
  }

}
