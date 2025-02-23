package com.ATemplatesDataStructures.Heap;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TrappingRainWater {

  public static void main(String[] arg) {
    testTrappingRainWater();
  }

  private static void testTrappingRainWater() {
    log.info("{}", trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));// 6
  }

  /**
   * @param heights: an array of integers
   * @return: a integer
   */
  static int trapRainWater(int[] heights) {

    // handle extreme inputs
    if (heights == null || heights.length <= 2) {
      return 0;
    }

    // coompute
    int len = heights.length;
    int left = 0;
    int right = len - 1;
    int lastLeftPeak = left;
    int lastRightPeak = right;
    int leftHeight = heights[lastLeftPeak];
    int rightHeight = heights[lastRightPeak];
    long answer = 0;
    while (left < right) {
      if (leftHeight < rightHeight) {
        left++;
        if (left >= right) {
          break;
        }
        if (heights[left] <= leftHeight) {
          answer += leftHeight - heights[left];
        } else {
          lastLeftPeak = left;
          leftHeight = heights[lastLeftPeak];
        }
      } else {
        right--;
        if (left >= right) {
          break;
        }
        if (heights[right] <= rightHeight) {
          answer += rightHeight - heights[right];
        } else {
          lastRightPeak = right;
          rightHeight = heights[lastRightPeak];
        }
      }
    }

    // return answer
    return (int) answer;
  }
}
