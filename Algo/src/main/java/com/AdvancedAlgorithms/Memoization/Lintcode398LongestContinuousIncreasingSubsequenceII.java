package com.AdvancedAlgorithms.Memoization;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply working. aka DFS. TLE huh? TIME: O(NM ^ NM) SPACE: O(NM)
 * <p>
 * Version 2: DP principle is all about removing redundant computation. So memoization should come in handy. TIME: O(NM)
 * SPACE: O(NM)
 */
@Slf4j
public class Lintcode398LongestContinuousIncreasingSubsequenceII {

  private int[][] dp;

  public int longestContinuousIncreasingSubsequence2(int[][] grid) {
    // filter abnormal cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    // dp logic
    int m = grid.length, n = grid[0].length;
    boolean[][] hasVisited = new boolean[m][n];
    dp = new int[m][n];
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        dp[x][y] = -1;
      }
    }

    int max = 0;
    for (int x = 0; x < m; x++) {
      for (int y = 0; y < n; y++) {
        hasVisited[x][y] = true;
        dfs(grid, x, y, hasVisited);
        hasVisited[x][y] = false;
        max = Math.max(max, dp[x][y]);
      }
    }

    // return the final result
    return max;
  }

  private final int[] dx = new int[]{0, 0, 1, -1};
  private final int[] dy = new int[]{1, -1, 0, 0};

  private int dfs(int[][] grid, int x, int y, boolean[][] hasVisited) {
    // already calculated.
    if (dp[x][y] != -1) {
      return dp[x][y];
    }

    int m = grid.length, n = grid[0].length;
    dp[x][y] = 1;
    for (int t = 0; t < 4; t++) {
      int nx = x + dx[t];
      int ny = y + dy[t];
      if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
        continue;
      }
      if (hasVisited[nx][ny]) {
        continue;
      }
      if (grid[nx][ny] <= grid[x][y]) {
        continue;
      }
      hasVisited[nx][ny] = true;
      dp[x][y] = Math.max(dp[x][y], dfs(grid, nx, ny, hasVisited) + 1);
      hasVisited[nx][ny] = false;
    }
    return dp[x][y];
  }

}
