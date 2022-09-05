package com.leetcode.DP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC121BestTimetoBuyandSellStock {
  public static void main(String[] arg) {
    new LC121BestTimetoBuyandSellStock().testHouseRobber_198();
  }

  private void testHouseRobber_198() {
    log.info("{}", maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    log.info("{}", maxProfit(new int[]{7, 6, 4, 3, 1}));
  }

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }

    int n = prices.length;
    int min = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < n; i++) {
      min = Math.min(min, prices[i]);
      maxProfit = Math.max(maxProfit, prices[i] - min);
    }

    return maxProfit;
  }
}
