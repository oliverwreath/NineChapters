package com.Amazon.LeetCode.Algorithms;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    private final static Logger logger = LoggerFactory.getLogger(Subsets.class);

    public static void main(String[] args) {
        testSubsets();
    }

    private static void testSubsets() {
        Subsets Subsets = new Subsets();
        MyLogger.info("result 2 v.s. " + Subsets.subsets(new int[]{1, 2, 3}));
    }

    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new LinkedList<>();
        }

        // main logic
        int len = nums.length;
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        result.add(Arrays.asList(ArrayUtils.toObject(nums)));
        for (int num : nums) {
            LinkedList<Integer> tmp = new LinkedList<>();
            tmp.add(num);
            result.add(tmp);
        }
        for (int count = 2; count < len; count++) {
            int currentCount = 0;
            while (currentCount < count) {

            }
        }

        return result;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
