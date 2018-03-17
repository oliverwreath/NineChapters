package com.LintCodeContest.Weekly9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No898_LeftmostOne {
    private final static Logger logger = LoggerFactory.getLogger(No898_LeftmostOne.class);

    public static void main(String[] args) {
        No898_LeftmostOne No898_LeftmostOne = new No898_LeftmostOne();
        No898_LeftmostOne.testNo898_LeftmostOne();
    }

    private void testNo898_LeftmostOne() {
        MyLogger.info("result 0 v.s. " + getColumn(new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 1}
        }));
        MyLogger.info("result 1 v.s. " + getColumn(new int[][]{
                {0, 0, 0, 1},
                {0, 1, 1, 1}
        }));
    }

    int getColumn(int[][] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        this.m = A.length;
        this.n = A[0].length;
        int min = A.length - 1;
        for (int i = 0; i < m; i++) {
            int index = binarySearch(A[i]);
            min = Math.min(min, index);
        }

        // return the final result
        return min;
    }

    int m;
    int n;

    int binarySearch(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (A[mid] == 1) {
                right = mid;
            } else {
                left = mid;
            }
        }

        if (A[left] == 1) {
            return left;
        } else {
            return right;
        }
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
