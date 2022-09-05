package com.ATemplatesDataStructures.DP.PiPeiLei;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No29_InterleavingString {
  public static void main(String[] args) {
    No29_InterleavingString No29_InterleavingString = new No29_InterleavingString();
    No29_InterleavingString.testNo29_InterleavingString();
  }

  private void testNo29_InterleavingString() {
    log.info("result true v.s. " + isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    log.info("result false v.s. " + isInterleave("aabcc", "dbbca", "aadbbbaccc"));
  }

  public boolean isInterleave(String s1, String s2, String s3) {
    // filter abnormal cases
    if (s1 == null || s1.length() == 0) {
      if (s2 == null) {
        return s3 == null;
      } else {
        return s2.equals(s3);
      }
    }
    if (s2 == null || s2.length() == 0) {
      if (s1 == null) {
        return s3 == null;
      } else {
        return s1.equals(s3);
      }
    }
    if (s3 == null || s3.length() == 0 || s3.length() != (s1.length() + s2.length())) {
      return false;
    }

    int m = s1.length();
    int n = s2.length();
    boolean[][] dp = new boolean[m + 1][n + 1];
    for (int i = 0; i <= m; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 && j == 0) {
          dp[i][j] = true;
        } else if (i == 0) {
          dp[0][j] = s3.charAt(j - 1) == s2.charAt(j - 1) && dp[0][j - 1];
        } else if (j == 0) {
          dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1) && dp[i - 1][0];
        } else {
          dp[i][j] = (s3.charAt(i + j - 1) == s1.charAt(i - 1) && dp[i - 1][j]) ||
                  (s3.charAt(i + j - 1) == s2.charAt(j - 1) && dp[i][j - 1]);
        }
      }
    }

    // return the final result
    return dp[m][n];
  }

}
