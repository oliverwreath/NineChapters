package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No534_HouseRobberII {
  public static void main(String[] args) {
    testNo392_HouseRobber();
  }

  private static void testNo392_HouseRobber() {
    No534_HouseRobberII No392_HouseRobber = new No534_HouseRobberII();
    log.info("result 6 v.s. " + No392_HouseRobber.houseRobber2(new int[]{3, 6, 4}));
  }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  public int houseRobber2(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }
    if (A.length == 1) {
      return A[0];
    }

    int len = A.length;
    int[] dp = new int[2];
    dp[0] = A[0];
    dp[1] = Math.max(A[0], A[1]);
    for (int i = 2; i < len - 1; i++) {
      dp[i % 2] = Math.max(dp[(i - 1) % 2], A[i] + dp[(i - 2) % 2]);
    }

    int[] dp2 = new int[2];
    dp2[0] = A[1];
    dp2[1] = Math.max(A[1], A[2]);
    for (int i = 2; i < len - 1; i++) {
      dp2[i % 2] = Math.max(dp2[(i - 1) % 2], A[i + 1] + dp2[(i - 2) % 2]);
    }

    // return the final result
    return Math.max(dp[(len - 2) % 2], dp2[(len - 2) % 2]);
  }

}
