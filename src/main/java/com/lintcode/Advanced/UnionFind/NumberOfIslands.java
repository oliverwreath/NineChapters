package com.lintcode.Advanced.UnionFind;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class NumberOfIslands {

  public static void main(String[] arg) {
    new NumberOfIslands().testNumberOfIslands();
  }

  private void testNumberOfIslands() {
    log.info("{}", numIslands(
        new boolean[][]{
            {true, true, false, false, false},
            {false, true, false, false, true},
            {false, false, false, true, true},
            {false, false, false, false, false},
            {false, false, false, false, true}
        }
    ));
  }

  /**
   * @param grid a boolean 2D matrix
   * @return an integer
   */
  public int numIslands(boolean[][] grid) {

    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    // init UnionFindQuiz
    int n = grid.length;
    int m = grid[0].length;
    UnionFind unionFind = new UnionFind(n, m);
//        log.debug("n = " + n + "; m = " + m + " " + unionFind);

    // DFS
    int counter = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (grid[i][j]) {
          grid[i][j] = false;
          counter++;
          for (int t = 0; t < 4; t++) {
            int X = i + dx[t];
            int Y = j + dy[t];
            if (valid(X, Y, n, m) && grid[X][Y]) {
              if (unionFind.union(convert2Id(i, j, m), convert2Id(X, Y, m))) {
                counter--;
              }
            }
          }
        }
      }
    }

    return counter;
  }

  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};

  private boolean valid(int i, int j, int n, int m) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private int convert2Id(int x, int y, int m) {
    return x * m + y;
  }
}
