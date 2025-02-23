package com.leetcode.Weekly124;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. TIME: O(?) SPACE: O(?)
 */
@Slf4j
public class LC995MinimumNumberOfKConsecutiveBitFlips {

  public int minKBitFlips(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // dp logic
    if (k == 1) {
      int count = 0;
      for (int a : nums) {
        if (a == 0) {
          count++;
        }
      }
      return count;
    }
    int i = 0;
    int n = nums.length;
    int steps = 0;
    while (i < n) {
      if (nums[i] == 1) {
        i++;
        continue;
      }

      if (i > n - k) {
        return -1;
      }

      for (int t = 0; t < k; t++) {
        nums[i + t] = nums[i + t] == 0 ? 1 : 0;
      }
      i++;
      steps++;
    }

    return steps;
  }
}
