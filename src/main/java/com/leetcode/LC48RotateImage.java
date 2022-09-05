package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * Approach 1: Rotate Groups of Four Cells.
 * Approach 2: Reverse on Diagonal and then Reverse Left to Right.
 */
@Slf4j
public class LC48RotateImage {
  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
      return;

    int n = matrix.length;
    for (int i = 0; i < (n + 1)/ 2; i++) {
      for (int j = 0; j < n-1-2*i; j++) {
        int upper = n - 1 - i;
        int lower = 0 + i;
        int tmp = matrix[upper][lower+j];
        matrix[upper][lower+j] = matrix[upper-j][upper];
        matrix[upper-j][upper] = matrix[lower][upper-j];
        matrix[lower][upper-j] = matrix[lower+j][lower];
        matrix[lower+j][lower] = tmp;
      }
    }
  }

  public void rotate2(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
      return;

    transpose(matrix);
    reflect(matrix);
  }

  private static void transpose(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = tmp;
      }
    }
  }

  private static void reflect(int[][] matrix) {
    int n = matrix.length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n / 2; j++) {
        int tmp = matrix[i][j];
        matrix[i][j] = matrix[i][n -1-j];
        matrix[i][n -1-j] = tmp;
      }
    }
  }
}
