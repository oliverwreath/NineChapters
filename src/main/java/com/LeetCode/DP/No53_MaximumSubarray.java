package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class No53_MaximumSubarray {
    private final static Logger logger = LoggerFactory.getLogger(No53_MaximumSubarray.class);

    public static void main(String[] arg) {
        new No53_MaximumSubarray().testMaximumSubarray_53();
    }

    private void testMaximumSubarray_53() {
        logger.info("6 = {}", maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        logger.info("1 = {}", maxSubArray(new int[]{1}));
        logger.info("3 = {}", maxSubArray(new int[]{-2, 3}));
    }

    public int maxSubArray(int[] nums) {
        // handle extreme cases
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // dp
        int n = nums.length;
        int[] local = new int[n];
        int[] global = new int[n];
        local[0] = nums[0];
        global[0] = nums[0];
        for (int i = 1; i < n; i++) {
            local[i] = Math.max(nums[i], local[i - 1] + nums[i]);
            global[i] = Math.max(global[i - 1], local[i]);
        }

        return global[n - 1];
    }
}
