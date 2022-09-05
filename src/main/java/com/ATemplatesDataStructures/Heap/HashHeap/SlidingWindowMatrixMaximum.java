package com.ATemplatesDataStructures.Heap.HashHeap;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class SlidingWindowMatrixMaximum {
  public static void main(String[] arg) {
    new SlidingWindowMatrixMaximum().testSlidingWindowMaximum();
  }

  private void testSlidingWindowMaximum() {
    log.info("{}", maxSlidingWindow2(new int[][]{
            {1, 5, 3},
            {3, 2, 1},
            {4, 1, 9},
    }, 2));// 13
    log.info("{}", maxSlidingWindow2(new int[][]{
            {1, 2, 3, 4, 6, 5},
            {7, 8, 9, 10, 12, 11},
            {13, 14, 15, 16, 18, 17},
            {19, 20, 21, 22, 24, 23},
            {25, 26, 27, 28, 30, 29},
            {31, 32, 33, 34, 36, 35},
            {43, 44, 45, 46, 48, 47},
            {37, 38, 39, 40, 42, 41},
    }, 5));// 850
  }

  /**
   * @param matrix an integer array of n * m matrix
   * @param k      an integer
   * @return the maximum number
   */
  public int maxSlidingWindow2(int[][] matrix, int k) {

    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return 0;
    }
    int n = matrix.length;
    int m = matrix[0].length;
    if (k > n || k > m) {
//            int sum = 0;
//            for (int i = 0; i < n && i < k; i++) {
//                for (int j = 0; j < m && j < k; j++) {
//                    sum += matrix[i][j];
//                }
//            }
      return 0;
    }

    // use max heap
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n - k + 1) * (m - k + 1), integerComparator);
    boolean toRight = true;
    boolean firstTime = true;
    int sum = 0;
    for (int i = 0; i < k; i++) {
      for (int j = 0; j < k; j++) {
        sum += matrix[i][j];
      }
    }
    heap.add(sum);
//        log.debug("first sum = " + sum);
    for (int up = 0, down = k - 1; down < n; up++, down++) {
      if (toRight) {
        if (!firstTime) {
          // go down
          for (int j = 0; j <= k - 1; j++) {
            sum -= matrix[up - 1][j];
            sum += matrix[down][j];
          }
          heap.add(sum);
//                    log.debug("go down sum = " + sum);
        }
        firstTime = false;

        // go right
        for (int left = 1, right = k; right < m; left++, right++) {
          for (int i = up; i <= down; i++) {
            sum -= matrix[i][left - 1];
            sum += matrix[i][right];
          }
          heap.add(sum);
//                    log.debug("go right sum = " + sum);
        }
      } else {
        // go down
        for (int j = m - k; j < m; j++) {
          sum -= matrix[up - 1][j];
          sum += matrix[down][j];
        }
        heap.add(sum);
//                log.debug("go down sum = " + sum);

        // go left
        for (int left = m - k - 1, right = m - 2; left >= 0; left--, right--) {
          for (int i = up; i <= down; i++) {
            sum -= matrix[i][right + 1];
            sum += matrix[i][left];
          }
          heap.add(sum);
//                    log.debug("go left sum = " + sum);
        }
      }

      toRight = !toRight;
    }

    // return the answer
    return heap.peek();
  }

  private static Comparator<Integer> integerComparator = new Comparator<Integer>() {
    public int compare(Integer o1, Integer o2) {
      return o2 - o1;
    }
  };
}
