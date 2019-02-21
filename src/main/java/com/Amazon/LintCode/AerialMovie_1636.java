package com.Amazon.LintCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AerialMovie_1636 {
    private static final Logger logger = LoggerFactory.getLogger(AerialMovie_1636.class);

    public static void main(String[] args) {
        AerialMovie_1636 AerialMovie_1636 = new AerialMovie_1636();
//        AerialMovie_1636.testAerialMovie_1636();
    }

    private void testAerialMovie_1636() {
//        MyLogger.info("result 2 v.s. " + functionName("12"));
    }

    int functionName(int[] A) {
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
