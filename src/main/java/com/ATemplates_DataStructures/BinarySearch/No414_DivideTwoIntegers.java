package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No414_DivideTwoIntegers {
    private static final Logger logger = LoggerFactory.getLogger(No414_DivideTwoIntegers.class);

    public static void main(String[] args) {
        testNo141_SqrtX();
    }

    private static void testNo141_SqrtX() {
        No414_DivideTwoIntegers No141_SqrtX = new No414_DivideTwoIntegers();
        MyLogger.info("result 11 v.s. " + No141_SqrtX.divide(100, 9));
        MyLogger.info("result 20 v.s. " + No141_SqrtX.divide(100, 5));
        MyLogger.info("result 5 v.s. " + No141_SqrtX.divide(100, 20));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(2));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        MyLogger.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
    }

    public int divide(int dividend, int divisor) {
        // filter abnormal cases
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        int cnt = 0;
        while (a >= b) {
            int shift = 0;
            while (a >= b << shift) {
                shift++;
            }
            a -= b << (shift - 1);
            cnt += 1 << (shift - 1);
        }

        return isNegative ? -cnt : cnt;
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
