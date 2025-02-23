package com.lintcode.ArrayAndNumbers;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TwoSum2 {

  public static void main(String[] arg) {
    testTwoSum2();
  }

  private static void testTwoSum2() {
    log.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 24));
    log.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 1));
    log.info("{}", twoSum2(new int[]{1, 0, -1}, -1));
    log.info("{}", twoSum2(new int[]{1, 0, -1}, 0));
    log.info("{}", twoSum2(new int[]{1, 0, -1}, 1));
  }

  static int twoSum2(int[] nums, int target) {
    // filter abnormal inputs
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // sort
    Arrays.sort(nums);

    // search
    int len = nums.length;
    int i = 0, j = len - 1;
    int counter = 0;
    while (i < j) {
      if (nums[i] + nums[j] > target) {
//                log.info("j = {}; i = {}; j - i = {}", j, i, j - i);
        counter += (j - i);
        j--;
      } else {
        i++;
      }
    }

    // return result
    return counter;
  }
}
