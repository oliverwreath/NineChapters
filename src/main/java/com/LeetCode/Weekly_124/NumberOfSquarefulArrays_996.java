package com.LeetCode.Weekly_124;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
public class NumberOfSquarefulArrays_996 {
    private static final Logger logger = LoggerFactory.getLogger(NumberOfSquarefulArrays_996.class);

    public static void main(String[] args) {
        NumberOfSquarefulArrays_996 thisClass = new NumberOfSquarefulArrays_996();
        thisClass.testNumberOfSquarefulArrays_996();
    }

    private void testNumberOfSquarefulArrays_996() {
        logger.info("result {} v.s. {}", "2", numSquarefulPerms(new int[]{1, 17, 8}));
        logger.info("result {} v.s. {}", "1", numSquarefulPerms(new int[]{2, 2, 2}));
    }

    public int numSquarefulPerms(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // dp logic
        int count = 0;
        if (isSquareful(getNextPerm(A))) {
            count++;
        }

        // return the final result
        return count;
    }

    private boolean isSquareful(int[] A) {
        for (int i = 1; i < A.length; i++) {
            if (!isSumPerfectSquare(A[i - 1], A[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean isSumPerfectSquare(int i, int i2) {
        int root = (int) Math.sqrt(i + i2);
        return root * root == i + i2;
    }

    private int[] getNextPerm(int[] A) {
        return A;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
