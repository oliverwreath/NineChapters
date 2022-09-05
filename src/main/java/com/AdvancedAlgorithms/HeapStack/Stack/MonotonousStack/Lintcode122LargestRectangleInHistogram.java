package com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * nicely done, could be more concise, consider it done.
 */
@Slf4j
public class Lintcode122LargestRectangleInHistogram {
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
