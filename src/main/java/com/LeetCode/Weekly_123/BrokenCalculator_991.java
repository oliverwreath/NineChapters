package com.LeetCode.Weekly_123;

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
public class BrokenCalculator_991 {
    private final static Logger logger = LoggerFactory.getLogger(BrokenCalculator_991.class);

    public static void main(String[] args) {
        BrokenCalculator_991 thisClass = new BrokenCalculator_991();
        thisClass.testBrokenCalculator_991();
    }

    private void testBrokenCalculator_991() {
        logger.info("result {} v.s. {}", "2", brokenCalc(2, 3));
        logger.info("result {} v.s. {}", "2", brokenCalc(5, 8));
        logger.info("result {} v.s. {}", "3", brokenCalc(3, 10));
        logger.info("result {} v.s. {}", "1023", brokenCalc(1024, 1));
        logger.info("result {} v.s. {}", "?", brokenCalc(1, 1000000000));
    }

    public int brokenCalc(int X, int Y) {
        // filter abnormal cases

        // dp logic
        int step = 0;
        while (Y > X) {
            if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            step++;
        }
        if (X == Y) {
            return step;
        } else {
            return step + (X - Y);
        }

        // return the final result
    }

//    private int helper(int X, int Y, int step) {
//        MyLogger.info(hashMap);
//        MyLogger.info("X = " + X + "; Y = " + Y);
//        if (visited.contains(getKey(X, Y))) {
//            return ;
//        }
//        long key = getKey(X, Y);
//        if (hashMap.containsKey(key)) {
//            return hashMap.get(key);
//        }
//
//        if (X == Y) {
//            hashMap.put(key, step);
//            return hashMap.get(key);
//        }
//
//        if (X > Y) {
//            hashMap.put(key, X - Y);
//            return hashMap.get(key);
//        } else if (2 * X <= Y) {
//            hashMap.put(key, helper(2 * X, Y, step + 1));
//            return hashMap.get(key);
//        } else {
//            int d = helper(2 * X, Y, step + 1);
//            int m = helper(X - 1, Y, step + 1);
//            hashMap.put(key, Math.min(d, m));
//            return hashMap.get(key);
//        }
//    }

//    private long getKey(int X, int Y) {
//        return X;
//        return X * 10000000000L + Y;
//    }

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
