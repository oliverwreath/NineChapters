package com.lintcode.ArrayAndNumbers;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SortColors {
  public static void main(String[] arg) {
    testSortColors();
  }

  private static void testSortColors() {
    int[] ints = {1, 0, 1, 2};
    sortColors(ints);
    log.info("{}", ints);
  }

  static void sortColors(int[] nums) {
    // filter abnormal inputs
    if (nums == null || nums.length <= 1) {
      return;
    }

    // counting sort
    int[] counter = new int[3];
    int len = nums.length;
    int left = 0;
    int right = len - 1;
    int i = 0;
    while (i <= right) {
      if (nums[i] == 1) {
        i++;
      } else if (nums[i] == 0) {
        swap(nums, left++, i++);
      } else if (nums[i] == 2) {
        swap(nums, right--, i);
      }
    }

    // return
    return;
  }

  static void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
    return;
  }
}
