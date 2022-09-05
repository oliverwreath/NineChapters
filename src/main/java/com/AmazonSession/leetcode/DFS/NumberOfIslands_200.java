package com.AmazonSession.leetcode.DFS;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class NumberOfIslands_200 {
  public static void main(String[] arg) {
    new NumberOfIslands_200().testNumberOfIslands_200();
  }

  private void testNumberOfIslands_200() {
    log.info("{}", numIslands(new char[][]{
                    {'1', '1', '0', '0', '0'},
                    {'1', '1', '0', '0', '0'},
                    {'0', '0', '1', '0', '0'},
                    {'0', '0', '0', '1', '1'},
            }
    ));
  }

  public int numIslands(char[][] grid) {

    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    // dfs
    int n = grid.length;
    int m = grid[0].length;
    boolean[][] visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j] == '1' && !visited[i][j]) {
          dfs(grid, visited, i, j, n, m);
          counter++;
        }
      }
    }

    return counter;
  }

  private int counter = 0;

  private void dfs(char[][] grid, boolean[][] visited, int i, int j, int n, int m) {
    visited[i][j] = true;
    for (int t = 0; t < dx.length; t++) {
      int X = i + dx[t];
      int Y = j + dy[t];
      if (isValid(X, Y, n, m) && !visited[X][Y] && grid[X][Y] == '1') {
        dfs(grid, visited, X, Y, n, m);
      }
    }
  }

  private boolean isValid(int i, int j, int n, int m) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

  private int[] dx = new int[]{0, 0, 1, -1};
  private int[] dy = new int[]{1, -1, 0, 0};

}
