package com.lintcode.MediumAlgorithms.BinarySearch.Easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No63_SearchInRotatedSortedArrayII {
  public static void main(String[] args) {
    No63_SearchInRotatedSortedArrayII No63_SearchInRotatedSortedArrayII = new No63_SearchInRotatedSortedArrayII();
    No63_SearchInRotatedSortedArrayII.testNo63_SearchInRotatedSortedArrayII();
  }

  private void testNo63_SearchInRotatedSortedArrayII() {
    log.info("result true v.s. " + search(new int[]{1, 1, 0, 1, 1, 1}, 0));
    log.info("result false v.s. " + search(new int[]{1, 1, 1, 1, 1, 1}, 0));
  }

  public boolean search(int[] A, int target) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return false;
    }

    // return the final result
    return false;
  }

}
