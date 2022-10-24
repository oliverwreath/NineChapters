package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class CoinsInALineIII {

  public static void main(String[] arg) {
    testCoinsInALine();
  }

  private static void testCoinsInALine() {
    log.info("{}", firstWillWin(new int[]{3, 2, 2}));
    log.info("{}", firstWillWin(new int[]{1, 2, 4}));
    log.info("{}", firstWillWin(new int[]{1, 20, 4}));
  }

  private static long[] sum;
  private static boolean[][] flag;

  /**
   * @param values: an array of integers
   * @return: a boolean which equals to true if the first player will win
   */
  static boolean firstWillWin(int[] values) {

    if (values == null || values.length <= 0) {
      return false;
    }
    if (values.length < 3) {
      return true;
    }

    // fill the subproblems
    int n = values.length;
    sum = new long[n];
    sum[0] = values[0];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + values[i];
    }
    long[][] dp = new long[n][n];
    flag = new boolean[n][n];
    search(0, n - 1, dp, values);

    // print to check before committing
//        log.debug(Arrays.toString(sum));
//        log.debug("dp = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }

    // return the answer
    return (dp[0][n - 1] > dp[1][n - 1] || dp[0][n - 1] > dp[0][n - 2]);
  }

  static long search(int i, int j, long[][] dp, int[] values) {
    if (flag[i][j]) {
      return dp[i][j];
    }
    if (i == j) {
      return values[i];
    }

    dp[i][j] = sum[j] - ((i - 1 < 0) ? 0 : sum[i - 1]);
    dp[i][j] -= Math.min(search(i + 1, j, dp, values), search(i, j - 1, dp, values));
    flag[i][j] = true;
    return dp[i][j];
  }
}
