package com.ATemplatesDataStructures.DP.PiPeiLei;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No77_LongestCommonSubsequence {

  public static void main(String[] args) {
    No77_LongestCommonSubsequence No77_LongestCommonSubsequence = new No77_LongestCommonSubsequence();
    No77_LongestCommonSubsequence.testNo77_LongestCommonSubsequence();
  }

  private void testNo77_LongestCommonSubsequence() {
    log.info("result 1 v.s. " + longestCommonSubsequence("ABCD", "EDCA"));
    log.info("result 2 v.s. " + longestCommonSubsequence("ABCD", "EACB"));
    log.info("result 7 v.s. " + longestCommonSubsequence("EACBAEDDDDD", "EADDDDDCBAE"));
  }

  public int longestCommonSubsequence(String A, String B) {
    // filter abnormal cases
    if (A == null || A.length() == 0 || B == null || B.length() == 0) {
      return 0;
    }

    int m = A.length();
    int n = B.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (A.charAt(i - 1) == B.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
