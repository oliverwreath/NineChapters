package com.lintcode.ArrayAndNumbers;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class PartitionArray {
  public static void main(String[] arg) {
    testPartitionArray();
  }

  private static void testPartitionArray() {
    log.info("{}", partitionArray(new int[]{3, 2, 2, 1}, 2));
    log.info("{}", partitionArray(new int[]{9, 9, 9, 8, 9, 8, 7, 9, 8, 8, 8, 9, 8, 9, 8, 8, 6, 9}, 9));
  }

  static int partitionArray(int[] nums, int k) {
    // filter abnormal cases
    if (nums == null || nums.length <= 1) {
      return 0;
    }

    // one pass
    int len = nums.length;
    int left = 0;
    int right = len - 1;
    int i = 0;
    while (i <= right) {
      if (nums[i] < k) {
        swap(nums, left++, i++);
      } else {
        swap(nums, right--, i);
      }
    }
    log.info("{}", Arrays.toString(nums));

    // return result
    return i;
  }

  static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;

    return;
  }
}
