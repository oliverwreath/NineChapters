package com.lintcode.Advanced.DPI;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LongestIncreasingContinuousSubsequenceII {
  public static void main(String[] arg) {
    testLongestIncreasingContinuousSubsequenceII();
  }

  private static void testLongestIncreasingContinuousSubsequenceII() {
    log.info("{}", longestIncreasingContinuousSubsequenceII(new int[][]{{1, 2, 3, 4, 5},
            {16, 17, 24, 23, 6},
            {15, 18, 25, 22, 7},
            {14, 19, 20, 21, 8},
            {13, 12, 11, 10, 9}}));
  }

  static int search(int i, int j, int n, int m, int[][] A) {
    if (isSearch[i][j]) {
      return dp[i][j];
    }

    dp[i][j] = 1;
    for (int t = 0; t < 4; t++) {
      int x = i + di[t];
      int y = j + dj[t];
      if (x >= 0 && x < n && y >= 0 && y < m && A[x][y] < A[i][j]) {
        dp[i][j] = Math.max(dp[i][j], search(x, y, n, m, A) + 1);
      }
    }

    isSearch[i][j] = true;
    return dp[i][j];
  }

  private static boolean[][] isSearch;
  private static int[][] dp;
  private static int[] di = new int[]{1, -1, 0, 0};
  private static int[] dj = new int[]{0, 0, 1, -1};


  /**
   * @param A an integer matrix
   * @return an integer
   */
  static int longestIncreasingContinuousSubsequenceII(int[][] A) {

    // filter abnormal inputs
    if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
      return 0;
    }

    // fill subproblem results
    int n = A.length;
    int m = A[0].length;
    isSearch = new boolean[n][m];
    dp = new int[n][m];
    int maxLength = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int length = search(i, j, n, m, A);
        maxLength = Math.max(maxLength, length);
      }
    }

    // print to check before committing
//        log.debug("dp = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }
//        log.debug("isSearch = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(isSearch[i]));
//        }

    // return the final result
    return maxLength;
  }
}
