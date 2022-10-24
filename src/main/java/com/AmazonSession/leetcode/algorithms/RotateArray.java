package com.AmazonSession.leetcode.algorithms;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RotateArray {

  public static void main(String[] args) {
    testRotateArray();
  }

  private static void testRotateArray() {
    RotateArray RotateArray = new RotateArray();
    int[] array = {1, 2, 3, 4, 5, 6, 7};
    RotateArray.rotate(array, 3);
    log.info("result [5,6,7,1,2,3,4] v.s. " + Arrays.toString(array));
  }

  /**
   * @param nums
   * @param k
   */
  public void rotate(int[] nums, int k) {
    if (nums == null || nums.length < 1) {
      return;
    }

    // main logic
    int len = nums.length;
    int[] newArray = new int[len];
    for (int i = 0; i < len; i++) {
      newArray[(i + k) % len] = nums[i];
    }
    for (int i = 0; i < len; i++) {
      nums[i] = newArray[i];
    }

    return;
  }

}
