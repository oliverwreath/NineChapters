package com.lintCode.ArrayAndNumbers;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/8/2016.
 */
public class TwoSum2 {
    private final static Logger logger = LoggerFactory.getLogger(TwoSum2.class);

    public static void main(String[] arg) {
        testTwoSum2();
    }

    private static void testTwoSum2() {
        logger.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 24));
        logger.info("{}", twoSum2(new int[]{2, 7, 11, 15}, 1));
        logger.info("{}", twoSum2(new int[]{1, 0, -1}, -1));
        logger.info("{}", twoSum2(new int[]{1, 0, -1}, 0));
        logger.info("{}", twoSum2(new int[]{1, 0, -1}, 1));
    }

    static int twoSum2(int[] nums, int target) {
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // sort
        Arrays.sort(nums);

        // search
        int len = nums.length;
        int i = 0, j = len - 1;
        int counter = 0;
        while (i < j) {
            if (nums[i] + nums[j] > target) {
//                logger.info("j = {}; i = {}; j - i = {}", j, i, j - i);
                counter += (j - i);
                j--;
            } else {
                i++;
            }
        }

        // return result
        return counter;
    }
}
