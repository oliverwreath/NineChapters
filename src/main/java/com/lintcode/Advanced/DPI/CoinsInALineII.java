package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class CoinsInALineII {
  public static void main(String[] arg) {
    testCoinsInALine();
  }

  private static void testCoinsInALine() {
    log.info("{}", firstWillWin(new int[]{1, 2, 2}));
    log.info("{}", firstWillWin(new int[]{1, 2, 4}));
  }

  private static long[] dp = new long[100000];
  private static long[] sum = new long[100000];

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
    sum[0] = values[n - 1];
    for (int i = 1; i < n; i++) {
      sum[i] = sum[i - 1] + values[n - 1 - i];
    }
    dp[0] = values[n - 1];
    dp[1] = (long) values[n - 1] + values[n - 2];
    for (int i = 2; i < n; i++) {
      dp[i] = sum[i] - Math.min(dp[i - 1], dp[i - 2]);
    }

    // print to check before committing
//        log.debug(Arrays.toString(sum));
//        log.debug(Arrays.toString(dp));

    // return the answer
    return (dp[n - 1] > dp[n - 2] || dp[n - 1] > dp[n - 3]);
  }
}
