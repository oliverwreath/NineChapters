package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MaximumSubarray {
  public static void main(String[] arg) {
    testMaximumSubarray();
  }

  private static void testMaximumSubarray() {
    log.info("{}", maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
  }

  /**
   * @param nums: A list of integers
   * @return: A integer indicate the sum of max subarray
   */
  static int maxSubArray(int[] nums) {

    // filter abnormal inputs
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    // fill subproblem results
    int n = nums.length;
    int[] local = new int[n];
    int[] global = new int[n];
    local[0] = global[0] = nums[0];
    for (int i = 1; i < n; i++) {
      local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
      global[i] = Math.max(global[i - 1], local[i]);
    }

    // print to check before committing
//        log.debug(Arrays.toString(local));
//        log.debug(Arrays.toString(global));

    // return the final result
    return global[n - 1];
  }
}
