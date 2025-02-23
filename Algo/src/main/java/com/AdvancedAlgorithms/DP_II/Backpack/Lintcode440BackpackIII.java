package com.AdvancedAlgorithms.DP_II.Backpack;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Now every item can use unlimited times.
 * <p>
 * Version 1: Simply Working. Backpack DP.
 * <p>
 * TIME: O(MNN) * due to this unlimited loop SPACE: O(MN)
 * <p>
 * Version 2: TBD. Sliding Array brings the SPACE: O(N)
 */
@Slf4j
public class Lintcode440BackpackIII {

  public int backPackIII(int[] a, int[] v, int m) {
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
        int k = 1;
        while (j - k * a[i - 1] >= 0) {
          if (dp[(i - 1)][j - k * a[i - 1]] != -1) {
            dp[i][j] = Math.max(dp[i][j], dp[(i - 1)][j - k * a[i - 1]] + k * v[i - 1]);
          }
          k++;
        }
      }
    }
    for (int i = 0; i < n + 1; i++) {
      log.info(Arrays.toString(dp[i]));
    }

    // return the final result
    int max = dp[n][0];
    for (int j = 1; j < m + 1; j++) {
      max = Math.max(max, dp[n][j]);
    }

    return max;
  }

}
