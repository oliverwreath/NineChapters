package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No752_RogueKnightSven {

  public static void main(String[] args) {
    No752_RogueKnightSven No752_RogueKnightSven = new No752_RogueKnightSven();
    No752_RogueKnightSven.testNo752_RogueKnightSven();
  }

  private void testNo752_RogueKnightSven() {
    log.info("result 1 v.s. " + getNumberOfWays(1, 1, 1, new int[]{0, 1}));
    log.info("result 0 v.s. " + getNumberOfWays(1, 1, 1, new int[]{0, 2}));
    log.info("result 2 v.s. " + getNumberOfWays(2, 3, 2, new int[]{0, 1, 1}));
    log.info("result 1 v.s. " + getNumberOfWays(2, 3, 2, new int[]{0, 3, 1}));
  }

  long getNumberOfWays(int n, int m, int limit, int[] cost) {
    // filter abnormal cases
    long[][] dp = new long[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (i == 0) {
          dp[i][j] = j == m ? 1 : 0;
        } else if (j + cost[i] <= m) {
          for (int s = Math.max(i - limit, 0); s < i; s++) {
            dp[i][j] += dp[s][j + cost[i]];
          }
        }
      }
    }

    long answer = 0;
    for (int j = 0; j <= m; j++) {
      answer += dp[n][j];
    }
//        for (int i = 0; i <= n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }

    // return the final result
    return answer;
  }

}
