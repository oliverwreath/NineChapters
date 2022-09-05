package com.leetcode.Weekly7;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC410SplitArrayLargestSum {
  public static void main(String[] arg) {
    testSplitArrayLargestSum_410();
  }

  private static void testSplitArrayLargestSum_410() {
    log.info("{}", splitArray(new int[]{1, 2, 3, 4, 5}, 1));// 15
    log.info("{}", splitArray(new int[]{1, 2, 3, 4, 5}, 2));// 9
    log.info("{}", splitArray(new int[]{1, 2, 3, 4, 5}, 3));// 6
    log.info("{}", splitArray(new int[]{1, 2, 3, 4, 5}, 4));// 3
  }

  static int splitArray(int[] nums, int m) {
    // handle special inputs
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    if (m == 1) {
      long sum = 0;
      for (int num : nums) {
        sum += num;
      }
      return (int) sum;
    }
    if (m >= nums.length) {
      int max = Integer.MIN_VALUE;
      for (int num : nums) {
        max = Math.max(max, num);
      }
      return max;
    }

    // compute
    int n = nums.length;
    int[][] local = new int[n][m + 1];
    int[][] global = new int[n][m + 1];
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= m; j++) {
        if (i == 0) {
          local[i][j] = nums[0];
          global[i][j] = nums[0];
        } else if (j == 1) {
          long sum = 0;
          for (int i1 = 0; i1 <= i; i1++) {
            sum += nums[i1];
          }
          local[i][j] = (int) sum;
          global[i][j] = (int) sum;
        } else {
          local[i][j] = Math.max(local[i - 1][j - 1], nums[i]);
          global[i][j] = Math.min(global[i - 1][j], local[i][j]);
        }
      }
    }

    // check before committing
//        log.debug("local = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(local[i]));
//        }
//        log.debug("global = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(global[i]));
//        }

    // return the answer
    return local[n - 1][m];
  }
}
//dp[0,*] = 0
//        dp[i,0] = a[i]
//        dp[i,j] = min{dp[i-1,j] + a[i], max{dp[i-1,j-1], a[i]}}
//        dp[i,j] is the minimum between the dividing the array at point i or not dividing.
//
//        The answer can be found if you calculate
//
//        dp[length(A), k-1]
