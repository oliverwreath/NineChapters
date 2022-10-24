package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC121BestTimeToBuyAndSellStock {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2)
      return 0;

    int prefixMin = prices[0];
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      maxProfit = Math.max(maxProfit, prices[i] - prefixMin);
      prefixMin = Math.min(prefixMin, prices[i]);
    }
    return maxProfit;
  }
}
