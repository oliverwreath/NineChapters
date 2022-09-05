package com.ATemplatesDataStructures.Stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class No122_LargestRectangleInHistogram {
  public static void main(String[] args) {
    testNo122_LargestRectangleInHistogram();
  }

  private static void testNo122_LargestRectangleInHistogram() {
    No122_LargestRectangleInHistogram No122_LargestRectangleInHistogram = new No122_LargestRectangleInHistogram();
    log.info("result 10 v.s. " + No122_LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        log.info("result 1 v.s. " + No122_LargestRectangleInHistogram.largestRectangleArea("10"));
  }

  public int largestRectangleArea(int[] height) {

    // filter abnormal cases
    if (height == null || height.length == 0) {
      return 0;
    }

    int max = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i <= height.length; i++) {
      int current = (i == height.length) ? -1 : height[i];
      while (!stack.isEmpty() && current <= height[stack.peek()]) {
        int h = height[stack.pop()];
        int w = stack.isEmpty() ? i : i - stack.peek() - 1;
        log.debug(h + " * " + w);
        max = Math.max(max, h * w);
      }
      stack.push(i);
    }

    return max;
  }

}
