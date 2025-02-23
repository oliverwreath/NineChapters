package com.leetcode.Weekly57;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC720LongestWordInDictionary {

  public static void main(String[] args) {
    testLongestWordInDictionary_720();
  }

  private static void testLongestWordInDictionary_720() {
    LC720LongestWordInDictionary LC720LongestWordInDictionary = new LC720LongestWordInDictionary();
//        log.info("result 2 v.s. " + LongestWordInDictionary_720.longestIncreasingContinuousSubsequence("12"));
//        log.info("result 1 v.s. " + LongestWordInDictionary_720.longestIncreasingContinuousSubsequence("10"));
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
