package com.AdvancedAlgorithms.DP_I.GameDP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * <p>
 * TIME: O(n)
 * SPACE: O(n)
 */
@Slf4j
public class Lintcode395CoinsInALineII {
  public boolean firstWillWin(int[] values) {
    // filter abnormal cases
    if (values == null || values.length == 0) {
      return false;
    }
    if (values.length < 3) {
      return true;
    }

    // dp logic
    int n = values.length;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = values[n - 1];
    dp[2] = values[n - 2] + values[n - 1];
    dp[3] = values[n - 3] + values[n - 2];
    for (int i = 4; i <= n; i++) {
      dp[i] = Math.max(
              Math.min(dp[i - 2], dp[i - 3]) + values[n - i],
              Math.min(dp[i - 3], dp[i - 4]) + values[n - i] + values[n - i + 1]
      );
    }
//        log.debug(Arrays.toString(dp));

    // return the final result
    return dp[n] >= Math.min(dp[n - 1], dp[n - 2]);
  }

}
