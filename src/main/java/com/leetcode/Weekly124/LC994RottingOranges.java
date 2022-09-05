package com.leetcode.Weekly124;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
@Slf4j
public class LC994RottingOranges {
  public int orangesRotting(int[][] grid) {
    // filter abnormal cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    // searching logic
    int m = grid.length, n = grid[0].length;
    List<Point> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) {
          list.add(new Point(i, j));
        }
      }
    }

    int turns = 0;
    boolean isMakingProgress = true;
    while (isMakingProgress) {
      isMakingProgress = false;
      List<Point> tmpList = new ArrayList<>();
      for (Point point : list) {
        for (int t = 0; t < 4; t++) {
          int x = dx[t] + point.x;
          int y = dy[t] + point.y;
          if (x >= 0 && y >= 0 && x < m && y < n) {
            if (grid[x][y] == 1) {
              grid[x][y] = 2;
              tmpList.add(new Point(x, y));
              isMakingProgress = true;
            }
          }
        }
      }
      if (isMakingProgress) {
        list.addAll(tmpList);
        turns++;
      }
    }

    // return the final result
    return hasFresh(grid) ? -1 : turns;
  }

  int[] dx = new int[]{0, 0, 1, -1};
  int[] dy = new int[]{1, -1, 0, 0};

  private boolean hasFresh(int[][] grid) {
    int m = grid.length, n = grid[0].length;
    for (int[] row : grid) {
      for (int j = 0; j < n; j++) {
        if (row[j] == 1) {
          return true;
        }
      }
    }
    return false;
  }

  private class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
