package com.AdvancedAlgorithms.DP_I;

import lombok.extern.slf4j.Slf4j;

/**
 * version 1 - nicely done! it's working!
 * version 2 - nicely done! One dp array.
 * version 3 - nicely done! Sliding Array.
 */
@Slf4j
public class Lintcode436MaximalSquare {
  public int maxSquare(int[][] matrix) {
    // filter abnormal cases
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return 0;
    }

    int m = matrix.length, n = matrix[0].length;
    int[][] dp = new int[2][n];
    int max = dp[0][0] = matrix[0][0];
    for (int j = 1; j < n; j++) {
      dp[0][j] = matrix[0][j] == 1 ? 1 : 0;
      max = Math.max(max, dp[0][j]);
    }
    for (int i = 1; i < m; i++) {
      dp[i % 2][0] = matrix[i][0] == 1 ? 1 : 0;
      max = Math.max(max, dp[i % 2][0]);
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == 1) {
          dp[i % 2][j] = 1 + Math.min(Math.min(dp[(i - 1) % 2][j - 1], dp[(i - 1) % 2][j]), dp[i % 2][j - 1]);
        } else {
          dp[i % 2][j] = 0;
        }
        max = Math.max(max, dp[i % 2][j]);
      }
    }

    // return the final result
    return max * max;
  }

}
