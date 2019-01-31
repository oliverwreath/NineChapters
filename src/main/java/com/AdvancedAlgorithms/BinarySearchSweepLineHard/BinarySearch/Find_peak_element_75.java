package com.AdvancedAlgorithms.BinarySearchSweepLineHard.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Find_peak_element_75 {
    private final static Logger logger = LoggerFactory.getLogger(Find_peak_element_75.class);

    public static void main(String[] args) {
        Find_peak_element_75 thisClass = new Find_peak_element_75();
        thisClass.testFind_peak_element_75();
    }

    private void testFind_peak_element_75() {
        logger.info("result {} v.s. {}", "1/6", findPeak(new int[]{1, 2, 1, 3, 4, 5, 7, 6}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    public int findPeak(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return -1;
        }

        int left = 1, right = A.length - 2;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (A[mid] > A[mid - 1]) {
                left = mid;
            } else if (A[mid] > A[mid + 1]) {
                right = mid;
            } else {
                right = mid;
            }
        }
        if (A[left] > A[left - 1] && A[left] > A[left + 1]) {
            return left;
        }
        if (A[right] > A[right - 1] && A[right] > A[right + 1]) {
            return right;
        }

        // return the final result
        return -1;
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
