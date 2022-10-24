package com.lintcode.BackPack;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BackPackV {

  public static void main(String[] arg) {
    testBackPackV();
  }

  private static void testBackPackV() {
    log.info("{}", backPackV(new int[]{1, 2, 3, 3, 7}, 7));
  }

  /**
   * @param nums   an integer array and all positive numbers
   * @param target an integer
   * @return an integer
   */
  static int backPackV(int[] nums, int target) {

    // filter abnormal inputs
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // fill the result matrix
    int n = nums.length;
    int[][] ret = new int[n + 1][target + 1];

//        ret[0][0] = 1;
    for (int i = 0; i <= n; i++) {
      ret[i][0] = 1;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= target; j++) {
        if (j - nums[i - 1] >= 0) {
          ret[i][j] = ret[i - 1][j] + ret[i - 1][j - nums[i - 1]];
        } else {
          ret[i][j] = ret[i - 1][j];
        }
      }
    }

//        for (int i = 0; i <= n; i++) {
//            log.debug(Arrays.toString(ret[i]));
//        }

    // return result
    return ret[n][target];
  }
}
