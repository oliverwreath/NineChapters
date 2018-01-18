package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class No121_BestTimetoBuyandSellStock {
    private final static Logger logger = LoggerFactory.getLogger(No121_BestTimetoBuyandSellStock.class);

    public static void main(String[] arg) {
        new No121_BestTimetoBuyandSellStock().testHouseRobber_198();
    }

    private void testHouseRobber_198() {
        logger.info("{}", maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        logger.info("{}", maxProfit(new int[]{7, 6, 4, 3, 1}));
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
