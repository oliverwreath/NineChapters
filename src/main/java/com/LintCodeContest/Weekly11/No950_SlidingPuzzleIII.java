package com.LintCodeContest.Weekly11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No950_SlidingPuzzleIII {
    private static final Logger logger = LoggerFactory.getLogger(No950_SlidingPuzzleIII.class);

    public static void main(String[] args) {
        No950_SlidingPuzzleIII No950_SlidingPuzzleIII = new No950_SlidingPuzzleIII();
        No950_SlidingPuzzleIII.testNo950_SlidingPuzzleIII();
    }

    private void testNo950_SlidingPuzzleIII() {
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
