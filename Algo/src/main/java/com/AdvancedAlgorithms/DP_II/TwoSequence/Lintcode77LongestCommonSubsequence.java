package com.AdvancedAlgorithms.DP_II.TwoSequence;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Okay DP.
 * <p>
 * TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. Could be Sliding array - save space.
 */
@Slf4j
public class Lintcode77LongestCommonSubsequence {

  public int longestCommonSubsequence(String a, String b) {
    // filter abnormal cases
    if (a == null || a.length() == 0 || b == null || b.length() == 0) {
      return 0;
    }

    // dp logic
    int m = a.length(), n = b.length();
    int[][] dp = new int[m + 1][n + 1];
    Arrays.fill(dp[0], 0);
    for (int i = 1; i <= m; i++) {
      dp[i][0] = 0;
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
