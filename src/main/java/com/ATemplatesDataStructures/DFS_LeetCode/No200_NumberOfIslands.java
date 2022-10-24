package com.ATemplatesDataStructures.DFS_LeetCode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No200_NumberOfIslands {

  public static void main(String[] args) {
    testNo200_NumberOfIslands();
  }

  private static void testNo200_NumberOfIslands() {
    No200_NumberOfIslands No200_NumberOfIslands = new No200_NumberOfIslands();
    log.info("result 1 v.s. " + No200_NumberOfIslands.numIslands(new char[][]{
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    }));
    log.info("result 3 v.s. " + No200_NumberOfIslands.numIslands(new char[][]{
        {'1', '1', '0', '0', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '1', '0', '0'},
        {'0', '0', '0', '1', '1'}
    }));
  }

  /**
   * @param grid
   * @return
   */
  public int numIslands(char[][] grid) {
    // filter abnormal cases
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    // DFS
    int counter = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
//            log.debug("DFS for i");
      for (int j = 0; j < n; j++) {
//                log.debug("DFS for j");
        if (grid[i][j] == '1') {
//                    log.debug("DFS for grid[i][j] == '1'");
          dfsHelper(i, j, m, n, grid);
          counter++;
        }
      }
    }

    // return the final result
    return counter;
  }

  private void dfsHelper(int i, int j, int m, int n, char[][] grid) {
    if (isValid(i, j, m, n) && grid[i][j] == '1') {
      grid[i][j] = '9';
      // horizontally
      dfsHelper(i, j - 1, m, n, grid);
      dfsHelper(i, j + 1, m, n, grid);
      // vertically
      dfsHelper(i - 1, j, m, n, grid);
      dfsHelper(i + 1, j, m, n, grid);
    }
  }

  private boolean isValid(int i, int j, int m, int n) {
    return i >= 0 && j >= 0 && i < m && j < n;
  }

}
