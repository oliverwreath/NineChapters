package com.LeetCode.Weekly38;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by yanli on 2017-06-24.
 */
public class MaximumProductOfThreeNumbers_628 {
    public static void main(String[] args) {
        MaximumProductOfThreeNumbers_628 maximumProductOfThreeNumbers_628 = new MaximumProductOfThreeNumbers_628();
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{-1, 2, -3}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, 2, 3}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, 2, 3, 4}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, 2, 3, -4}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, 2, -3, 4}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, -2, 3, 4}));
        MyLogger.debug("result = " + maximumProductOfThreeNumbers_628.maximumProduct(new int[]{1, -2, 3, -4}));
    }

    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 1;
        }

        LinkedList<Integer> positive = new LinkedList<>();
        LinkedList<Integer> negative = new LinkedList<>();
        int len = nums.length;
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] >= 0) {
                positive.add(nums[i]);
            } else {
                negative.add(nums[i]);
            }
        }

        Collections.sort(positive, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        Collections.sort(negative);

        MyLogger.debug(positive);
        MyLogger.debug(negative);

        if (negative.size() < 1) {
            return positive.get(0) * positive.get(1) * positive.get(2);
        } else if (positive.size() < 1) {
            return negative.get(0) * negative.get(1) * negative.get(2);
        } else {
            int result = Integer.MIN_VALUE;
            if (positive.size() > 2) {
                int tmp = positive.get(0) * positive.get(1) * positive.get(2);
                result = Math.max(result, tmp);
            }
            if (positive.size() > 0 && negative.size() > 1) {
                int tmp = positive.get(0) * negative.get(0) * negative.get(1);
                result = Math.max(result, tmp);
            }
            return result;
        }
    }


    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
