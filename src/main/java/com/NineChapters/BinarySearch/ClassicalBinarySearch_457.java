package com.NineChapters.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassicalBinarySearch_457 {
  public static void main(String[] args) {
    ClassicalBinarySearch_457 ClassicalBinarySearch_457 = new ClassicalBinarySearch_457();
    ClassicalBinarySearch_457.testClassicalBinarySearch_457();
  }

  private void testClassicalBinarySearch_457() {
    log.info("result 1/2 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 2));
    log.info("result 4/5 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 5));
    log.info("result -1 v.s. {}", findPosition(new int[]{1, 2, 2, 4, 5, 5}, 6));
  }

  public int findPosition(int[] nums, int target) {
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
        return mid;
      }
    }

    if (nums[left] == target) {
      return left;
    }
    if (nums[right] == target) {
      return right;
    }

    // return the final result
    return -1;
  }

}
