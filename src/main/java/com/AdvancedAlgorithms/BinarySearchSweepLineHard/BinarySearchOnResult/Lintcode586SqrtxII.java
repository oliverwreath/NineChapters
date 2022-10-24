package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult;

import lombok.extern.slf4j.Slf4j;

/**
 * beautifully done! binary search with caution that if x < 1, we need to search up to 1.
 */
@Slf4j
public class Lintcode586SqrtxII {

  private static final double EPSILON = 1e-12;

  public double sqrt(double x) {
    // filter abnormal cases
    if (x == 0) {
      return 0;
    }

    double left = 0, right = x > 1 ? x : 1;
    while (left + EPSILON < right) {
      double mid = left + (right - left) / 2;
      if (mid * mid < x) {
        left = mid;
      } else if (mid * mid > x) {
        right = mid;
      } else {
        return mid;
      }
    }
    // return the final result
    if (Math.abs(right * right - x) < EPSILON) {
      return right;
    } else {
      return left;
    }
  }
}
