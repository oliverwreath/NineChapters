package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BestTimeToBuyAndSellStockIII {

  public static void main(String[] arg) {
    testBestTimeToBuyAndSellStockIV();
  }

  private static void testBestTimeToBuyAndSellStockIV() {
    log.info("{}", maxProfit(new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
  }

  /**
   * @param prices: Given an integer array
   * @return: Maximum profit
   */
  static int maxProfit(int[] prices) {

    // filter abnormal inputs
    if (prices == null || prices.length == 0) {
      return 0;
    }
    if (2 >= prices.length / 2) {
      int profit = 0;
      for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i - 1]) {
          profit += prices[i] - prices[i - 1];
        }
      }
      return profit;
    }

    // fill subproblem results
    int n = prices.length;
    int[][] local = new int[n][2 + 1];
    int[][] global = new int[n][2 + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j <= 2; j++) {
        if (i == 0 || j == 0) {
          local[i][j] = global[i][j] = 0;
        } else {
          int gainOrLoss = prices[i] - prices[i - 1];
          local[i][j] = Math.max(global[i - 1][j - 1] + gainOrLoss, local[i - 1][j] + gainOrLoss);
          global[i][j] = Math.max(local[i][j], global[i - 1][j]);
        }
      }
    }

    // print to check before committing
//        log.debug("local = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(local[i]));
//        }
//        log.debug("global = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(global[i]));
//        }

    // return the final result
    return global[n - 1][2];
  }
}
