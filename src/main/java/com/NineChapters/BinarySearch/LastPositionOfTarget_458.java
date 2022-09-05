package com.NineChapters.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LastPositionOfTarget_458 {
  public static void main(String[] args) {
    testFirstPositionOfTarget_14();
  }

  private static void testFirstPositionOfTarget_14() {
    log.info("result 2 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 2));
    log.info("result 5 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 5));
    log.info("result -1 v.s. {}", lastPosition(new int[]{1, 2, 2, 4, 5, 5}, 6));
  }

  public static int lastPosition(int[] nums, int target) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return -1;
    }

    int left = 0, right = nums.length - 1;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }

    if (nums[right] == target) {
      return right;
    }
    if (nums[left] == target) {
      return left;
    }

    // return the final result
    return -1;
  }

}
