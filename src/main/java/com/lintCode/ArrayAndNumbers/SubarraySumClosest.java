package com.lintCode.ArrayAndNumbers;

import java.util.Arrays;
import java.util.Comparator;

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
        SubarraySumClosest subarraySumClosest = new SubarraySumClosest();
        logger.info("{}", subarraySumClosest.subarraySumClosest(new int[]{-3, 1, 1, -3, 5}));
        logger.info("{}", subarraySumClosest.subarraySumClosest(new int[]{2147483647}));
        logger.info("{}", subarraySumClosest.subarraySumClosest(new int[]{-3, 1, 0, -3, 5}));
    }

    public int[] subarraySumClosest(int[] nums) {
        // filter abnormal inputs
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        // get sum
        int len = nums.length;
        Pair[] sumArray = new Pair[len];
        sumArray[0] = new Pair(nums[0], 0);
        for (int i = 1; i < len; i++) {
            sumArray[i] = new Pair(sumArray[i - 1].sum + nums[i], i);
        }

        // sort
//        System.out.println(Arrays.toString(sumArray));
        Arrays.sort(sumArray, new Comparator<Pair>() {
            public int compare(Pair o1, Pair o2) {
                return o1.sum - o2.sum;
            }
        });
//        System.out.println(Arrays.toString(sumArray));

        // minimum adjacent diff (closest to 0 subarray)
        int minDiff = Integer.MAX_VALUE;
        int[] closestRet = new int[2];
        for (int i = 1; i < len; i++) {
            int diff = sumArray[i].sum - sumArray[i - 1].sum;
            if (diff < minDiff) {
                minDiff = diff;
                closestRet[0] = sumArray[i].index;
                closestRet[1] = sumArray[i - 1].index;
            }
        }
        for (int i = 0; i < len; i++) {
            int diff = Math.abs(sumArray[i].sum);
            if (diff < minDiff) {
                minDiff = diff;
                closestRet[0] = sumArray[i].index;
                closestRet[1] = sumArray[i].index;
            }
        }

        // retrun result
        Arrays.sort(closestRet);
        if (closestRet[0] < closestRet[1]) {
            closestRet[0]++;
        }
        return closestRet;
    }

    private class Pair {
        private int sum;
        private int index;

        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "sum=" + sum +
                    ", index=" + index +
                    '}';
        }
    }
}
