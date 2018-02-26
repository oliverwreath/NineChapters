package com.ATemplates_DataStructures.Array;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No479_SecondMaxOfArray {
    private final static Logger logger = LoggerFactory.getLogger(No479_SecondMaxOfArray.class);

    public static void main(String[] args) {
        No479_SecondMaxOfArray No479_SecondMaxOfArray = new No479_SecondMaxOfArray();
        No479_SecondMaxOfArray.testNo479_SecondMaxOfArray();
    }

    private void testNo479_SecondMaxOfArray() {
//        MyLogger.info("result 2 v.s. " + secondMax(null));
//        MyLogger.info("result 2 v.s. " + secondMax(new int[]{3}));
        MyLogger.info("result 5 v.s. " + secondMax(new int[]{3, 5, 7}));
    }

    int secondMax(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int a : A) {
            if (max < a) {
                secondMax = max;
                max = a;
            } else if (secondMax < a) {
                secondMax = a;
            }
        }

        // return the final result
        return secondMax;
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
