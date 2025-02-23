package com.ATemplatesDataStructures.DP.Backpack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No125_BackpackII {

  public static void main(String[] args) {
    No125_BackpackII No125_BackpackII = new No125_BackpackII();
    No125_BackpackII.testNo125_BackpackII();
  }

  private void testNo125_BackpackII() {
    log.info("result 9 v.s. " + backPackII(10, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
    log.info("result 11 v.s. " + backPackII(15, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
  }

  public int backPackII(int m, int[] A, int[] V) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (j == 0) {
          dp[i][0] = 0;
        } else {
          dp[i][j] = dp[i - 1][j];
          if (j - A[i - 1] >= 0) {
            dp[i][j] = Math.max(dp[i][j], V[i - 1] + dp[i - 1][j - A[i - 1]]);
          }
        }
      }
    }

    // return the final result
    return dp[n][m];
  }

}
