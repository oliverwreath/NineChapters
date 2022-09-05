package com.ATemplatesDataStructures.Algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class LIS {
  public static void main(String[] args) {
    //code
    Scanner scanner = new Scanner(System.in);
    int tt = scanner.nextInt();
    for (int t = 0; t < tt; t++) {
      int n = scanner.nextInt();
      if (n < 1) {
        log.debug(String.valueOf(0));
        continue;
      }
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scanner.nextInt();
      }

      // DP
      int[] dp = new int[n];
      dp[0] = 1;
      int globalMax = 1;
      for (int i = 1; i < n; i++) {
        dp[i] = 1;
        int max = 0;
        for (int j = 0; j < i; j++) {
          if (a[j] < a[i]) {
            max = Math.max(max, dp[j]);
          }
        }
        dp[i] += max;
        globalMax = Math.max(globalMax, dp[i]);
      }
//            log.debug(Arrays.toString(dp));

      log.debug(String.valueOf(globalMax));
    }
  }

//    private static void testLIS() {
//        LIS LIS = new LIS();
//        log.info("result 2 v.s. " + LIS.longestIncreasingContinuousSubsequence("12"));
//        log.info("result 1 v.s. " + LIS.longestIncreasingContinuousSubsequence("10"));
//    }

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
