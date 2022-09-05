package com.ATemplatesDataStructures.Algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class LCS {
  public static void main(String[] args) {
    //code
    Scanner scanner = new Scanner(System.in);
    int T = scanner.nextInt();
    for (int t = 0; t < T; t++) {
      int m = scanner.nextInt();
      int n = scanner.nextInt();
      if (m < 1) {
        log.debug(String.valueOf(n));
      } else if (n < 1) {
        log.debug(String.valueOf(m));
      }
      String string1 = scanner.next();
      String string2 = scanner.next();
      int[][] dp = new int[m][n];
      int globalMax = 0;
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          if (string1.charAt(i) == string2.charAt(j)) {
            int localMax = 0;
            for (int x = 0; x < i; x++) {
              for (int y = 0; y < j; y++) {
                localMax = Math.max(localMax, dp[x][y]);
              }
            }
            dp[i][j] = localMax + 1;
            globalMax = Math.max(globalMax, dp[i][j]);
          }
        }
      }

      log.debug(String.valueOf(globalMax));
    }
  }

  /**
   * @param a an array of Integer
   * @return an integer
   */
  int longestIncreasingContinuousSubsequence(int[] a) {
    // filter abnormal cases
    if (a == null || a.length == 0) {
      return 0;
    }

    // return the final result
    return -1;
  }

}
