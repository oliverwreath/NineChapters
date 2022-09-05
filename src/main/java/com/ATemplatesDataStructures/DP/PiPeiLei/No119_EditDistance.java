package com.ATemplatesDataStructures.DP.PiPeiLei;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No119_EditDistance {
  public static void main(String[] args) {
    No119_EditDistance No119_EditDistance = new No119_EditDistance();
    No119_EditDistance.testNo119_EditDistance();
  }

  private void testNo119_EditDistance() {
    log.info("result 3 v.s. " + minDistance("mart", "karma"));
  }

  public int minDistance(String A, String B) {
    // filter abnormal cases
    if (A == null || A.length() == 0) {
      return B == null ? 0 : B.length();
    }
    if (B == null || B.length() == 0) {
      return A == null ? 0 : A.length();
    }

    int m = A.length();
    int n = B.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0) {
          dp[i][j] = j;
        } else if (j == 0) {
          dp[i][j] = i;
        } else {
          if (A.charAt(i - 1) == B.charAt(j - 1)) {
            dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
          } else {
            dp[i][j] = Math.min(1 + dp[i - 1][j - 1], Math.min(1 + dp[i - 1][j], 1 + dp[i][j - 1]));
          }
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
