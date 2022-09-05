package com.leetcode.DP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC53MaximumSubarray {
  public static void main(String[] arg) {
    new LC53MaximumSubarray().testMaximumSubarray_53();
  }

  private void testMaximumSubarray_53() {
    log.info("6 = {}", maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    log.info("1 = {}", maxSubArray(new int[]{1}));
    log.info("3 = {}", maxSubArray(new int[]{-2, 3}));
  }

  public int maxSubArray(int[] nums) {

    if (nums == null || nums.length == 0) {
      return 0;
    }

    // dp
    int n = nums.length;
    int[] local = new int[n];
    int[] global = new int[n];
    local[0] = nums[0];
    global[0] = nums[0];
    for (int i = 1; i < n; i++) {
      local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
      global[i] = Math.max(global[i - 1], local[i]);
    }

    return global[n - 1];
  }
}
