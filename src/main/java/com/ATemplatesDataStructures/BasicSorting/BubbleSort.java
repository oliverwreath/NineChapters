package com.ATemplatesDataStructures.BasicSorting;

import java.security.SecureRandom;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BubbleSort {

  private static final SecureRandom random = new SecureRandom();

  public static void main(String[] args) {
    testBubbleSort();
  }

  private static final int RANGE = 999;

  private static void testBubbleSort() {
    BubbleSort bubbleSort = new BubbleSort();
    bubbleSort.bubbleSort(new int[]{3, 2, 1});
    bubbleSort.bubbleSort(new int[]{5, 4, 3, 2, 1});
    int[] list = new int[30];
    for (int i = 0; i < list.length; i++) {
      int n = (random.nextInt() * RANGE - RANGE / 2);
      list[i] = n;
    }
    bubbleSort.bubbleSort(list);
  }

  /**
   * @param nums an array of Integer
   * @return an integer
   */
  public void bubbleSort(int[] nums) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return;
    }

    int n = nums.length;
    for (int t = 0; t < n - 1; t++) {
      int swapCounter = 0;
      for (int i = 0; i < n - 1; i++) {
        if (nums[i] > nums[i + 1]) {
          int tmp = nums[i];
          nums[i] = nums[i + 1];
          nums[i + 1] = tmp;
          swapCounter++;
        }
      }
      if (swapCounter == 0) {
        break;
      }
    }

    log.info("Result = " + Arrays.toString(nums));
    Arrays.sort(nums);
    log.info("Answer = " + Arrays.toString(nums));
  }
}
