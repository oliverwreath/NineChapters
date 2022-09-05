package com.leetcode.Weekly68;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class LC766ToeplitzMatrix {
  private static final boolean isDebugging = false;

  public static void main(String[] args) {
    testNo766_ToeplitzMatrix();
  }

  private static void testNo766_ToeplitzMatrix() {
    LC766ToeplitzMatrix LC766ToeplitzMatrix = new LC766ToeplitzMatrix();
    log.info("result False v.s. " + LC766ToeplitzMatrix.isToeplitzMatrix(new int[][]{
            {1, 2},
            {2, 2}
    }));
    log.info("result True v.s. " + LC766ToeplitzMatrix.isToeplitzMatrix(new int[][]{
            {1, 2}
    }));
    log.info("result True v.s. " + LC766ToeplitzMatrix.isToeplitzMatrix(new int[][]{
            {1}
    }));
    log.info("result True v.s. " + LC766ToeplitzMatrix.isToeplitzMatrix(new int[][]{
            {1, 2, 3, 4},
            {5, 1, 2, 3},
            {9, 5, 1, 2}
    }));
//        log.info("result 1 v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix("10"));
  }

  /**
   * @param matrix
   * @return
   */
  public boolean isToeplitzMatrix(int[][] matrix) {
    // filter abnormal cases
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return true;
    }

    // core logic
    int m = matrix.length;
    int n = matrix[0].length;
    if (isDebugging) {
      for (int[] aMatrix : matrix) {
        log.debug(Arrays.toString(aMatrix));
      }
      for (int T = m - 1; T >= 0; T--) {
        int i = T;
        int j = 0;
        final int target = matrix[i][j];
        log.debug("Shu: " + matrix[i][j]);
        i++;
        j++;
        while (isValid(i, j, m, n)) {
          log.debug("Shu: " + matrix[i][j]);
          if (matrix[i][j] != target) {
            return false;
          }
          i++;
          j++;
        }
      }
      for (int T = 1; T < n; T++) {
        int i = 0;
        int j = T;
        final int target = matrix[i][j];
        log.debug("heng: " + matrix[i][j]);
        i++;
        j++;
        while (isValid(i, j, m, n)) {
          log.debug("heng: " + matrix[i][j]);
          if (matrix[i][j] != target) {
            return false;
          }
          i++;
          j++;
        }
      }
    }

    for (int T = m - 1; T >= 0; T--) {
      int i = T;
      int j = 0;
      final int target = matrix[i][j];
      i++;
      j++;
      while (isValid(i, j, m, n)) {
        if (matrix[i][j] != target) {
          return false;
        }
        i++;
        j++;
      }
    }
    for (int T = 1; T < n; T++) {
      int i = 0;
      int j = T;
      final int target = matrix[i][j];
      i++;
      j++;
      while (isValid(i, j, m, n)) {
        if (matrix[i][j] != target) {
          return false;
        }
        i++;
        j++;
      }
    }

    // return the final result
    return true;
  }

  private boolean isValid(int x, int y, int m, int n) {
    return x >= 0 && y >= 0 && x < m && y < n;
  }

}
