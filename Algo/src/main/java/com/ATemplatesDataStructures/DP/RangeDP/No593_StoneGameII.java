package com.ATemplatesDataStructures.DP.RangeDP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No593_StoneGameII {

  public static void main(String[] args) {
    No593_StoneGameII No476_StoneGame = new No593_StoneGameII();
    No476_StoneGame.testNo476_StoneGame();
  }

  private void testNo476_StoneGame() {
    log.info("result 18 v.s. " + stoneGame2(new int[]{4, 1, 1, 4}));
    log.info("result 8 v.s. " + stoneGame2(new int[]{1, 1, 1, 1}));
    log.info("result 43 v.s. " + stoneGame2(new int[]{4, 4, 5, 9}));
  }

  public int stoneGame2(int[] A) {
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
      for (int d = 1; d < len; d++) {
        int j = i + d;
        sum[i][j % A.length] = A[j % A.length] + sum[i][(j - 1) % A.length];
      }
    }

    // return the final result
    int answer = Integer.MAX_VALUE;
    for (int d = 0; d < len; d++) {
//            log.debug(d + ": " + (len - 1 + d) % A.length);
      answer = Math.min(answer, helper(0 + d, (len - 1 + d) % A.length, A));
    }
//        for (int i = 0; i < len; i++) {
//            log.debug(Arrays.toString(sum[i]));
//        }
//        for (int i = 0; i < len; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }
    return answer;
  }

  int[][] dp;
  int[][] sum;
  boolean[][] flag;

  int helper(int i, int j, int[] A) {
    if (flag[i][j]) {
      return dp[i][j];
    }
    flag[i][j] = true;
    if (i == j) {
      return 0;
    }

    int min = Integer.MAX_VALUE;
    for (int k = i; true; k++) {
      if (k % A.length == j) {
        break;
      }
      min = Math.min(min, helper(i, k % A.length, A) + helper((k + 1) % A.length, j, A));
    }
    dp[i][j] = sum[i][j] + min;

    return dp[i][j];
  }

}
