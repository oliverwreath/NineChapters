package com.lintcode.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
@Slf4j
public class ClimbingStairsII {
  public static void main(String[] args) {
    testClimbStairs();
  }

  private static void testClimbStairs() {
    ClimbingStairsII climbingStairsII = new ClimbingStairsII();
    for (int i = 0; i < 8; i++) {
      log.info("{}", climbingStairsII.climbStairs2(i));
    }
  }

  /**
   * @param n an integer
   * @return an integer
   */
  public int climbStairs2(int n) {

    if (n < 2) {
      return 1;
    } else if (n < 3) {
      return 2;
    }

    int[] dp = new int[n];
    dp[0] = 1;
    dp[1] = 2;
    dp[2] = 4;
    for (int i = 3; i < n; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    return dp[n - 1];
  }
}
