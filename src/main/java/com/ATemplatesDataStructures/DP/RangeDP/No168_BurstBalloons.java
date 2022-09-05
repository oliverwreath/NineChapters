package com.ATemplatesDataStructures.DP.RangeDP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No168_BurstBalloons {
  public static void main(String[] args) {
    No168_BurstBalloons No476_StoneGame = new No168_BurstBalloons();
    No476_StoneGame.testNo476_StoneGame();
  }

  private void testNo476_StoneGame() {
    log.info("result 270 v.s. " + maxCoins(new int[]{4, 1, 5, 10}));
  }

  public int maxCoins(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int len = A.length;
    dp = new int[len][len];
    flag = new boolean[len][len];

    // return the final result
    return helper(0, len - 1, A);
  }

  int[][] dp;
  boolean[][] flag;

  int helper(int i, int j, int[] A) {
    if (i > j) {
      return 0;
    }
    if (flag[i][j]) {
      return dp[i][j];
    }
    flag[i][j] = true;

    if (i == j) {
      dp[i][j] = (i - 1 >= 0 ? A[i - 1] : 1) * A[i] * (j + 1 < A.length ? A[j + 1] : 1);
    } else {
      int max = Integer.MIN_VALUE;
      for (int k = i; k <= j; k++) {
        max = Math.max(max,
                (i - 1 >= 0 ? A[i - 1] : 1) * A[k] * (j + 1 < A.length ? A[j + 1] : 1) +
                        helper(i, k - 1, A) + helper(k + 1, j, A));
      }
      dp[i][j] = max;
    }
    return dp[i][j];
  }

}
