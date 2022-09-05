package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Just single loop, get the previous Min and calculate the current Max.
 * <p>
 * TIME: O(N)
 * SPACE: O(1)
 * <p>
 * Version 2: TBD.
 */
@Slf4j
public class LC121BestTimeToBuyAndSellStock {
  public int maxProfit(int[] prices) {
    if (prices == null || prices.length < 2)
      return 0;

    // dp logic
    int maxProfit = 0;
    int min = Integer.MAX_VALUE;
    for (int price : prices) {
      maxProfit = Math.max(maxProfit, price - min);
      min = Math.min(min, price);
    }

    return maxProfit;
  }
}
