package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MaximumProductSubarray {
  public static void main(String[] arg) {
    testMaximumProductSubarray();
  }

  private static void testMaximumProductSubarray() {
    log.info("{}", maxProduct(new int[]{2, 3, -2, 4}));
  }

  /**
   * @param nums: an array of integers
   * @return: an integer
   */
  static int maxProduct(int[] nums) {

    // filter abnormal inputs
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    // fill subproblem results
    int n = nums.length;
    long[] localMin = new long[n];
    long[] localMax = new long[n];
    long[] global = new long[n];
    localMin[0] = localMax[0] = global[0] = nums[0];
    for (int i = 1; i < n; i++) {
      localMin[i] = Math.min(nums[i], Math.min(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i]));
      localMax[i] = Math.max(nums[i], Math.max(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i]));
      global[i] = Math.max(global[i - 1], Math.max(localMin[i], localMax[i]));
    }

    // print to check before committing
//        log.debug(Arrays.toString(localMin));
//        log.debug(Arrays.toString(localMax));
//        log.debug(Arrays.toString(global));

    // return the final result
    return (int) global[n - 1];
  }
}
