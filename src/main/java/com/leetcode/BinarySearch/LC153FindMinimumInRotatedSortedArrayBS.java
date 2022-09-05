package com.leetcode.BinarySearch;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC153FindMinimumInRotatedSortedArrayBS {
  public int findMin(int[] nums) {

    if (nums == null || nums.length == 0) {
      return -1;
    }

    // dp, bfs, binarySearch, divide conquer?
    int n = nums.length;
    int start = 0;
    int end = n - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < nums[end]) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }

    // return the answer
    if (nums[start] < nums[end]) {
      return nums[start];
    } else {
      return nums[end];
    }
  }

  public int binarySearch(int[] nums, int target) {

    if (nums == null || nums.length == 0) {
      return -1;
    }

    int n = nums.length;
    int start = 0;
    int end = n - 1;

    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < target) {
        start = mid;
      } else if (nums[mid] > target) {
        end = mid;
      } else {
        return mid;
      }
    }

    if (nums[start] == target) {
      return start;
    } else if (nums[end] == target) {
      return end;
    }
    return -1;
  }

}
