package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. The most classic simple DP ever.
 * <p>
 * TIME: O(N) SPACE: O(N)
 * <p>
 * Version 2: TBD.
 */
@Slf4j
public class LC70ClimbingStairs {

  public int climbStairs(int n) {
    if (n < 1) {
      return 1;
    }

    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }

    return dp[n];
  }
}
