package com.LeetCode.Weekly53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StickersToSpellWord_691 {
    private static final Logger logger = LoggerFactory.getLogger(StickersToSpellWord_691.class);

    public static void main(String[] args) {
        testStickersToSpellWord_691();
    }

    private static void testStickersToSpellWord_691() {
        StickersToSpellWord_691 StickersToSpellWord_691 = new StickersToSpellWord_691();
        MyLogger.info("result 2 v.s. " + StickersToSpellWord_691.longestIncreasingContinuousSubsequence(new int[]{}));
        MyLogger.info("result 1 v.s. " + StickersToSpellWord_691.longestIncreasingContinuousSubsequence(new int[]{}));
    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
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
