package com.lintCode.Advanced.DPI;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-29.
 */
public class BestTimeToBuyAndSellStockIV {
    private static final Logger logger = LoggerFactory.getLogger(BestTimeToBuyAndSellStockIV.class);

    public static void main(String[] arg) {
        testBestTimeToBuyAndSellStockIV();
    }

    private static void testBestTimeToBuyAndSellStockIV() {
        logger.info("{}", maxProfit(2, new int[]{4, 4, 6, 1, 1, 4, 2, 5}));
    }

    /**
     * @param k:      An integer
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    static int maxProfit(int k, int[] prices) {
        // write your code here
        // filter abnormal inputs
        if (prices == null || prices.length == 0 || k == 0) {
            return 0;
        }
        if (k >= prices.length / 2) {
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
        int[][] local = new int[n][k + 1];
        int[][] global = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
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
//        System.out.println("local = ");
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(local[i]));
//        }
//        System.out.println("global = ");
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(global[i]));
//        }

        // return the final result
        return global[n - 1][k];
    }
}
