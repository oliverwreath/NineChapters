package com.lintcode.BackPack;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BackPack {

  public static void main(String[] arg) {
    testBackPack();
  }

  private static void testBackPack() {
    log.info("{}", backPack(11, new int[]{2, 3, 5, 7}));
  }

  /**
   * @param m: An integer m denotes the size of a backpack
   * @param A: Given n items with size A[i]
   * @return: The maximum size
   */
  static int backPack(int m, int[] A) {

    // filter abnormal inputs
    if (A == null || A.length == 0) {
      return 0;
    }

    // fill the result matrix
    int n = A.length;
    int[][] ret = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (j - A[i - 1] >= 0) {
          ret[i][j] = Math.max(ret[i - 1][j], ret[i - 1][j - A[i - 1]] + A[i - 1]);
        } else {
          ret[i][j] = ret[i - 1][j];
        }
      }
    }

//        for (int i = 0; i <= n; i++) {
//            log.debug(Arrays.toString(ret[i]));
//        }

    // return result
    return ret[n][m];
  }
}
