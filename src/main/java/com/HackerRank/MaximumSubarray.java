package com.HackerRank;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MaximumSubarray {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int caseI = 0; caseI < t; caseI++) {
      int n = scan.nextInt();
      int[] a = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = scan.nextInt();
      }
      maximumSub(a);
    }
  }

  static void testMaximumSubarray() {
//        maximumSubarray();
  }

  static void maximumSub(int[] a) {
    int len = a.length;
    int max = a[0];
    int maxIndex = 0;
    for (int i = 1; i < len; i++) {
      if (a[i] > max) {
        max = a[i];
        maxIndex = i;
      }
    }

    maximumSubarray(a, len, max, maxIndex);
    maximumSubsequence(a, len, max, maxIndex);
  }

  static void maximumSubarray(int[] a, int len, int max, int maxIndex) {
    int maxSum = max;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += a[i];
      maxSum = Math.max(maxSum, sum);
      if (sum < 0) {
        sum = 0;
      }
    }

    System.out.format("%d ", maxSum);
  }

  static void maximumSubsequence(int[] a, int len, int max, int maxIndex) {
    int maxSum = max;
    for (int i = 0; i < len; i++) {
      if (maxIndex != i) {
        if (a[i] > 0) {
          maxSum += a[i];
        }
      }
    }

    log.debug("{}", maxSum);
  }
}
