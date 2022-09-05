package com.leetcode.Weekly8;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC416PartitionEqualSubsetSum {
  public static void main(String[] arg) {
    new LC416PartitionEqualSubsetSum().testLongestPalindrome_409();
  }

  private void testLongestPalindrome_409() {
    log.info("true = {}", canPartition(new int[]{1, 5, 11, 5}));
    log.info("false = {}", canPartition(new int[]{1, 2, 3, 5}));
  }

  public boolean canPartition(int[] nums) {
    if (nums.length == 1) {
      return false;
    }

    int n = nums.length;
    int totalSum = 0;
    for (int i = 0; i < n; i++) {
      totalSum += nums[i];
    }
//        log.debug("totalSum = " + totalSum);

    if (totalSum % 2 != 0) {
      return false;
    }

    // dp
    int m = totalSum / 2 + 1;
    boolean[][] dp = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      dp[i][0] = true;
    }
    if (nums[0] < n) {
      dp[0][nums[0]] = true;
    }
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (j - nums[i] >= 0) {
          dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
//        log.debug("");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }

    return dp[n - 1][m - 1];
  }
}
