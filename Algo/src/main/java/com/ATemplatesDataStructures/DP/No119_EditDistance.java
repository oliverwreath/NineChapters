package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No119_EditDistance {

  public static void main(String[] args) {
    testNo119_EditDistance();
  }

  private static void testNo119_EditDistance() {
    No119_EditDistance No119_EditDistance = new No119_EditDistance();
    log.info("result 3 v.s. " + No119_EditDistance.minDistance("mart", "karma"));
  }

  public int minDistance(String word1, String word2) {
    // filter abnormal cases
    if (word1 == null || word2 == null) {
      return 0;
    }
    if (word1.length() == 0) {
      return word2.length();
    }
    if (word2.length() == 0) {
      return word1.length();
    }

    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = 0;
        } else if (i == 0) {
          dp[i][j] = dp[i][j - 1] + 1;
        } else if (j == 0) {
          dp[i][j] = dp[i - 1][j] + 1;
        } else {
          if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1];
          } else {
            dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
          }
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
