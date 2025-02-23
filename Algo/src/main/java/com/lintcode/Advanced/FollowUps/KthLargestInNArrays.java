package com.lintcode.Advanced.FollowUps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class KthLargestInNArrays {

  public static void main(String[] arg) {
    new KthLargestInNArrays().testKthLargestInNArrays();
  }

  private void testKthLargestInNArrays() {
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 1));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 2));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 3));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 4));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 5));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 6));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 7));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 8));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 9));
    log.info("{}", KthInArrays(new int[][]{{1, 5, 7},
        {3, 7, 8},
        {4, 8, 9},}, 10));

    log.info("{}", KthInArrays(new int[][]{{9, 3, 2, 4, 7}, {1, 2, 3, 4, 8}}, 3));
    log.info("{}", KthInArrays(new int[][]{{9, 3, 2, 4, 8}, {1, 2, 3, 4, 2}}, 1));

    log.info("{}", KthInArrays(new int[][]{
        {11},
        {1, 2, 3, 4, 112, 87},
        {564},
        {789, 12, 15}}, 7));
  }

  /**
   * @param arrays a list of array
   * @param k      an integer
   * @return an integer, K-th largest element in N arrays
   */
  public int KthInArrays(int[][] arrays, int k) {

    if (arrays == null || arrays.length == 0) {
      return -1;
    }
    if (k == 0) {
      return -1;
    }

    int n = arrays.length;
    int m = arrays[0].length;
    PriorityQueue<Cell> heap = new PriorityQueue<Cell>(n, cellComparator);
    for (int i = 0; i < n; i++) {
      Arrays.sort(arrays[i]);
      if (arrays[i].length > 0) {
        heap.add(new Cell(arrays[i][arrays[i].length - 1], i, arrays[i].length - 1));
      }
    }
    for (int i = k; i > 1; i--) {
      Cell poll = heap.poll();
      if (poll.y > 0) {
        heap.add(new Cell(arrays[poll.x][poll.y - 1], poll.x, poll.y - 1));
      }
    }

    if (heap.isEmpty()) {
      return -1;
    } else {
      return heap.poll().val;
    }
  }

  Comparator<Cell> cellComparator = new Comparator<Cell>() {
    public int compare(Cell o1, Cell o2) {
      return o2.val - o1.val;
    }
  };

  private class Cell {

    int val;
    int x;
    int y;

    public Cell() {
    }

    public Cell(int val, int x, int y) {
      this.val = val;
      this.x = x;
      this.y = y;
    }
  }
}
