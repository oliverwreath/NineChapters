package com.lintcode.BackPack;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BackPackIII {
  public static void main(String[] arg) {
    testBackPackIII();
  }

  private static void testBackPackIII() {
    log.info("{}", backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
  }

  /**
   * @param A an integer array
   * @param V an integer array
   * @param m an integer
   * @return an array
   */
  static int backPackIII(int[] A, int[] V, int m) {

    if (A == null || A.length == 0) {
      return 0;
    }

    // fill the result matrix
    int n = A.length;
    int[][] ret = new int[n + 1][m + 1];

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (j - A[i - 1] >= 0) {
          ret[i][j] = Math.max(ret[i - 1][j], ret[i][j - A[i - 1]] + V[i - 1]);
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
