package com.lintCode.BackPack;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-25.
 */
public class BackPackIV {
    private static final Logger logger = LoggerFactory.getLogger(BackPackIV.class);

    public static void main(String[] arg) {
        testBackPackIV();
    }

    private static void testBackPackIV() {
        logger.info("{}", backPackIV(new int[]{2, 3, 6, 7}, 7));
    }

    /**
     * @param nums   an integer array and all positive numbers, no duplicates
     * @param target an integer
     * @return an integer
     */
    static int backPackIV(int[] nums, int target) {
        // write your code here
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // fill the result matrix
        int n = nums.length;
        int[][] ret = new int[n + 1][target + 1];

//        ret[0][0] = 1;
        for (int i = 0; i <= n; i++) {
            ret[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] >= 0) {
                    ret[i][j] = ret[i - 1][j] + ret[i][j - nums[i - 1]];
                } else {
                    ret[i][j] = ret[i - 1][j];
                }
            }
        }

//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(ret[i]));
//        }

        // return result
        return ret[n][target];
    }
}
