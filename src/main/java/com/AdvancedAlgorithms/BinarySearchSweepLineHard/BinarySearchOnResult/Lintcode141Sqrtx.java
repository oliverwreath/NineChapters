package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode141Sqrtx {
  public int sqrt(int x) {
    // filter abnormal cases
    if (x == 0) {
      return 0;
    }

    long left = 0, right = x;
    while (left + 1 < right) {
      long mid = left + (right - left) / 2;
      if (mid * mid < x) {
        left = mid;
      } else if (mid * mid > x) {
        right = mid;
      } else {
        return (int) mid;
      }
    }
    // return the final result
    if (right * right == x) {
      return (int) right;
    } else {
      return (int) left;
    }
  }
}
