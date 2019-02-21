package com.lintCode.Advanced.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-28.
 */
public class MaximumSubarray {
    private static final Logger logger = LoggerFactory.getLogger(MaximumSubarray.class);

    public static void main(String[] arg) {
        testMaximumSubarray();
    }

    private static void testMaximumSubarray() {
        logger.info("{}", maxSubArray(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3}));
    }

    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    static int maxSubArray(int[] nums) {
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
        int[] local = new int[n];
        int[] global = new int[n];
        local[0] = global[0] = nums[0];
        for (int i = 1; i < n; i++) {
            local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
            global[i] = Math.max(global[i - 1], local[i]);
        }

        // print to check before committing
//        System.out.println(Arrays.toString(local));
//        System.out.println(Arrays.toString(global));

        // return the final result
        return global[n - 1];
    }
}
