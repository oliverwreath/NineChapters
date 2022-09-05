package com.ATemplatesDataStructures.DP.RangeDP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No476_StoneGame {
  public static void main(String[] args) {
    No476_StoneGame No476_StoneGame = new No476_StoneGame();
    No476_StoneGame.testNo476_StoneGame();
  }

  private void testNo476_StoneGame() {
    log.info("result 18 v.s. " + stoneGame(new int[]{4, 1, 1, 4}));
    log.info("result 8 v.s. " + stoneGame(new int[]{1, 1, 1, 1}));
    log.info("result 43 v.s. " + stoneGame(new int[]{4, 4, 5, 9}));
  }

  public int stoneGame(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int len = A.length;
    dp = new int[len][len];
    sum = new int[len][len];
    flag = new boolean[len][len];
    for (int i = 0; i < len; i++) {
      sum[i][i] = A[i];
      for (int j = i + 1; j < len; j++) {
        sum[i][j] = A[j] + sum[i][j - 1];
      }
    }

    // return the final result
    return helper(0, len - 1, A);
  }

  int[][] dp;
  int[][] sum;
  boolean[][] flag;

  int helper(int i, int j, int[] A) {
    if (flag[i][j]) {
      return dp[i][j];
    }
    if (i >= j) {
      return 0;
    }
    flag[i][j] = true;

    int min = Integer.MAX_VALUE;
    for (int k = i; k < j; k++) {
      min = Math.min(min, helper(i, k, A) + helper(k + 1, j, A));
    }
    dp[i][j] = sum[i][j] + min;

    return dp[i][j];
  }

}
