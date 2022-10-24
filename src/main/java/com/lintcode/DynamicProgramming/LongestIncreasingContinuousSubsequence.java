package com.lintcode.DynamicProgramming;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LongestIncreasingContinuousSubsequence {

  public static void main(String[] arg) {
    testLongestIncreasingContinuousSubsequence();
  }

  private static void testLongestIncreasingContinuousSubsequence() {
    log.info("result {} = {}", 4, longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
    log.info("result {} = {}", 4, longestIncreasingContinuousSubsequence(new int[]{5, 1, 2, 3, 4}));
  }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  static int longestIncreasingContinuousSubsequence(int[] A) {

    // filter abnormal inputs
    if (A == null || A.length == 0) {
      return 0;
    }

    // fill the subproblem results
    int maxLength = 1;
    int length = 1;
    int n = A.length;
    for (int i = 1; i < n; i++) {
      if (A[i - 1] < A[i]) {
        length++;
        maxLength = Math.max(maxLength, length);
      } else {
        length = 1;
      }
    }

    length = 1;
    for (int i = n - 2; i >= 0; i--) {
      if (A[i] > A[i + 1]) {
        length++;
        maxLength = Math.max(maxLength, length);
      } else {
        length = 1;
      }
    }

    // return the final result
    return maxLength;
  }

//    static int longestIncreasingContinuousSubsequence(int[] A) {
//    
//        // filter abnormal inputs
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // fill the subproblem results
//        int maxLength = 1;
//        int length = 1;
//        for (int i = 1; i < A.length; i++) {
//            if (A[i - 1] < A[i]) {
//                length++;
//                maxLength = Math.max(maxLength, length);
//            } else {
//                length = 1;
//            }
//        }
//        length = 1;
//        for (int i = A.length - 2; i >= 0; i--) {
//            if (A[i] > A[i + 1]) {
//                length++;
//                maxLength = Math.max(maxLength, length);
//            } else {
//                length = 1;
//            }
//        }
//
//        // return the final result
//        return maxLength;
//    }
}
