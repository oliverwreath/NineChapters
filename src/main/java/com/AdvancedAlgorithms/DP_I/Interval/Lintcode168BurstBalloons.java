package com.AdvancedAlgorithms.DP_I.Interval;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Ok w/ memoization.
 * <p>
 * TIME: O(NNN)
 * SPACE: O(NN)
 */
@Slf4j
public class Lintcode168BurstBalloons {
  private long[][] dp;

  public int maxCoins(int[] nums) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // dp logic
    int n = nums.length;
    int[] newNums = new int[n + 2];
    newNums[0] = 1;
    newNums[n + 1] = 1;
    System.arraycopy(nums, 0, newNums, 1, n);
    dp = new long[n + 1][n + 2];
    for (int i = 0; i < n + 1; i++) {
      Arrays.fill(dp[i], -1);
    }

    // return the final result
    return (int) search(newNums, 0, n + 1);
  }

  private long search(int[] newNums, int start, int end) {
    if (dp[start][end] != -1) {
      return dp[start][end];
    }
    if (start + 1 == end) {
      dp[start][end] = 0;
      return dp[start][end];
    }

    for (int k = start + 1; k < end; k++) {
      dp[start][end] = Math.max(dp[start][end],
              search(newNums, start, k) + search(newNums, k, end) + (long) newNums[start] * newNums[k] * newNums[end]);
    }
    return dp[start][end];
  }

}
