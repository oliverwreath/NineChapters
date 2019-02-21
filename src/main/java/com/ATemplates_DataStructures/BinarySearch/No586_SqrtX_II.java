package com.ATemplates_DataStructures.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No586_SqrtX_II {
    private static final Logger logger = LoggerFactory.getLogger(No586_SqrtX_II.class);

    public static void main(String[] args) {
        testNo141_SqrtX();
    }

    private static void testNo141_SqrtX() {
        No586_SqrtX_II No141_SqrtX = new No586_SqrtX_II();
//        MyLogger.info("result 0 v.s. " + No141_SqrtX.sqrt(0));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
        MyLogger.info("result 1.41421356 v.s. " + No141_SqrtX.sqrt(2));
//        MyLogger.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        MyLogger.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        MyLogger.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
    }

    public double sqrt(double x) {
        // filter abnormal cases
        if (x < 0) {
            return 0;
        }

        double start = 0;
        double end = (x < 1) ? 1 : x;
        double eps = 1e-12;
        while (start + eps < end) {
            double mid = (end - start) / 2 + start;
            if (mid * mid > x) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return start;
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
