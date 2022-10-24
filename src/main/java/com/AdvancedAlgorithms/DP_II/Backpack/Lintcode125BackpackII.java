package com.AdvancedAlgorithms.DP_II.Backpack;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Now every item has different values.
 * <p>
 * Version 1: Simply Working. Backpack DP. MLE ok.
 * <p>
 * TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. Sliding Array brings the SPACE: O(N)
 */
@Slf4j
public class Lintcode125BackpackII {

  public int backPackII(int m, int[] a, int[] v) {
    // filter abnormal cases
    if (a == null || a.length == 0 || v == null || v.length == 0) {
      return 0;
    }

    // dp logic
    int n = a.length;
    int[][] dp = new int[n + 1][m + 1];
    // first row false except the very first one
    Arrays.fill(dp[0], -1);
    dp[0][0] = 0;

    for (int i = 1; i < n + 1; i++) {
      // first col true but 0
      dp[i][0] = 0;
      for (int j = 1; j < m + 1; j++) {
        dp[i][j] = dp[(i - 1)][j];
        if (j - a[i - 1] >= 0 && dp[(i - 1)][j - a[i - 1]] != -1) {
          dp[i][j] = Math.max(dp[i][j], dp[(i - 1)][j - a[i - 1]] + v[i - 1]);
        }
      }
    }
//    for (int i = 0; i < n + 1; i++) {
//      log.info(Arrays.toString(dp[i]));
//    }

    // return the final result
    int max = dp[n][0];
    for (int j = 1; j < m + 1; j++) {
      max = Math.max(max, dp[n][j]);
    }

    return max;
  }

}
