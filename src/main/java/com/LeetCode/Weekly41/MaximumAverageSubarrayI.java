package com.LeetCode.Weekly41;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2017-07-15.
 */
public class MaximumAverageSubarrayI {
    private static final Logger logger = LoggerFactory.getLogger(MaximumAverageSubarrayI.class);

    public static void main(String[] args) {
        testMaximumAverageSubarrayI();
    }

    private static void testMaximumAverageSubarrayI() {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        MyLogger.info("result 12.75 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        MyLogger.info("result 10.8 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 5));
        MyLogger.info("result 9.16667 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 6));
        MyLogger.info("result 50 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 1));
        MyLogger.info("result 26.5 = " + maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 2));
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
        MyLogger.debug("n = " + n);

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
        MyLogger.debug("n = " + n);

        if (k >= n) {
            return sums[n - 1] * 1.0 / k;
        }

        // dp
        int begin = 0;
        int end = k - 1;
        int maxSum = Integer.MIN_VALUE;
        for (; end < n; begin++, end++) {
            MyLogger.debug(begin + " ~ " + end);
            int sum = sums[end];
            if (begin != 0) {
                sum -= sums[begin - 1];
            }
            MyLogger.debug("sum = " + sum);
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
//        MyLogger.debug("n = " + n);
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
//            MyLogger.debug(begin + " ~ " + end);
//            sum += nums[i];
//        }
//        MyLogger.debug("sum = " + sum);
//        maxSum = Math.max(maxSum, sum);
//        for (; end++ < n - 1; begin++) {
//            MyLogger.debug(begin + " ~ " + end);
//            sum += nums[end];
//            sum -= nums[begin];
//            MyLogger.debug("sum = " + sum);
//            maxSum = Math.max(maxSum, sum);
//        }
//
//        return maxSum * 1.0 / k;
//    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
