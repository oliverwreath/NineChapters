package com.AmazonSession.LeetCodeTopQuestionsFromAmazon.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Just single loop, get the current sum and Max.
 * <p>
 * TIME: O(N)
 * SPACE: O(1)
 * <p>
 * Version 2: TBD.
 */
@Slf4j
public class LC53MaximumSubarray {
  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length < 1) {
      return 0;
    }

    // dp logic
    int sum = 0;
    int max = Integer.MIN_VALUE;
    for (int num : nums) {
      sum += num;
      max = Math.max(max, sum);
      if (sum < 0) {
        sum = 0;
      }
    }

    return max;
  }

}
