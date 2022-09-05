package com.ATemplatesDataStructures.tmp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No154RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    // filter abnormal cases
    if (s == null) {
      return p == null;
    }
    if (s.equals(p)) {
      return true;
    }

    int m = s.length();
    int n = p.length();
    flag = new boolean[m + 1][n + 1];
    dp = new boolean[m + 1][n + 1];
//        log.debug("m = " + m + "; n = " + n);

    boolean answer = helper(m, n, s, p);
//        log.debug("flag = ");
//        for (int i = 0; i <= m; i++) {
//            log.debug(Arrays.toString(flag[i]));
//        }
//        log.debug("dp = ");
//        for (int i = 0; i <= m; i++) {
//            log.debug(Arrays.toString(dp[i]));
//        }
    return answer;
  }

  boolean[][] flag;
  boolean[][] dp;

  boolean helper(int i, int j, String s, String p) {
    if (flag[i][j]) {
      return dp[i][j];
    }
    flag[i][j] = true;

    if (j == 0) {
      dp[i][j] = i == 0;
      return dp[i][j];
    }
    if (i == 0) {
      dp[i][j] = isEmpty(j - 1, p);
      return dp[i][j];
    }
    if (p.charAt(j - 1) == '*') {
      if (j == 1) {
        dp[i][j] = helper(i, j - 1, s, p);
      } else {
        dp[i][j] |= helper(i, j - 2, s, p);
        if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
          dp[i][j] |= helper(i - 1, j, s, p);
        }
      }
    } else {
      dp[i][j] = (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1)) && helper(i - 1, j - 1, s, p);
    }

    return dp[i][j];
  }

  boolean isEmpty(int j, String str) {
    if (j % 2 == 0) {
      return false;
    }
    for (int i = 1; i <= j; i += 2) {
      if (str.charAt(i) != '*') {
        return false;
      }
    }
    return true;
  }

}
