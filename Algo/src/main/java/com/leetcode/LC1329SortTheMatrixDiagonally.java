package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver; Solution1: Sort each diagonal one at a time (with Collections.sort()) T: O(mn log(min(m,n))), S:
 * O(min(m,n)); Solution2: Use Counting Sort (linear) to speed it up. T: O(mn), S: O(min(m,n))
 */
@Slf4j
public class LC1329SortTheMatrixDiagonally {

  public int[][] diagonalSort(int[][] mat) {
    if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0)
      return mat;

    int m = mat.length;
    int n = mat[0].length;
    for (int r = 0; r < m; r++) {
      sortDiagonal(r, 0, mat);
    }
    for (int c = 0; c < n; c++) {
      sortDiagonal(0, c, mat);
    }
    return mat;
  }

  private void sortDiagonal(int r, int c, int[][] mat) {
    int m = mat.length;
    int n = mat[0].length;

    List<Integer> diagonal = new ArrayList<>();

    int diagonalLength = Math.min(m - r, n - c);
    for (int i = 0; i < diagonalLength; i++) {
      diagonal.add(mat[r + i][c + i]);
    }
//    Collections.sort(diagonal);
    diagonal = countingSort(diagonal);// linear

    for (int i = diagonalLength - 1; i >= 0; i--) {
      mat[r + i][c + i] = diagonal.remove(diagonal.size() - 1);
    }
  }

  private List<Integer> countingSort(List<Integer> list) {
    int min = 1;
    int max = 100;

    int len = max - min + 1;
    int[] counts = new int[len];
    for (int num : list) {
      counts[num - min]++;
    }

    ArrayList<Integer> sorted = new ArrayList<>();
    for (int i = 0; i < len; i++) {
      for (int count = 0; count < counts[i]; count++) {
        sorted.add(i + min);
      }
    }
    return sorted;
  }
}
