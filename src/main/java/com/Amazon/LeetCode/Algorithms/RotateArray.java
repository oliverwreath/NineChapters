package com.Amazon.LeetCode.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class RotateArray {
    private static final Logger logger = LoggerFactory.getLogger(RotateArray.class);

    public static void main(String[] args) {
        testRotateArray();
    }

    private static void testRotateArray() {
        RotateArray RotateArray = new RotateArray();
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.rotate(array, 3);
        MyLogger.info("result [5,6,7,1,2,3,4] v.s. " + Arrays.toString(array));
    }

    /**
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return;
        }

        // main logic
        int len = nums.length;
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[(i + k) % len] = nums[i];
        }
        for (int i = 0; i < len; i++) {
            nums[i] = newArray[i];
        }

        return;
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
