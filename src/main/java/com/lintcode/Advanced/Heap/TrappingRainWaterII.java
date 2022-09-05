package com.lintcode.Advanced.Heap;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
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
    log.info("{}", trapRainWater(new int[][]{{12, 13, 0, 12},
            {13, 4, 13, 12},
            {13, 8, 10, 12},
            {12, 13, 12, 12},
            {13, 13, 13, 13}}));
  }

  /**
   * @param heights: a matrix of integers
   * @return: an integer
   */
  static int trapRainWater(int[][] heights) {

    // handle extreme inputs
    if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
      return 0;
    }

    // initialize the min heap, and the flag matrix to make sure we don't revisit a visited place.
    int n = heights.length;
    int m = heights[0].length;
    boolean[][] flag = new boolean[n][m];
    PriorityQueue<Cell> heap = new PriorityQueue<Cell>(4 * n, cellComparator);
    for (int i = 1; i < n - 1; i++) {
      flag[i][0] = true;
      flag[i][m - 1] = true;
      heap.add(new Cell(i, 0, heights[i][0]));
      heap.add(new Cell(i, m - 1, heights[i][m - 1]));
    }
    for (int j = 1; j < m - 1; j++) {
      flag[0][j] = true;
      flag[n - 1][j] = true;
      heap.add(new Cell(0, j, heights[0][j]));
      heap.add(new Cell(n - 1, j, heights[n - 1][j]));
    }
    flag[0][0] = true;
    flag[0][m - 1] = true;
    flag[n - 1][0] = true;
    flag[n - 1][m - 1] = true;

    long answer = 0;
//        log.debug("flag = ");
//        for (int i = 0; i < n; i++) {
//            log.debug(Arrays.toString(flag[i]));
//        }
    for (Cell cell : heap) {

    }
    while (!heap.isEmpty()) {
      Cell cell = heap.poll();
      int min = cell.val;
      for (int t = 0; t < 4; t++) {
        int i = cell.x + dx[t];
        int j = cell.y + dy[t];
        if (i >= 0 && i < n && j >= 0 && j < m) {
          if (!flag[i][j]) {
//                        log.debug("flag! i = " + i + "; j = " + j);
            if (heights[i][j] <= min) {
              answer += min - heights[i][j];
              heap.add(new Cell(i, j, min));
            } else {
              heap.add(new Cell(i, j, heights[i][j]));
            }
            flag[i][j] = true;
          }
        }
      }
    }

    // return the answer
    return (int) answer;
  }

  static Comparator<Cell> cellComparator = new Comparator<Cell>() {
    public int compare(Cell o1, Cell o2) {
      return o1.val - o2.val;
    }
  };

  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};

  static class Cell {
    int x;
    int y;
    int val;

    public Cell() {
    }

    public Cell(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public String toString() {
      return "Cell{" +
              "x=" + x +
              ", y=" + y +
              ", val=" + val +
              '}';
    }
  }
}
