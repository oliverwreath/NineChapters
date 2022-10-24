package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode364TrappingRainWaterII {

  public int trapRainWater(int[][] heights) {
    // filter abnormal cases
    if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
      return 0;
    }

    int result = 0;
    int m = heights.length, n = heights[0].length;
    boolean[][] isVisited = new boolean[m][n];
    PriorityQueue<Cell> minHeap = new PriorityQueue<>((o1, o2) -> o1.height - o2.height);
    for (int i = 0; i < m; i++) {
      minHeap.add(new Cell(i, 0, heights[i][0]));
      isVisited[i][0] = true;
      minHeap.add(new Cell(i, n - 1, heights[i][n - 1]));
      isVisited[i][n - 1] = true;
    }
    for (int j = 1; j < n - 1; j++) {
      minHeap.add(new Cell(0, j, heights[0][j]));
      isVisited[0][j] = true;
      minHeap.add(new Cell(m - 1, j, heights[m - 1][j]));
      isVisited[m - 1][j] = true;
    }

    while (true) {
      Cell minCell = minHeap.poll();
      boolean foundUnvisitedNeighbour = false;
      for (int t = 0; t < 4; t++) {
        int nx = minCell.x + dx[t];
        int ny = minCell.y + dy[t];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny]) {
          if (minCell.height > heights[nx][ny]) {
            result += minCell.height - heights[nx][ny];
          }
          minHeap.add(new Cell(nx, ny, Math.max(minCell.height, heights[nx][ny])));
          foundUnvisitedNeighbour = true;
          isVisited[nx][ny] = true;
        }
      }

      if (minHeap.isEmpty() && !foundUnvisitedNeighbour) {
        break;
      }
    }

    // return the final result
    return result;
  }

  private final int[] dx = new int[]{0, 0, 1, -1};
  private final int[] dy = new int[]{1, -1, 0, 0};

  class Cell {

    int height;
    int x;
    int y;

    public Cell(int x, int y, int height) {
      this.x = x;
      this.y = y;
      this.height = height;
    }

    @Override
    public String toString() {
      return "Cell{" +
          "height=" + height +
          ", x=" + x +
          ", y=" + y +
          '}';
    }
  }

}
