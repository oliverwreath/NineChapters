package com.lintcode.MediumAlgorithms.BinarySearch.Easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No60_SearchInsert {
  public static void main(String[] args) {
    No60_SearchInsert No60_SearchInsert = new No60_SearchInsert();
    No60_SearchInsert.testNo60_SearchInsert();
  }

  private void testNo60_SearchInsert() {
    log.info("result 2 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 5));
    log.info("result 1 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 2));
    log.info("result 4 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 7));
    log.info("result 0 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 0));
  }

  public int searchInsert(int[] A, int target) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int begin = 0, end = A.length - 1;
    while (begin + 1 < end) {
      int mid = (end - begin) / 2 + begin;
      if (A[mid] < target) {
        begin = mid;
      } else {
        end = mid;
      }
    }
    if (A[begin] >= target) {
      return begin;
    } else if (A[end] >= target) {
      return end;
    } else {
      return end + 1;
    }

    // return the final result
//        return -1;
  }

}
