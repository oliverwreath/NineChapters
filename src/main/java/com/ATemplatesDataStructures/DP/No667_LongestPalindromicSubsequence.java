package com.ATemplatesDataStructures.DP;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No667_LongestPalindromicSubsequence {
  public static void main(String[] args) {
    No667_LongestPalindromicSubsequence No667_LongestPalindromicSubsequence = new No667_LongestPalindromicSubsequence();
    No667_LongestPalindromicSubsequence.testNo667_LongestPalindromicSubsequence();
  }

  private void testNo667_LongestPalindromicSubsequence() {
    log.info("result 4 v.s. " + longestPalindromeSubseq("bbbab"));
  }

  int longestPalindromeSubseq(String S) {
    // filter abnormal cases
    if (S == null || S.length() == 0) {
      return 0;
    }

    this.S = S;
    int len = S.length();
    this.flag = new boolean[len][len];
    this.dp = new int[len][len];
    helper(0, len - 1);

    // return the final result
    return dp[0][len - 1];
  }

  String S;
  boolean[][] flag;
  int[][] dp;

  int helper(int i, int j) {
    if (i > j) {
      return 0;
    }
    if (flag[i][j]) {
      return dp[i][j];
    }
    flag[i][j] = true;

    if (i == j) {
      dp[i][j] = 1;
      return dp[i][j];
    } else {
      if (S.charAt(i) == S.charAt(j)) {
        dp[i][j] = 2 + helper(i + 1, j - 1);
      } else {
        dp[i][j] = Math.max(helper(i + 1, j), helper(i, j - 1));
      }
      return dp[i][j];
    }
  }

}
