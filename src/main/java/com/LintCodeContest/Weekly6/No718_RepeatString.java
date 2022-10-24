package com.LintCodeContest.Weekly6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No718_RepeatString {

  public static void main(String[] args) {
    No718_RepeatString No718_RepeatString = new No718_RepeatString();
    No718_RepeatString.testNo718_RepeatString();
  }

  private void testNo718_RepeatString() {
    log.info("result 3 v.s. " + repeatedString("abcd", "cdabcdab"));
  }

  int repeatedString(String A, String B) {
    // filter abnormal cases
    if (A == null || A.length() == 0) {
      if (B == null || B.length() == 0) {
        return 1;
      } else {
        return -1;
      }
    }
    if (A.contains(B)) {
      return 1;
    }
    int m = A.length();
    int n = B.length();
    int k = (n - 2) / m + 2 + ((n - 2) % m == 0 ? 0 : 1);
    int[][] dp = new int[m * k + 1][n + 1];
    for (int i = 0; i <= m * k; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else {
          if (A.charAt((i - 1) % m) == B.charAt(j - 1)) {
            dp[i][j] = 1 + dp[i - 1][j - 1];
          } else {
            dp[i][j] = 0;
          }
        }
        if (dp[i][j] == B.length()) {
          return (i % m == 0 ? 0 : 1) + (i / m);
        }
      }
    }

//        System.out.print("   ");
//        for (int j = 0; j <= n; j++) {
//            System.out.print(j + ", ");
//        }
//        log.debug("");
//        for (int i = 0; i <= m * k; i++) {
//            log.debug(i + " " + Arrays.toString(dp[i]));
//        }

    return -1;
  }

}
