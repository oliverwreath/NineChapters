package com.LeetCode.Weekly74;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No795_NumberOfSubarraysWithBoundedMaximum {
    private static final Logger logger = LoggerFactory.getLogger(No795_NumberOfSubarraysWithBoundedMaximum.class);

    public static void main(String[] args) {
        No795_NumberOfSubarraysWithBoundedMaximum No795_NumberOfSubarraysWithBoundedMaximum = new No795_NumberOfSubarraysWithBoundedMaximum();
        No795_NumberOfSubarraysWithBoundedMaximum.testNo795_NumberOfSubarraysWithBoundedMaximum();
    }

    private void testNo795_NumberOfSubarraysWithBoundedMaximum() {
        MyLogger.info("result 3 v.s. " + numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
    }

    int numSubarrayBoundedMax(int[] A, int L, int R) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
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
