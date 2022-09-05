package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class UniquePaths {
  public static void main(String[] arg) {
    testUniquePaths();
  }

  private static void testUniquePaths() {
    log.info("{}", uniquePaths(3, 7));
  }

  /**
   * @param n, m: positive integer (1 <= n ,m <= 100)
   * @return an integer
   */
  static int uniquePaths(int m, int n) {

    // filter abnormal inputs
    if (m < 1 || n < 1) {
      return 0;
    }
    if (m == 1 || n == 1) {
      return 1;
    }

    // fill subproblem results
    long[][] dp = new long[2][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || j == 0) {
          dp[i % 2][j] = 1;
        } else {
          dp[i % 2][j] = dp[(i - 1) % 2][j] + dp[i % 2][j - 1];
        }
      }
    }

    // print to check before committing
//        for (int i = 0; i < m; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }

    // return the final result
    return (int) dp[(m - 1) % 2][n - 1];
  }
}
