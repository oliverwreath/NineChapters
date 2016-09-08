package com.lintCode.ArrayAndNumbers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/8/2016.
 */
public class TwoSumCloset {
    private final static Logger logger = LoggerFactory.getLogger(TwoSumCloset.class);

    public static void main(String[] arg) {
        testTwoSumCloset();
    }

    private static void testTwoSumCloset() {
//        logger.info("{}", twoSumCloset(new int[]{-3, 1, 2, -3, 4}));
        logger.info("{}", twoSumCloset(new int[]{-1, 2, 1, -4}, 4));
    }

    static int twoSumCloset(int[] nums, int target) {
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // sort
        Arrays.sort(nums);

        // two pointers
        int i = 0;
        int j = nums.length - 1;
        int minDiff = Integer.MAX_VALUE;
        while (i < j) {
            if (nums[i] + nums[j] < target) {
                minDiff = Math.min(minDiff, target - (nums[i] + nums[j]));
                i++;
            } else {
                minDiff = Math.min(minDiff, (nums[i] + nums[j]) - target);
                j--;
            }
        }

        // return result
        return minDiff;
    }
}
