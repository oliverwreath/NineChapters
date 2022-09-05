package com.leetcode.Weekly8;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class LC417PacificAtlanticWaterFlow {
  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> res = new ArrayList<>();
    if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0)
      return res;

    int m = heights.length;
    int n = heights[0].length;
    boolean[][] pacific = new boolean[m][n];
    for (int r = 0; r < m; r++) {
      bfs(pacific, heights, r, 0, 0);
    }
    for (int c = 1; c < n; c++) {
      bfs(pacific, heights, 0, c, 0);
    }
    boolean[][] atlantic = new boolean[m][n];
    for (int r = 0; r < m; r++) {
      bfs(atlantic, heights, r, n - 1, 0);
    }
    for (int c = 0; c < n - 1; c++) {
      bfs(atlantic, heights, m - 1, c, 0);
    }

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (pacific[r][c] && atlantic[r][c])
          res.add(List.of(r, c));
      }
    }
    return res;
  }

  private void bfs(boolean[][] connected, int[][] h, int r, int c, int bar) {
    int m = h.length;
    int n = h[0].length;
    if (r < 0 || r >= m || c < 0 || c >= n)
      return;
    if (connected[r][c])
      return;
    if (h[r][c] < bar)
      return;

    bar = Math.max(bar, h[r][c]);
    connected[r][c] = true;
    bfs(connected, h, r + 1, c, bar);
    bfs(connected, h, r - 1, c, bar);
    bfs(connected, h, r, c + 1, bar);
    bfs(connected, h, r, c - 1, bar);
  }
}
