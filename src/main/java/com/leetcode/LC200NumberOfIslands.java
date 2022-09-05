package com.leetcode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC200NumberOfIslands {
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
      return 0;

    int counter = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == '1') {
          bfs(grid, i, j);
          counter++;
        }
      }
    }

    return counter;

  }

  private void bfs(char[][] grid, int r, int c) {
    int m = grid.length;
    int n = grid[0].length;
    if (r < 0 || r >= m || c < 0 || c >= n)
      return;
    if (grid[r][c] != '1')
      return;

    grid[r][c] = '#';
    bfs(grid, r+1, c);
    bfs(grid, r-1, c);
    bfs(grid, r, c+1);
    bfs(grid, r, c-1);
  }
}
