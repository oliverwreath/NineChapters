package com.AmazonSession.leetcode.algorithms;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC396RotateFunction {
  public int maxRotateFunction(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    int n = nums.length;
    // first
    int last = 0;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      last += i * nums[i];
      sum += nums[i];
    }
    int maxF = last;
//    log.info(String.valueOf(last));
    // rest
    for (int i = 1; i < n; i++) {
      int current = last + sum - n * nums[n - i];
      maxF = Math.max(maxF, current);
      last = current;
//      log.info(String.valueOf(current));
    }
    return maxF;
  }
}
