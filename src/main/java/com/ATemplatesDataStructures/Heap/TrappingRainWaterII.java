package com.ATemplatesDataStructures.Heap;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class TrappingRainWaterII {
  public static void main(String[] arg) {
    testTrappingRainWaterII();
  }

  private static void testTrappingRainWaterII() {
    log.info("14 == {}", new TrappingRainWaterII().trapRainWater(new int[][]{
            {12, 13, 0, 12},
            {13, 4, 13, 12},
            {13, 8, 10, 12},
            {12, 13, 12, 12},
            {13, 13, 13, 13}}));
  }

  /**
   * @param heights: a matrix of integers
   * @return: an integer
   */
  public int trapRainWater(int[][] heights) {

    //
    if (heights == null || heights.length < 3 || heights[0].length < 3) {
      return 0;
    }

    //
    int m = heights.length;
    int n = heights[0].length;
    boolean[][] visited = new boolean[m][n];
    PriorityQueue<Cell> heap = new PriorityQueue<>((o1, o2) -> o1.h - o2.h);
    for (int i = 1; i < m - 1; i++) {
      heap.add(new Cell(i, 0, heights[i][0]));
      heap.add(new Cell(i, n - 1, heights[i][n - 1]));
      visited[i][0] = true;
      visited[i][n - 1] = true;
    }
    for (int j = 1; j < n - 1; j++) {
      heap.add(new Cell(0, j, heights[0][j]));
      heap.add(new Cell(m - 1, j, heights[m - 1][j]));
      visited[0][j] = true;
      visited[m - 1][j] = true;
    }
    visited[0][0] = true;
    visited[0][n - 1] = true;
    visited[m - 1][0] = true;
    visited[m - 1][n - 1] = true;
    int max = Integer.MIN_VALUE;
    int countDown = (m - 2) * (n - 2);
    int result = 0;
    while (countDown > 0) {
      Cell cell = heap.poll();
      max = Math.max(max, cell.h);
      for (int i = 0; i < 4; i++) {
        int x = cell.x + dx[i];
        int y = cell.y + dy[i];
        if (isValidNotVisited(x, y, m, n, visited)) {
          if (max > heights[x][y]) {
            result += max - heights[x][y];
          }
          visited[x][y] = true;
          heap.add(new Cell(x, y, heights[x][y]));
          countDown--;
        }
      }
    }

    return result;
  }

  int[] dx = new int[]{0, 0, 1, -1};
  int[] dy = new int[]{1, -1, 0, 0};

  private boolean isValid(int x, int y, int m, int n) {
    return x >= 0 && y >= 0 && x < m && y < n;
  }

  private boolean isValidNotVisited(int x, int y, int m, int n, boolean[][] visited) {
    return isValid(x, y, m, n) && !visited[x][y];
  }

  class Cell {
    int x;
    int y;
    int h;

    public Cell(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }

    @Override
    public String toString() {
      return "Cell{" +
              "x=" + x +
              ", y=" + y +
              ", h=" + h +
              '}';
    }
  }
}
