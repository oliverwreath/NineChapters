package com.AdvancedAlgorithms.DP_I.GameDP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Ok actually my math is as good as cheating.
 * <p>
 * TIME: O(1) SPACE: O(1)
 * <p>
 * Version 2: DP Approach Babe!
 * <p>
 * TIME: O(n) SPACE: O(n)
 */
@Slf4j
public class Lintcode394CoinsInALine {

  public boolean firstWillWin(int n) {
    // filter abnormal cases
    if (n <= 0) {
      return false;
    }

    // dp logic
    boolean[] dp = new boolean[Math.max(n + 1, 4)];
    dp[1] = true;
    dp[2] = true;
    dp[3] = false;
    for (int i = 4; i <= n; i++) {
      dp[i] = dp[i - 3];
    }

    // return the final result
    return dp[n];
  }

}
