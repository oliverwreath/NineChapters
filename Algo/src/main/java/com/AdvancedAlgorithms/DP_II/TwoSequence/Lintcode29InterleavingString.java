package com.AdvancedAlgorithms.DP_II.TwoSequence;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Okay DP.
 * <p>
 * TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. Could use Sliding array - save space.
 */
@Slf4j
public class Lintcode29InterleavingString {

  public boolean isInterleave(String A, String B, String C) {
    // filter abnormal cases
    if (C == null || C.length() == 0) {
      return ((A == null || A.length() == 0) && (B == null || B.length() == 0));
    }
    if (A == null || A.length() == 0) {
      return B.equals(C);
    }
    if (B == null || B.length() == 0) {
      return A.equals(C);
    }
    if (A.length() + B.length() != C.length()) {
      return false;
    }

    // dp logic
    int m = A.length(), n = B.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    dp[0][0] = true;
    for (int j = 1; j <= n; j++) {
      dp[0][j] = dp[0][j - 1] && (B.charAt(j - 1) == C.charAt(j - 1));
    }
    for (int i = 1; i <= m; i++) {
      dp[i][0] = dp[i - 1][0] && (A.charAt(i - 1) == C.charAt(i - 1));
      for (int j = 1; j <= n; j++) {
        dp[i][j] = (dp[i - 1][j] && (A.charAt(i - 1) == C.charAt(i + j - 1))) ||
            (dp[i][j - 1] && (B.charAt(j - 1) == C.charAt(i + j - 1)));
      }
    }

//        log.info(String.valueOf(m));
//        log.info(String.valueOf(n));
//        for (int i = 0; i <= m; i++) {
//            log.info(Arrays.toString(dp[i]));
//        }

    // return the final result
    return dp[m][n];
  }

}
