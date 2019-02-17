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
public class MinimumNumberOfKConsecutiveBitFlips_995 {
    private final static Logger logger = LoggerFactory.getLogger(MinimumNumberOfKConsecutiveBitFlips_995.class);

    public static void main(String[] args) {
        MinimumNumberOfKConsecutiveBitFlips_995 thisClass = new MinimumNumberOfKConsecutiveBitFlips_995();
        thisClass.testMinimumNumberOfKConsecutiveBitFlips_995();
    }

    private void testMinimumNumberOfKConsecutiveBitFlips_995() {
        logger.info("result {} v.s. {}", "2", minKBitFlips(new int[]{0, 1, 0}, 1));
        logger.info("result {} v.s. {}", "-1", minKBitFlips(new int[]{1, 1, 0}, 2));
        logger.info("result {} v.s. {}", "3", minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
        logger.info("result {} v.s. {}", "-1", minKBitFlips(new int[]{1, 0, 1}, 3));
    }

    public int minKBitFlips(int[] A, int K) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // dp logic
        if (K == 1) {
            int count = 0;
            for (int a : A) {
                if (a == 0) {
                    count++;
                }
            }
            return count;
        }
        int i = 0;
        int n = A.length;
        int steps = 0;
        while (i < n) {
            if (A[i] == 1) {
                i++;
                continue;
            }

            if (i > n - K) {
                return -1;
            }

            for (int t = 0; t < K; t++) {
                A[i + t] = A[i + t] == 0 ? 1 : 0;
            }
            i++;
            steps++;
        }

        // return the final result
        return steps;
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
