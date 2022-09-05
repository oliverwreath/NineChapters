package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC153FindMinimumInRotatedSortedArray {
  public int findMin(int[] nums) {
    int min = nums[0];

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      if (nums[left] <= nums[right])
        return Math.min(min, nums[left]);
      int mid = left + (right - left) / 2;
      min = Math.min(min, nums[mid]);
      if (nums[left] <= nums[mid]) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return min;
  }
}
