package com.lintCode.BackPack;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-25.
 */
public class BackPackVI {
    private static final Logger logger = LoggerFactory.getLogger(BackPackVI.class);

    public static void main(String[] arg) {
        testBackPackVI();
    }

    private static void testBackPackVI() {
        logger.info("{}", backPackVI(new int[]{1, 2, 4}, 4));
    }

    /**
     * @param nums   an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    static int backPackVI(int[] nums, int target) {
        // write your code here
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // fill the result matrix
        int n = nums.length;
        int[] ret = new int[target + 1];

        ret[0] = 1;
//        for (int i = 0; i <= n; i++) {
//            ret[i][0] = 1;
//        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - nums[j - 1] >= 0) {
                    ret[i] += ret[i - nums[j - 1]];
                }
            }
        }

//        System.out.println(Arrays.toString(ret));

        // return result
        return ret[target];
    }
}
