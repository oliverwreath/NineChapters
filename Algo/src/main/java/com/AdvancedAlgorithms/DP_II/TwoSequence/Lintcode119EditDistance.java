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
public class Lintcode119EditDistance {

  public int minDistance(String word1, String word2) {
    // filter abnormal cases
    if (word1 == null || word1.isEmpty()) {
      return word2 == null ? 0 : word2.length();
    }
    if (word2 == null || word2.isEmpty()) {
      return word1.length();
    }

    // dp logic
    int m = word1.length(), n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int j = 0; j <= n; j++) {
      dp[0][j] = j;
    }
    for (int i = 1; i <= m; i++) {
      dp[i][0] = i;
      for (int j = 1; j <= n; j++) {
        dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
        if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
        } else {
          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
        }
      }
    }

//    log.debug(String.valueOf(m));
//    log.debug(String.valueOf(n));
//    for (int i = 0; i <= m; i++) {
//      log.debug(Arrays.toString(dp[i]));
//    }

    // return the final result
    return dp[m][n];
  }

}
