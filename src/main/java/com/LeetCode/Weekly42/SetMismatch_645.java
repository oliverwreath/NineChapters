package com.LeetCode.Weekly42;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class SetMismatch_645 {
    private static final Logger logger = LoggerFactory.getLogger(SetMismatch_645.class);

    public static void main(String[] args) {
        testSetMismatch_645();
    }

    private static void testSetMismatch_645() {
        SetMismatch_645 SetMismatch_645 = new SetMismatch_645();
        MyLogger.info("result [2,3] = " + Arrays.toString(SetMismatch_645.findErrorNums(new int[]{1, 2, 2, 4})));
//        MyLogger.info("result 1 = " + SetMismatch_645.findErrorNums("10"));
    }

    /**
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        if (nums == null || nums.length < 1) {
            return new int[2];
        }

        int len = nums.length;
        int[] counter = new int[len + 1];
        for (int num : nums) {
            counter[num]++;
        }

        int duplica = Integer.MIN_VALUE;
        int missing = Integer.MIN_VALUE;
        for (int i = 1; i <= len; i++) {
            if (counter[i] == 2) {
                duplica = i;
            } else if (counter[i] == 0) {
                missing = i;
            }
        }

        return new int[]{duplica, missing};
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
