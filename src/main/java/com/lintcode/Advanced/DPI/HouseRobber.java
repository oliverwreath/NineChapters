package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class HouseRobber {
  public static void main(String[] arg) {
    testHouseRobber();
  }

  private static void testHouseRobber() {
    log.info("{}", houseRobber(new int[]{3, 8, 4}));
    log.info("{}", houseRobber(new int[]{3, 8, 4, 2, 4, 3}));
  }

  /**
   * @param A: An array of non-negative integers.
   *           return: The maximum amount of money you can rob tonight
   */
  static long houseRobber(int[] A) {

    // filter abnormal inputs
    if (A == null || A.length == 0) {
      return 0;
    }
    if (A.length == 1) {
      return A[0];
    }

    // fill subproblem results
    int len = A.length;
    long[] dp = new long[len];
    dp[0] = A[0];
    dp[1] = Math.max(A[0], A[1]);
    for (int i = 2; i < len; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + A[i]);
    }

    // print to check before committing
    log.debug(Arrays.toString(dp));

    // return the final result
    return dp[len - 1];
  }
}
