package com.ATemplatesDataStructures.DP.Backpack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No92_Backpack {

  public static void main(String[] args) {
    No92_Backpack No92_Backpack = new No92_Backpack();
    No92_Backpack.testNo92_Backpack();
  }

  private void testNo92_Backpack() {
    log.info("result 10 v.s. " + backPack(11, new int[]{2, 3, 5, 7}));
    log.info("result 12 v.s. " + backPack(12, new int[]{2, 3, 5, 7}));
  }

  public int backPack(int m, int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    boolean[][] dp = new boolean[n + 1][m + 1];
    dp[0][0] = true;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= m; j++) {
        if (j == 0) {
          dp[i][0] = true;
        } else {
          dp[i][j] = dp[i - 1][j] || (j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]);
        }
      }
    }

//        for (int i = 0; i <= n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }
    int max = 0;
    for (int j = m; j >= 0; j--) {
      if (dp[n][j]) {
        max = j;
        break;
      }
    }

    // return the final result
    return max;
  }

}
