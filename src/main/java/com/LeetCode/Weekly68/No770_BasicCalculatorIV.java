package com.LeetCode.Weekly68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class No770_BasicCalculatorIV {
    private final static Logger logger = LoggerFactory.getLogger(No770_BasicCalculatorIV.class);

    public static void main(String[] args) {
        testNo770_BasicCalculatorIV();
    }

    private static void testNo770_BasicCalculatorIV() {
        No770_BasicCalculatorIV No770_BasicCalculatorIV = new No770_BasicCalculatorIV();
//        MyLogger.info("result 2 v.s. " + No770_BasicCalculatorIV.basicCalculatorIV("12"));
    }

    /**
     * @param expression
     * @param evalvars
     * @param evalints
     * @return
     */
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }

        LinkedList<String> results = new LinkedList<>();
        // return the final result
        return results;
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
