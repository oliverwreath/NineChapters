package com.leetcode.Weekly49;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC674LCIS {
  public static void main(String[] args) {
    testLCIS();
  }

  private static void testLCIS() {
    LC674LCIS LC674LCIS = new LC674LCIS();
    log.info("result 3 = " + LC674LCIS.findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
    log.info("result 1 = " + LC674LCIS.findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    log.info("result 0 = " + LC674LCIS.findLengthOfLCIS(new int[]{}));
  }

  /**
   * @param nums
   * @return
   */
  public int findLengthOfLCIS(int[] nums) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return 0;
    }

    int maxLength = 1;
    int n = nums.length;
    int currentLength = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        currentLength++;
        maxLength = Math.max(maxLength, currentLength);
      } else {
        currentLength = 1;
      }
    }


    // return the final result
    return maxLength;
  }

}
