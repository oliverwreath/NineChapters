package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class CoinsInALine {

  public static void main(String[] arg) {
    testCoinsInALine();
  }

  private static void testCoinsInALine() {
    log.info("{}", firstWillWin(5));
    log.info("{}", firstWillWin(6));
    log.info("{}", firstWillWin(7));
    log.info("{}", firstWillWin(8));
    log.info("{}", firstWillWin(9));
  }

  private static boolean[] dp = new boolean[10000];

  /**
   * @param n: an integer
   * @return: a boolean which equals to true if the first player will win
   */
  static boolean firstWillWin(int n) {

    if (n < 1) {
      return false;
    }

    // fill the subproblems
    dp[1] = true;
    dp[2] = true;
    for (int i = 3; i <= n; i++) {
      dp[i] = (!dp[i - 1]) || (!dp[i - 2]);
    }

    // return the answer
    return dp[n];
  }
}
