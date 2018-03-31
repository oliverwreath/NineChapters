package com.LintCodeContest.Weekly11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No952_DigitalProblem {
    private final static Logger logger = LoggerFactory.getLogger(No952_DigitalProblem.class);

    public static void main(String[] args) {
        No952_DigitalProblem No952_DigitalProblem = new No952_DigitalProblem();
        No952_DigitalProblem.testNo952_DigitalProblem();
    }

    private void testNo952_DigitalProblem() {
        MyLogger.info("result 1 v.s. " + digitConvert(2));
        MyLogger.info("result 7 v.s. " + digitConvert(3));
    }

    int digitConvert(int n) {
        // filter abnormal cases
        if (n <= 1) {
            return 0;
        }

        int count = 0;
        while (n != 1) {
            if (n % 2 == 1) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            count++;
        }

        // return the final result
        return count;
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
