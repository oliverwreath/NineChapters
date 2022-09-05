package com.lintcode.Advanced.FollowUps;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class KthSmallestSumInTwoSortedArrays {
  public static void main(String[] arg) {
    new KthSmallestSumInTwoSortedArrays().testKthLargestInNArrays();
  }

  private void testKthLargestInNArrays() {
    log.info("{}", kthSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
    log.info("{}", kthSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 4));
    log.info("{}", kthSmallestSum(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 8));
  }

  /**
   * @param A an integer arrays sorted in ascending order
   * @param B an integer arrays sorted in ascending order
   * @param k an integer
   * @return an integer
   */
  public int kthSmallestSum(int[] A, int[] B, int k) {

    if (A == null || A.length == 0 || B == null || B.length == 0) {
      return -1;
    }
    if (k == 0) {
      return -1;
    }

    int n = A.length;
    int m = B.length;
    PriorityQueue<Cell> heap = new PriorityQueue<Cell>(n, cellComparator);
    for (int i = 0; i < n; i++) {
      heap.add(new Cell(A[i] + B[0], i, 0));
    }
    for (int i = k; i > 1; i--) {
      Cell poll = heap.poll();
      if (poll.y < m - 1) {
        heap.add(new Cell(A[poll.x] + B[poll.y + 1], poll.x, poll.y + 1));
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
      return o1.val - o2.val;
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
