package com.ATemplatesDataStructures.DP.Backpack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No562_BackpackIV {
  public static void main(String[] args) {
    No562_BackpackIV No562_BackpackIV = new No562_BackpackIV();
    No562_BackpackIV.testNo562_BackpackIV();
  }

  private void testNo562_BackpackIV() {
    log.info("result 2 v.s. " + backPackIV(new int[]{2, 3, 6, 7}, 7));
  }

  public int backPackIV(int[] A, int m) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    int[][] dp = new int[n + 1][m + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (j == 0) {
          dp[i][0] = 1;
        } else if (i == 0) {
          dp[0][j] = 0;
        } else {
          dp[i][j] = dp[i - 1][j];
          int k = 1;
          while (j - k * A[i - 1] >= 0) {
            dp[i][j] += dp[i - 1][j - k * A[i - 1]];
            k++;
          }
        }
      }
    }

    // return the final result
    return dp[n][m];
  }

}
