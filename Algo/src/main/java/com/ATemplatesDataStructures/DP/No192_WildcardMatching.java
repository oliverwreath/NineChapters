package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No192_WildcardMatching {

  public static void main(String[] args) {
    No192_WildcardMatching No192_WildcardMatching = new No192_WildcardMatching();
    No192_WildcardMatching.testNo192_WildcardMatching();
  }

  private void testNo192_WildcardMatching() {
    log.info("result false v.s. " + isMatch("aaa", "aa"));
    log.info("result true v.s. " + isMatch("aa", "a*"));
    log.info("result false v.s. " + isMatch("aab", "c*a*b"));
  }

  boolean isMatch(String S, String P) {
    // filter abnormal cases
    if (S == null || S.length() == 0) {
      return isEmpty(P);
    }
    if (P == null || P.length() == 0) {
      return false;
    }

    int m = S.length();
    int n = P.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (j == 0) {
          dp[i][j] = false;
        } else {
          if (P.charAt(j - 1) == '*') {
            dp[i][j] |= dp[i][j - 1];
            if (i - 1 >= 0) {
              dp[i][j] |= dp[i - 1][j];
            }
          } else {
            if (i > 0 && (P.charAt(j - 1) == '?' || S.charAt(i - 1) == P.charAt(j - 1))) {
              dp[i][j] |= dp[i - 1][j - 1];
            }
          }
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

  private boolean isEmpty(String p) {
    if (p == null || p.length() == 0) {
      return true;
    }
    for (int i = 0; i < p.length(); i++) {
      if (p.charAt(i) != '*') {
        return false;
      }
    }
    return true;
  }

}
