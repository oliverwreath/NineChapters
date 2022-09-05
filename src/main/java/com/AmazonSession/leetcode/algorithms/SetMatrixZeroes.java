package com.AmazonSession.leetcode.algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class SetMatrixZeroes {
  public static void main(String[] arg) {
    new SetMatrixZeroes().testSetMatrixZeroes();
  }

  private void testSetMatrixZeroes() {
    int[][] matrix = {
            {9, 9, 0, 9},
            {9, 0, 9, 9},
            {9, 9, 0, 9},
            {9, 9, 9, 9}
    };
    log.info("before = ");
    for (int i = 0; i < matrix.length; i++) {
      log.info("{}", Arrays.toString(matrix[i]));
    }
    setZeroes(matrix);
    log.info("after = ");
    for (int i = 0; i < matrix.length; i++) {
      log.info("{}", Arrays.toString(matrix[i]));
    }
  }

  public void setZeroes(int[][] matrix) {

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }

    // in place
    int n = matrix.length;
    int m = matrix[0].length;
    // mark
    boolean i0 = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][0] = 0;
          if (j == 0) {
            i0 = true;
          } else {
            matrix[0][j] = 0;
          }
          printMatrix(matrix);
        }
      }
    }

    // paint
    for (int j = 1; j < m; j++) {
      if (matrix[0][j] == 0) {
        for (int i = 1; i < n; i++) {
          matrix[i][j] = 0;
        }
      }
    }
    for (int i = 0; i < n; i++) {
      if (matrix[i][0] == 0) {
        for (int j = 1; j < m; j++) {
          matrix[i][j] = 0;
        }
      }
    }
    if (i0) {
      for (int i = 0; i < n; i++) {
        matrix[i][0] = 0;
      }
    }
    printMatrix(matrix);

    return;
  }

  private void printMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return;
    }

    for (int[] ints : matrix) {
      log.debug(Arrays.toString(ints));
    }
  }
}
