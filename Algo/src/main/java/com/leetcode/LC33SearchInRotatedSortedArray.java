package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC33SearchInRotatedSortedArray {

  public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0)
      return -1;

    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target)
        return mid;
      else if (nums[left] <= nums[mid]) {
        if (nums[left] <= target && target <= nums[mid]) {
          right = mid;
        } else {
          left = mid + 1;
        }
      } else {
        if (nums[mid] <= target && target <= nums[right]) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
