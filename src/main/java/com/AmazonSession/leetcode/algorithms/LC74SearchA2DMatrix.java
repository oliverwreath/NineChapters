package com.AmazonSession.leetcode.algorithms;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC74SearchA2DMatrix {
  public static void main(String[] arg) {
    new LC74SearchA2DMatrix().testLC74SearchA2DMatrix();
  }

  private void testLC74SearchA2DMatrix() {
    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 3));
    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 1));
    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 10));

    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 23));

    log.info("7 true = {}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 7));
    log.info("20 true = {}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 20));
    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 50));
    log.info("{}", searchMatrix(new int[][]{
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 50}
    }, 24));
  }

  public boolean searchMatrix(int[][] matrix, int target) {

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return false;
    }

    //
    int n = matrix.length;
    int m = matrix[0].length;
    int row = 0;
    if (n == 1) {
      row = 0;
    } else {
      int start = 0;
      int end = n - 1;
      while (start + 1 < end) {
        int mid = start + (end - start) / 2;
        if (matrix[mid][0] == target) {
          return true;
        } else if (matrix[mid][0] < target) {
          start = mid;
        } else {
          end = mid;
        }
      }
      if (matrix[end][0] <= target) {
//                if (matrix[row][end] == target) {
//                    return true;
//                }
        row = end;
//                log.debug("row = end = " + row);
      } else if (matrix[start][0] <= target) {
//                if (matrix[row][start] == target) {
//                    return true;
//                }
        row = start;
//                log.debug("row = start = " + row);
      } else {
        return false;
      }
    }
//        log.debug("row = " + row);
    int start = 0;
    int end = m - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (matrix[row][mid] == target) {
        return true;
      } else if (matrix[row][mid] < target) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (matrix[row][start] == target) {
      return true;
    } else if (matrix[row][end] == target) {
      return true;
    }

    return false;
  }
}
