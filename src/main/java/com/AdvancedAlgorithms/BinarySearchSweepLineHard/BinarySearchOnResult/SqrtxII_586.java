package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearchOnResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * beautifully done! binary search with caution that if x < 1, we need to search up to 1.
 */
public class SqrtxII_586 {
    private final static Logger logger = LoggerFactory.getLogger(SqrtxII_586.class);

    public static void main(String[] args) {
        SqrtxII_586 thisClass = new SqrtxII_586();
        thisClass.testSqrtx_141();
    }

    private void testSqrtx_141() {
        logger.info("result {} v.s. {}", "o", sqrt(0));
        logger.info("result {} v.s. {}", "1.41421356", sqrt(2));
        logger.info("result {} v.s. {}", "0.31622777", sqrt(0.1));
    }

    private static final double epsilon = 1e-12;

    public double sqrt(double x) {
        // filter abnormal cases
        if (x == 0) {
            return 0;
        }

        double left = 0, right = x > 1 ? x : 1;
        while (left + epsilon < right) {
            double mid = left + (right - left) / 2;
            if (mid * mid < x) {
                left = mid;
            } else if (mid * mid > x) {
                right = mid;
            } else {
                return mid;
            }
        }
        // return the final result
        if (Math.abs(right * right - x) < epsilon) {
            return right;
        } else {
            return left;
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
