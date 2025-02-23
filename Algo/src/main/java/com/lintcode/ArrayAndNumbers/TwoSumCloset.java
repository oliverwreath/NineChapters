package com.lintcode.ArrayAndNumbers;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TwoSumCloset {

  public static void main(String[] arg) {
    testTwoSumCloset();
  }

  private static void testTwoSumCloset() {
//        log.info("{}", twoSumCloset(new int[]{-3, 1, 2, -3, 4}));
    log.info("{}", twoSumCloset(new int[]{-1, 2, 1, -4}, 4));
  }

  static int twoSumCloset(int[] nums, int target) {
    // filter abnormal inputs
    if (nums == null || nums.length == 0) {
      return -1;
    }

    // sort
    Arrays.sort(nums);

    // two pointers
    int i = 0;
    int j = nums.length - 1;
    int minDiff = Integer.MAX_VALUE;
    while (i < j) {
      if (nums[i] + nums[j] < target) {
        minDiff = Math.min(minDiff, target - (nums[i] + nums[j]));
        i++;
      } else {
        minDiff = Math.min(minDiff, (nums[i] + nums[j]) - target);
        j--;
      }
    }

    // return result
    return minDiff;
  }
}
