package com.ATemplatesDataStructures.DP.PiPeiLei;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No118_DistinctSubsequences {

  public static void main(String[] args) {
    No118_DistinctSubsequences No118_DistinctSubsequences = new No118_DistinctSubsequences();
    No118_DistinctSubsequences.testNo118_DistinctSubsequences();
  }

  private void testNo118_DistinctSubsequences() {
    log.info("result 3 v.s. " + numDistinct("rabbbit", "rabbit"));
  }

  public int numDistinct(String S, String T) {
    // filter abnormal cases
    if (S == null || S.length() == 0) {
      return 0;
    }
    if (T == null || T.length() == 0) {
      return 1;
    }

    int m = S.length();
    int n = T.length();
    int[][] dp = new int[m + 1][n + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (j == 0) {
          dp[i][j] = 1;
        } else {
          if (S.charAt(i - 1) == T.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
          } else {
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
