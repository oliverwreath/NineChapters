package com.leetcode.Weekly53;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC691StickersToSpellWord {
  public static void main(String[] args) {
    testStickersToSpellWord_691();
  }

  private static void testStickersToSpellWord_691() {
    LC691StickersToSpellWord LC691StickersToSpellWord = new LC691StickersToSpellWord();
    log.info("result 2 v.s. " + LC691StickersToSpellWord.longestIncreasingContinuousSubsequence(new int[]{}));
    log.info("result 1 v.s. " + LC691StickersToSpellWord.longestIncreasingContinuousSubsequence(new int[]{}));
  }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  int longestIncreasingContinuousSubsequence(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    // return the final result
    return -1;
  }

}
