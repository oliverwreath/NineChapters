package com.ATemplatesDataStructures.Algorithms;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ladder406_MinimumSizeSubarraySum {
  public static void main(String[] args) {
    testLadder406_MinimumSizeSubarraySum();
  }

  private static void testLadder406_MinimumSizeSubarraySum() {
    Ladder406_MinimumSizeSubarraySum Ladder406_MinimumSizeSubarraySum = new Ladder406_MinimumSizeSubarraySum();
    log.info("result 2 v.s. " + Ladder406_MinimumSizeSubarraySum.minimumSize(new int[]{2, 3, 1, 2, 4, 3}, 7));
    log.info("result -1 v.s. " + Ladder406_MinimumSizeSubarraySum.minimumSize(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2113, 1, 1}, 12345));
  }

  /**
   * @param nums
   * @param s
   * @return
   */
  public int minimumSize(int[] nums, int s) {
    if (nums == null || nums.length < 1) {
      return -1;
    }


    int left = 0, right = 0;
    int len = nums.length;
    int sum = nums[0];
    int min = Integer.MAX_VALUE;
    while (right < len) {
      if (sum >= s) {
        min = Math.min(min, right - left + 1);
      }
      log.debug("sum = " + sum);

      if (sum >= s && left < right) {
        sum -= nums[left++];
      } else {
        if (right == len - 1) {
          break;
        }
        sum += nums[++right];
      }
    }

    return min == Integer.MAX_VALUE ? -1 : min;
  }

}
