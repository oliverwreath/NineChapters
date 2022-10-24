package com.ATemplatesDataStructures.DP.RangeDP;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No430_ScrambleString {

  public static void main(String[] args) {
    No430_ScrambleString No476_StoneGame = new No430_ScrambleString();
    No476_StoneGame.testNo476_StoneGame();
  }

  private void testNo476_StoneGame() {
    log.info("result true v.s. " + isScramble("abcd", "badc"));
//        log.info("result true v.s. " + isScramble("rgtae", "great"));
//        log.info("result false v.s. " + isScramble("rgtae", "grea"));
  }

  public boolean isScramble(String s1, String s2) {
    // filter abnormal cases
    if (s1 == null || s1.length() == 0) {
      return s2 == null || s2.length() == 0;
    }
    if (s1.length() != s2.length()) {
      return false;
    }

    int len = s1.length();
    dp = new boolean[len][len][len + 1];
//        sum = new int[len][len];
    flag = new boolean[len][len][len + 1];
    for (int i = 0; i < len; ++i) {
      for (int j = 0; j < len; ++j) {
        dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
      }
    }

    for (int i = 0; i < len; ++i) {
      for (int j = 0; j < len; ++j) {
        log.debug(Arrays.toString(dp[i][j]));
      }
      log.debug("");
    }

    // return the final result
    return helper(0, 0, len);
  }

  boolean[][][] dp;
  //    int[][] sum;
  boolean[][][] flag;

  boolean helper(int x, int y, int n) {
    if (flag[x][y][n]) {
      return dp[x][y][n];
    }
    flag[x][y][n] = true;
//        if (n == 1) {
//            dp[x][y][n] = s1.charAt(x) == s2.charAt(y);
//            return dp[x][y][n];
//        }

    for (int k = 1; k < n; k++) {
      dp[x][y][n] |= (helper(x, y, k) && helper(x + k, y + k, n - k)) ||
          (helper(x, y + n - k, k) && helper(x + k, y, n - k));
    }
    return dp[x][y][n];
  }

}
