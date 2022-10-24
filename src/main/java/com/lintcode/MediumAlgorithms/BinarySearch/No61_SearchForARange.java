package com.lintcode.MediumAlgorithms.BinarySearch;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No61_SearchForARange {

  public static void main(String[] args) {
    No61_SearchForARange No61_SearchForARange = new No61_SearchForARange();
    No61_SearchForARange.testNo61_SearchForARange();
  }

  private void testNo61_SearchForARange() {
    int[] A = {5, 7, 7, 8, 8, 10};
    log.info("result 2 v.s. " + Arrays.toString(searchRange(A, 8)));
  }

  public int[] searchRange(int[] A, int target) {
    // filter abnormal cases
    int[] results = new int[]{-1, -1};
    if (A == null || A.length == 0) {
      return results;
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
    if (A[begin] == target) {
      results[0] = begin;
    } else if (A[end] == target) {
      results[0] = end;
    }

    begin = 0;
    end = A.length - 1;
    while (begin + 1 < end) {
      int mid = (end - begin) / 2 + begin;
      if (A[mid] <= target) {
        begin = mid;
      } else {
        end = mid;
      }
    }
    if (A[end] == target) {
      results[1] = end;
    } else if (A[begin] == target) {
      results[1] = begin;
    }

    // return the final result
    return results;
  }

}
