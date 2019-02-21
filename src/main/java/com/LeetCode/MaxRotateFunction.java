package com.LeetCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/10/2016.
 */
public class MaxRotateFunction {
    private static final Logger logger = LoggerFactory.getLogger(MaxRotateFunction.class);

    public static void main(String[] arg) {
        testMaxRotateFunction();
    }

    private static void testMaxRotateFunction() {
        logger.info("{}", maxRotateFunction(new int[]{4, 3, 2, 6}));//26
        logger.info("{}", maxRotateFunction(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));//330
    }

    public static int maxRotateFunction(int[] A) {
        // filter abnormal inputs
        if (A == null || A.length < 2) {
            return 0;
        }

        // rotate, get sum and get maxSum
        int len = A.length;
        int tmpSum = 0;
        for (int i : A) {
            tmpSum += i;
        }
//        System.out.println("tmpSum=" + tmpSum);

        // first sum
        long lastSum = 0;
        for (int i = 0; i < len; i++) {
            lastSum += i * A[i];
        }
//        System.out.println("lastSum = " + lastSum);

        // rotated sums
        long maxSum = Integer.MIN_VALUE;
        maxSum = lastSum;
        for (int i = 1; i < len; i++) {
            lastSum += tmpSum;
            lastSum -= len * A[len - i];
//            System.out.println("lastSum = " + lastSum);
            maxSum = Math.max(maxSum, lastSum);
        }
        return (int) maxSum;
    }
}
