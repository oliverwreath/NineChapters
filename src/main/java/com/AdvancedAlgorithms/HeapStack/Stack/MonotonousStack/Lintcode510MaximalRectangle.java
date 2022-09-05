package com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * this depends on the maxAreaInHist
 */
@Slf4j
public class Lintcode510MaximalRectangle {
  public int maximalRectangle(boolean[][] matrix) {
    // filter abnormal cases
    if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
      return 0;
    }

    // intermediate intMatrix
    int m = matrix.length, n = matrix[0].length;
    int[][] intMatrix = new int[m][n];
    for (int y = 0; y < n; y++) {
      intMatrix[0][y] = matrix[0][y] ? 1 : 0;
    }

    for (int x = 1; x < m; x++) {
      for (int y = 0; y < n; y++) {
        if (!matrix[x][y]) {
          intMatrix[x][y] = 0;
        } else {
          intMatrix[x][y] = 1 + intMatrix[x - 1][y];
        }
      }
    }

    // for every row, do the histogram trick of Monotonous Stack
    int max = 0;
    for (int x = 0; x < m; x++) {
      max = Math.max(max, largestRectangleArea(intMatrix[x]));
    }

    // return the final result
    return max;
  }

  public int largestRectangleArea(int[] height) {
    // filter abnormal cases
    if (height == null || height.length == 0) {
      return 0;
    }

    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i <= height.length; i++) {
      int currentHeight = i == height.length ? 0 : height[i];
      while (!stack.isEmpty() && currentHeight <= height[stack.peek()]) {
        int h = height[stack.pop()];
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        max = Math.max(max, h * w);
      }
      stack.push(i);
    }

    // return the final max
    return max;
  }

}
