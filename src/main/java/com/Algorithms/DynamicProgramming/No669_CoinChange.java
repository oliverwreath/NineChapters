package com.Algorithms.DynamicProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No669_CoinChange {
    private final static Logger logger = LoggerFactory.getLogger(No669_CoinChange.class);

    public static void main(String[] args) {
        testNo669_coinChange();
    }

    private static void testNo669_coinChange() {
        No669_CoinChange No669_CoinChange = new No669_CoinChange();
//        MyLogger.info("result -1 v.s. " + No669_CoinChange.coinChange(new int[]{}, 11));
//        MyLogger.info("result 3 v.s. " + No669_CoinChange.coinChange(new int[]{1, 2, 5}, 11));
        MyLogger.info("result 2 v.s. " + No669_CoinChange.coinChange(new int[]{0, 1, 1, 1, 8}, 9));
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null || coins.length < 1) {
            return amount == 0 ? 0 : -1;
        }

        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (coin > 0 && i - coin >= 0 && dp[i - coin] < Integer.MAX_VALUE) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min;
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
