package com.AdvancedAlgorithms.DP_I;

import lombok.extern.slf4j.Slf4j;

/**
 * nicely done!
 * Also sliding Array trick. Be careful that you can't initialize the first column at once now. You need to embedded it in the row scanning.
 */
@Slf4j
public class Lintcode110MinimumPathSum {
  public int minPathSum(int[][] grid) {
    // filter abnormal cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length, n = grid[0].length;
    long[][] dp = new long[2][n];
    dp[0][0] = grid[0][0];
    for (int j = 1; j < n; j++) {
      dp[0][j] = grid[0][j] + dp[0][j - 1];
    }
    for (int i = 1; i < m; i++) {
      dp[i % 2][0] = grid[i][0] + dp[(i - 1) % 2][0];
      for (int j = 1; j < n; j++) {
        dp[i % 2][j] = grid[i][j] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
      }
    }

    // return the final result
    return (int) dp[(m - 1) % 2][n - 1];
  }

}
