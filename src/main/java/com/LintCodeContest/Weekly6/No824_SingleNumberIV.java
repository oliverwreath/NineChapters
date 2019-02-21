package com.LintCodeContest.Weekly6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No824_SingleNumberIV {
    private static final Logger logger = LoggerFactory.getLogger(No824_SingleNumberIV.class);

    public static void main(String[] args) {
        No824_SingleNumberIV No824_SingleNumberIV = new No824_SingleNumberIV();
        No824_SingleNumberIV.testNo824_SingleNumberIV();
    }

    private void testNo824_SingleNumberIV() {
        MyLogger.info("result 4 v.s. " + getSingleNumber(new int[]{3, 3, 2, 2, 4, 5, 5}));
        MyLogger.info("result 2 v.s. " + getSingleNumber(new int[]{2, 1, 1, 3, 3}));
        MyLogger.info("result 2 v.s. " + getSingleNumber(new int[]{1, 1, 3, 3, 2}));
        MyLogger.info("result 3 v.s. " + getSingleNumber(new int[]{3}));
    }

    int getSingleNumber(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        for (int i = 0; i < A.length; i += 2) {
            if (i + 1 >= A.length) {
                return A[A.length - 1];
            }
            if (A[i] != A[i + 1]) {
                return A[i];
            }
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
