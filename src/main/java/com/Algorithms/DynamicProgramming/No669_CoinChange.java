package com.Algorithms.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No669_CoinChange {
  public static void main(String[] args) {
    testNo669_coinChange();
  }

  private static void testNo669_coinChange() {
    No669_CoinChange No669_CoinChange = new No669_CoinChange();
//        log.info("result -1 v.s. " + No669_CoinChange.coinChange(new int[]{}, 11));
//        log.info("result 3 v.s. " + No669_CoinChange.coinChange(new int[]{1, 2, 5}, 11));
    log.info("result 2 v.s. " + No669_CoinChange.coinChange(new int[]{0, 1, 1, 1, 8}, 9));
  }

  /**
   * @param coins
   * @param amount
   * @return
   */
  public int coinChange(int[] coins, int amount) {

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

}
