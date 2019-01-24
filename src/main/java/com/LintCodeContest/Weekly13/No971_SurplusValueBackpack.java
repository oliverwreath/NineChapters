package com.LintCodeContest.Weekly13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No971_SurplusValueBackpack {
    private final static Logger logger = LoggerFactory.getLogger(No971_SurplusValueBackpack.class);

    public static void main(String[] args) {
        No971_SurplusValueBackpack No971_SurplusValueBackpack = new No971_SurplusValueBackpack();
        No971_SurplusValueBackpack.testNo971_SurplusValueBackpack();
    }

    private void testNo971_SurplusValueBackpack() {
//        MyLogger.info("result 23 v.s. " + getMaxValue(3, 2, 7, 2, 3, new int[]{4, 3}, new int[]{1, 3, 2}));
//        MyLogger.info("result 10 v.s. " + getMaxValue(1, 2, 5, 1, 1, new int[]{2}, new int[]{1}));
    }

//    long getMaxValue(int k1, int k2, int c, int n, int m, int[] a, int[] b) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // return the final result
//        return -1;
//    }

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
