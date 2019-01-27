package com.NineChapters.IntervalArrayMatrixAndBinaryIndexedTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Merge_two_sorted_arrays_6 {
    private final static Logger logger = LoggerFactory.getLogger(Merge_two_sorted_arrays_6.class);

    public static void main(String[] args) {
        testMerge_two_sorted_arrays_6();
    }

    private static void testMerge_two_sorted_arrays_6() {
        logger.info("result [1,1] v.s. {}", mergeSortedArray(new int[]{1}, new int[]{1}));
        logger.info("result [1,2,2,3,4,4,5,6] v.s. {}", mergeSortedArray(new int[]{1, 2, 3, 4}, new int[]{2, 4, 5, 6}));
    }

    public static int[] mergeSortedArray(int[] A, int[] B) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return B;
        }
        if (B == null || B.length == 0) {
            return A;
        }

        int[] result = new int[A.length + B.length];
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }
        if (i < A.length) {
            while (i < A.length) {
                result[k++] = A[i++];
            }
        } else {
            while (j < B.length) {
                result[k++] = B[j++];
            }
        }

        // return the final result
        return result;
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
