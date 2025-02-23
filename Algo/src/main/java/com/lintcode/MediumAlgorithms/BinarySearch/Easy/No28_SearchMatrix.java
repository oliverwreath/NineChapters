package com.lintcode.MediumAlgorithms.BinarySearch.Easy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No28_SearchMatrix {

  public static void main(String[] args) {
    No28_SearchMatrix No28_SearchMatrix = new No28_SearchMatrix();
    No28_SearchMatrix.testNo28_SearchMatrix();
  }

  private void testNo28_SearchMatrix() {
    int[][] matrix = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 50}
    };
    log.info("result true v.s. " + searchMatrix(matrix, 3));
  }

  public boolean searchMatrix(int[][] A, int target) {
    // filter abnormal cases
    if (A == null || A.length == 0 || A[0] == null || A[0].length == 0) {
      return false;
    }

    int m = A.length, n = A[0].length;
    int begin = 0, end = m * n - 1;
    while (begin + 1 < end) {
      int mid = (end - begin) / 2 + begin;
      if (A[mid / n][mid % n] < target) {
        begin = mid;
      } else {
        end = mid;
      }
    }
    if (A[begin / n][begin % n] == target) {
      return true;
    } else if (A[end / n][end % n] == target) {
      return true;
    }

    // return the final result
    return false;
  }

}
