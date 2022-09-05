package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: Oliver
 */
@Slf4j
public class LargestRectangleArea {
  public static void main(String[] arg) {
    testLargestRectangleArea();
  }

  private static void testLargestRectangleArea() {
    log.info("{}", largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    log.info("{}", largestRectangleArea(new int[]{1, 1}));
    log.info("{}", largestRectangleArea(new int[]{5, 4, 1, 2}));
  }

  /**
   * @param height: A list of integer
   * @return: The area of largest rectangle in the histogram
   */
  static int largestRectangleArea(int[] height) {

    if (height == null || height.length == 0) {
      return 0;
    }

    Deque<Integer> stackOfIndex = new ArrayDeque<>();
    int max = 0;
    int len = height.length;
    for (int i = 0; i < len; i++) {
      if (!stackOfIndex.isEmpty()) {
//                log.debug("stackOfIndex=" + stackOfIndex);
        while (!stackOfIndex.isEmpty() && height[stackOfIndex.peek()] >= height[i]) {
          int h = height[stackOfIndex.pop()];
          int w = stackOfIndex.isEmpty() ? i : i - stackOfIndex.peek() - 1;
//                    log.info("h * w = {} * {} = {}", h, w, h * w);
          max = Math.max(max, h * w);
        }
      }
      stackOfIndex.push(i);
    }

    // clear the stack
    while (!stackOfIndex.isEmpty()) {
      int h = height[stackOfIndex.pop()];
      int w = stackOfIndex.isEmpty() ? len : len - stackOfIndex.peek() - 1;
//            log.info("h * w = {} * {} = {}", h, w, h * w);
      max = Math.max(max, h * w);
    }

    return max;
  }
}
