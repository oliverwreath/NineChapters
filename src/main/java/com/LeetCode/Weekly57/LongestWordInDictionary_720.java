package com.LeetCode.Weekly57;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LongestWordInDictionary_720 {
    private static final Logger logger = LoggerFactory.getLogger(LongestWordInDictionary_720.class);

    public static void main(String[] args) {
        testLongestWordInDictionary_720();
    }

    private static void testLongestWordInDictionary_720() {
        LongestWordInDictionary_720 LongestWordInDictionary_720 = new LongestWordInDictionary_720();
//        MyLogger.info("result 2 v.s. " + LongestWordInDictionary_720.longestIncreasingContinuousSubsequence("12"));
//        MyLogger.info("result 1 v.s. " + LongestWordInDictionary_720.longestIncreasingContinuousSubsequence("10"));
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
