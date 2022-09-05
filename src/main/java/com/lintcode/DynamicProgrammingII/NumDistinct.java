package com.lintcode.DynamicProgrammingII;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
@Slf4j
public class NumDistinct {
  public static void main(String[] args) {
    testNumDistinct();
  }

  private static void testNumDistinct() {
    log.debug("{}", numDistinct("mart", "karma"));
    log.debug("- -");
    log.debug("{}", numDistinct("rabbbit", "rabbit"));
    log.debug("- -");
    log.debug("{}", numDistinct("ABCD", "EACB"));
    log.debug("- -");
    log.debug("{}", numDistinct("ABCD", "1A3B4C2323D"));
    log.debug("- -");
  }

  public static int numDistinct(String S, String T) {
    if (S == null || T == null) {
      return -1;
    }

    int m = S.length();
    int n = T.length();
    int[][] f = new int[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      f[i][0] = 1;
    }
    for (int j = 1; j <= n; j++) {
      f[0][j] = 0;
    }

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (S.charAt(i - 1) == T.charAt(j - 1)) {
          f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
        } else {
          f[i][j] = f[i - 1][j];
        }
      }
    }

    return f[m][n];
  }
}
