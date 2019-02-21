package com.lintCode.Advanced.DPI;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-28.
 */
public class MaximumProductSubarray {
    private static final Logger logger = LoggerFactory.getLogger(MaximumProductSubarray.class);

    public static void main(String[] arg) {
        testMaximumProductSubarray();
    }

    private static void testMaximumProductSubarray() {
        logger.info("{}", maxProduct(new int[]{2, 3, -2, 4}));
    }

    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    static int maxProduct(int[] nums) {
        // write your code here
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // fill subproblem results
        int n = nums.length;
        long[] localMin = new long[n];
        long[] localMax = new long[n];
        long[] global = new long[n];
        localMin[0] = localMax[0] = global[0] = nums[0];
        for (int i = 1; i < n; i++) {
            localMin[i] = Math.min(nums[i], Math.min(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i]));
            localMax[i] = Math.max(nums[i], Math.max(localMin[i - 1] * nums[i], localMax[i - 1] * nums[i]));
            global[i] = Math.max(global[i - 1], Math.max(localMin[i], localMax[i]));
        }

        // print to check before committing
//        System.out.println(Arrays.toString(localMin));
//        System.out.println(Arrays.toString(localMax));
//        System.out.println(Arrays.toString(global));

        // return the final result
        return (int) global[n - 1];
    }
}
