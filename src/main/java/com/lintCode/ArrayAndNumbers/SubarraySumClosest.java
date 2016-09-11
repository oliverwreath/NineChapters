package com.lintCode.ArrayAndNumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/11/2016.
 */
public class SubarraySumClosest {
    private final static Logger logger = LoggerFactory.getLogger(SubarraySumClosest.class);

    public static void main(String[] arg) {
        testSubarraySumClosest();
    }

    private static void testSubarraySumClosest() {
        logger.info("{}", subarraySumClosest(new int[]{-3, 1, 1, -3, 5}));
    }

    static int[] subarraySumClosest(int[] nums) {
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // get sum
        int len = nums.length;
        int[] sumArray = new int[len + 1];
        {
            int tmpSum = 0;
            for (int i = len - 1; i >= 0; i--) {
                tmpSum += nums[i];
                sumArray[i] = tmpSum;
            }
        }

        // two fors
        int closestSum = Integer.MAX_VALUE;
        int[] closestRet = new int[]{0, 0};
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmpSum = sumArray[i] - sumArray[j + 1];
                if (ACloserThenB(tmpSum, closestSum)) {
                    closestRet[0] = i;
                    closestRet[1] = j;
                    closestSum = tmpSum;
                }
            }
        }

        // retrun result
        return closestRet;
    }

    static boolean ACloserThenB(int a, int b) {
        return Math.abs(a) < Math.abs(b);
    }
}
