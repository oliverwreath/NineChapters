package com.ATemplatesDataStructures.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No510_MaximalRectangle {

  public static void main(String[] args) {
    testNo510_MaximalRectangle();
  }

  private static void testNo510_MaximalRectangle() {
    No510_MaximalRectangle No510_MaximalRectangle = new No510_MaximalRectangle();
    boolean[][] matrix = new boolean[][]{
        {true, true, false, false, true},
        {false, true, false, false, true},
        {false, false, true, true, true},
        {false, false, true, true, true},
        {false, false, false, false, true},
    };
    log.info("result 6 v.s. " + No510_MaximalRectangle.maximalRectangle(matrix));
  }

  public int maximalRectangle(boolean[][] matrix) {

    // filter abnormal cases
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return 0;
    }

    int maxAnswer = 0;
    int m = matrix.length;
    int n = matrix[0].length;
    int[][] h = new int[m][n];
    for (int i = 0; i < m; i++) {
      if (i == 0) {
        for (int j = 0; j < n; j++) {
          h[i][j] = matrix[i][j] ? 1 : 0;
        }
      } else {
        for (int j = 0; j < n; j++) {
          h[i][j] = matrix[i][j] ? 1 + h[i - 1][j] : 0;
        }
      }
    }

//        for (int i = 0; i < m; i++) {
//            log.debug(Arrays.toString(h[i]));
//        }

    // step 2
    for (int i = 0; i < m; i++) {
      Deque<Integer> stack = new ArrayDeque<>();
      int max = 0;
      for (int j = 0; j <= n; j++) {
        int current = (j == n) ? -1 : h[i][j];
        while (!stack.isEmpty() && current <= h[i][stack.peek()]) {
          int height = h[i][stack.pop()];
          int weight = stack.isEmpty() ? j : j - stack.peek() - 1;
          max = Math.max(max, height * weight);
        }
        stack.push(j);
      }
//            log.debug(max);
      maxAnswer = Math.max(maxAnswer, max);
    }

    // return the final result
    return maxAnswer;
  }

}
