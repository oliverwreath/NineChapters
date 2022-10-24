package com.AdvancedAlgorithms.DP_II.Backpack;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Backpack DP. MLE ok.
 * <p>
 * TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. Sliding Array brings the SPACE: O(N)
 */
@Slf4j
public class Lintcode92Backpack {

  public int backPack(int m, int[] a) {
    // filter abnormal cases
    if (a == null || a.length == 0) {
      return 0;
    }

    // dp logic
    int n = a.length;
    boolean[][] dp = new boolean[2][m + 1];
    // first row true
    Arrays.fill(dp[0], false);
    dp[0][0] = true;

    for (int i = 1; i < n + 1; i++) {
      // first col true
      dp[i % 2][0] = true;
      for (int j = 1; j < m + 1; j++) {
        dp[i % 2][j] = dp[(i - 1) % 2][j];
        if (j - a[i - 1] >= 0) {
          dp[i % 2][j] |= dp[(i - 1) % 2][j - a[i - 1]];
        }
      }
    }
//        for (int i = 0; i < 2; i++) {
//            log.info(Arrays.toString(dp[i]));
//        }

    // return the final result
    for (int j = m; j >= 0; j--) {
      if (dp[n % 2][j]) {
        return j;
      }
    }

    return -1;
  }
}
