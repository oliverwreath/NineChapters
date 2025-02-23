package com.leetcode.Weekly41;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MaximumAverageSubarrayI {

  public static void main(String[] args) {
    testMaximumAverageSubarrayI();
  }

  private static void testMaximumAverageSubarrayI() {
    MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
    log.info("result 12.75 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
    log.info("result 10.8 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 5));
    log.info("result 9.16667 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 6));
    log.info("result 50 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 1));
    log.info("result 26.5 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 2));
  }

  /**
   * @param nums
   * @param k
   * @return
   */
  public double findMaxAverage(int[] nums, int k) {
    // filter abnormal linputs
    if (nums == null || nums.length < 1 || k < 1) {
      return 0.0;
    }

    // initialization
    int n = nums.length;
    log.debug("n = " + n);

    if (k >= n) {
      int sum = 0;
      for (int num : nums) {
        sum += num;
      }
      return sum * 1.0 / k;
    }

    // prepare for dp
    int sums[] = new int[n];
    sums[0] = nums[0];
    for (int i = 1; i < n; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }

    return findMaxAverageHelper(sums, nums, k);
  }

  /**
   * @param nums
   * @param k
   * @return
   */
  public double findMaxAverageHelper(int[] sums, int[] nums, int k) {
    // filter abnormal linputs
    if (nums == null || nums.length < 1 || k < 1) {
      return 0.0;
    }

    // initialization
    int n = nums.length;
    log.debug("n = " + n);

    if (k >= n) {
      return sums[n - 1] * 1.0 / k;
    }

    // dp
    int begin = 0;
    int end = k - 1;
    int maxSum = Integer.MIN_VALUE;
    for (; end < n; begin++, end++) {
      log.debug(begin + " ~ " + end);
      int sum = sums[end];
      if (begin != 0) {
        sum -= sums[begin - 1];
      }
      log.debug("sum = " + sum);
      maxSum = Math.max(maxSum, sum);
    }

    return maxSum * 1.0 / k;
  }

//    /**
//     * @param nums
//     * @param k
//     * @return
//     */
//    public double findMaxAverage(int[] nums, int k) {
//        // filter abnormal linputs
//        if (nums == null || nums.length < 1 || k < 1) {
//            return 0.0;
//        }
//
//        // initialization
//        int n = nums.length;
//        log.debug("n = " + n);
//
//        if (k >= n) {
//            int sum = 0;
//            for (int num : nums) {
//                sum += num;
//            }
//            return sum * 1.0 / k;
//        }
//
//        int begin = 0;
//        int end = k - 1;
//        int sum = 0;
//        int maxSum = Integer.MIN_VALUE;
//        for (int i = begin; i <= end; i++) {
//            log.debug(begin + " ~ " + end);
//            sum += nums[i];
//        }
//        log.debug("sum = " + sum);
//        maxSum = Math.max(maxSum, sum);
//        for (; end++ < n - 1; begin++) {
//            log.debug(begin + " ~ " + end);
//            sum += nums[end];
//            sum -= nums[begin];
//            log.debug("sum = " + sum);
//            maxSum = Math.max(maxSum, sum);
//        }
//
//        return maxSum * 1.0 / k;
//    }

}
