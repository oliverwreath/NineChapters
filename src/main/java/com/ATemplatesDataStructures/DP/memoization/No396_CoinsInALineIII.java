package com.ATemplatesDataStructures.DP.memoization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No396_CoinsInALineIII {
  public static void main(String[] args) {
    No396_CoinsInALineIII No394_CoinsInALine = new No396_CoinsInALineIII();
    No394_CoinsInALine.testNo394_CoinsInALine();
  }

  private void testNo394_CoinsInALine() {
    log.info("result false v.s. " + firstWillWin(new int[]{}));
    log.info("result true v.s. " + firstWillWin(new int[]{3, 2, 2}));
    log.info("result true v.s. " + firstWillWin(new int[]{1, 2, 4}));
    log.info("result false v.s. " + firstWillWin(new int[]{1, 20, 4}));
  }

  boolean firstWillWin(int[] values) {
    // filter abnormal cases
    if (values == null || values.length <= 0) {
      return false;
    }
    if (values.length <= 2) {
      return true;
    }

    int len = values.length;
    flag = new boolean[len][len];
    dp = new int[len][len];
    boolean answer = helper(0, len - 1, values) > Math.min(helper(1, len - 1, values), helper(0, len - 2, values));
//        log.debug(map);
    return answer;
  }

  boolean[][] flag;
  int[][] dp;

  int helper(int i, int j, int[] values) {
    if (flag[i][j]) {
      return dp[i][j];
    }
    flag[i][j] = true;

    if (i > j) {
      dp[i][j] = 0;
    } else if (i == j) {
      dp[i][j] = values[i];
    } else if (i + 1 == j) {
      dp[i][j] = Math.max(values[i], values[j]);
    } else {
      dp[i][j] = Math.max(values[i] + Math.min(helper(i + 2, j, values), helper(i + 1, j - 1, values)),
              values[j] + Math.min(helper(i + 1, j - 1, values), helper(i, j - 2, values)));
    }
    return dp[i][j];
  }

}
