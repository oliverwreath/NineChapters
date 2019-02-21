package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class BestTimeToBuyAndSellStock {
    private static final Logger logger = LoggerFactory.getLogger(BestTimeToBuyAndSellStock.class);

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock thisClass = new BestTimeToBuyAndSellStock();
        thisClass.testBestTimeToBuyAndSellStock();
    }

    private void testBestTimeToBuyAndSellStock() {
        logger.info("result {} v.s. {}", "5", maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        logger.info("result {} v.s. {}", "0", maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    public int maxProfit(int[] prices) {
        // filter abnormal cases
        if (prices == null || prices.length < 1) {
            return 0;
        }

        // dp logic
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (i > 0) {
                max = Math.max(max, price - min);
            }

            if (price < min) {
                min = price;
            }
        }

        // return the final result
        return max;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
