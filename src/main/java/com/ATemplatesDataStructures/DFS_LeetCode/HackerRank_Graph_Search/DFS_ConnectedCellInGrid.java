package com.ATemplatesDataStructures.DFS_LeetCode.HackerRank_Graph_Search;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * recursive DFS
 */
@Slf4j
public class DFS_ConnectedCellInGrid {
  public static void main(String[] arg) {
    new DFS_ConnectedCellInGrid().testDFS_ConnectedCellInGrid();
  }

  private void testDFS_ConnectedCellInGrid() {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int m = in.nextInt();
    int grid[][] = new int[n][m];
    for (int grid_i = 0; grid_i < n; grid_i++) {
      for (int grid_j = 0; grid_j < m; grid_j++) {
        grid[grid_i][grid_j] = in.nextInt();
      }
    }
    log.debug("{}", getBiggestRegion(grid));
  }

  private static int getBiggestRegion(int[][] matrix) {

    if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
      return 0;
    }

    // DFS core logic
    int n = matrix.length;
    int m = matrix[0].length;
    int maxCount = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (matrix[i][j] == 1) {
          int tmpCount = dfsHelper(n, m, i, j, matrix);
          maxCount = Math.max(maxCount, tmpCount);
        }
      }
    }

    // return the answer
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(matrix[i]));
//        }
    return maxCount;
  }

  private static int dfsHelper(int n, int m, int i, int j, int[][] matrix) {
    if (valid(i, j, n, m)) {
      if (matrix[i][j] == 1) {
        int count = 1;
        matrix[i][j] = -1;
        // up
        count += dfsHelper(n, m, i - 1, j, matrix);
        // down
        count += dfsHelper(n, m, i + 1, j, matrix);
        // left
        count += dfsHelper(n, m, i, j - 1, matrix);
        // right
        count += dfsHelper(n, m, i, j + 1, matrix);
        // diagonal
        count += dfsHelper(n, m, i - 1, j - 1, matrix);
        count += dfsHelper(n, m, i - 1, j + 1, matrix);
        count += dfsHelper(n, m, i + 1, j - 1, matrix);
        count += dfsHelper(n, m, i + 1, j + 1, matrix);
        return count;
      }
    }
    return 0;
  }

  private static boolean valid(int i, int j, int n, int m) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

}
