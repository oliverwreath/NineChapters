package com.leetcode.SmarkingAlgorithmContest;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC440KthSmallestInLexicographicalOrder {

  public int findKthNumber(int n, int k) {
    long curr = 1;
    k = k - 1;
    while (k > 0) {
      long steps = calSteps(n, curr, curr + 1);
      if (steps <= k) {
        curr += 1;
        k -= steps;
      } else {
        curr *= 10;
        k -= 1;
      }
    }
    return (int) curr;
  }

  public long calSteps(int n, long from, long to) {
    long steps = 0, curr = from, next = to;
    while (curr <= n) {
      steps += Math.min(n + 1L, next) - curr;
      curr *= 10;
      next *= 10;
    }
    return steps;
  }
}
