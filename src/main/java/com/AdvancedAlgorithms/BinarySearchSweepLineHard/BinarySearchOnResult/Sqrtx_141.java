package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Sqrtx_141 {
    private final static Logger logger = LoggerFactory.getLogger(Sqrtx_141.class);

    public static void main(String[] args) {
        Sqrtx_141 thisClass = new Sqrtx_141();
        thisClass.testSqrtx_141();
    }

    private void testSqrtx_141() {
        logger.info("result {} v.s. {}", "o", sqrt(0));
        logger.info("result {} v.s. {}", "1", sqrt(3));
        logger.info("result {} v.s. {}", "2", sqrt(4));
    }

//    private static final int

    public int sqrt(int x) {
        // filter abnormal cases
        if (x == 0) {
            return 0;
        }

        long left = 0, right = x;
        while (left + 1 < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                return (int) mid;
            }
        }
        // return the final result
        if (right * right == x) {
            return (int) right;
        } else {
            return (int) left;
        }
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
    }
}
