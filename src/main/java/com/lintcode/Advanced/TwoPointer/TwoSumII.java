package com.lintcode.Advanced.TwoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class TwoSumII {
  public static void main(String[] arg) {
    new TwoSumII().testTwoSumII();
  }

  private void testTwoSumII() {
    log.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 24));
  }

  /**
   * @param nums:   an array of integer
   * @param target: an integer
   * @return: an integer
   */
  public int twoSum2(int[] nums, int target) {

    if (nums == null || nums.length < 2) {
      return 0;
    }

    // sort
    Arrays.sort(nums);
    // two pointer
    int n = nums.length;
    int i = 0;
    int j = n - 1;
    int counter = 0;
    while (i < j) {
      if (nums[i] + nums[j] > target) {
        int tmp = j - i;
        counter += tmp;
        j--;
      } else {
        i++;
      }
    }

    return counter;
  }
}
