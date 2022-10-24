package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode75FindPeakElement {

  public int findPeak(int[] a) {
    // filter abnormal cases
    if (a == null || a.length == 0) {
      return -1;
    }

    int left = 1, right = a.length - 2;
    while (left + 1 < right) {
      int mid = left + (right - left) / 2;
      if (a[mid] > a[mid - 1]) {
        left = mid;
      } else if (a[mid] > a[mid + 1]) {
        right = mid;
      } else {
        right = mid;
      }
    }
    if (a[left] > a[left - 1] && a[left] > a[left + 1]) {
      return left;
    }
    if (a[right] > a[right - 1] && a[right] > a[right + 1]) {
      return right;
    }

    // return the final result
    return -1;
  }
}
