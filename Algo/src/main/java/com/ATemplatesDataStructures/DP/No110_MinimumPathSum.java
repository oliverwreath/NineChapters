package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No110_MinimumPathSum {

  public static void main(String[] args) {
    testNo392_HouseRobber();
  }

  private static void testNo392_HouseRobber() {
    No110_MinimumPathSum No392_HouseRobber = new No110_MinimumPathSum();
    log.info("result 3 v.s. " + No392_HouseRobber.minPathSum(new int[][]{
        {3}
    }));
    log.info("result 5 v.s. " + No392_HouseRobber.minPathSum(new int[][]{
        {3, 2},
        {1, 1}
    }));
  }

  public int minPathSum(int[][] grid) {
    // filter abnormal cases
    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    int m = grid.length;
    int n = grid[0].length;
    int[][] dp = new int[2][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 && j == 0) {
          dp[i % 2][j] = grid[i][j];
        } else if (i == 0) {
          dp[i % 2][j] = dp[i % 2][j - 1] + grid[i][j];
        } else if (j == 0) {
          dp[i % 2][j] = dp[(i - 1) % 2][j] + grid[i][j];
        } else {
          dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
        }
      }
    }

    // return the final result
    return dp[(m - 1) % 2][n - 1];
  }

//    public long houseRobber(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//        if (A.length == 1) {
//            return A[0];
//        }
//
//        int len = A.length;
//        long[] dp = new long[len];
//        dp[0] = A[0];
//        dp[1] = Math.max(A[0], A[1]);
//        for (int i = 2; i < len; i++) {
//            dp[i] = Math.max(dp[i - 1], A[i] + dp[i - 2]);
//        }
//
//        // return the final result
//        return dp[len - 1];
//    }

}
