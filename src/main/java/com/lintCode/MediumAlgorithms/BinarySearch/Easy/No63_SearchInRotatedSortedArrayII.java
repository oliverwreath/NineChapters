package com.lintCode.MediumAlgorithms.BinarySearch.Easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No63_SearchInRotatedSortedArrayII {
    private static final Logger logger = LoggerFactory.getLogger(No63_SearchInRotatedSortedArrayII.class);

    public static void main(String[] args) {
        No63_SearchInRotatedSortedArrayII No63_SearchInRotatedSortedArrayII = new No63_SearchInRotatedSortedArrayII();
        No63_SearchInRotatedSortedArrayII.testNo63_SearchInRotatedSortedArrayII();
    }

    private void testNo63_SearchInRotatedSortedArrayII() {
        MyLogger.info("result true v.s. " + search(new int[]{1, 1, 0, 1, 1, 1}, 0));
        MyLogger.info("result false v.s. " + search(new int[]{1, 1, 1, 1, 1, 1}, 0));
    }

    public boolean search(int[] A, int target) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return false;
        }

        // return the final result
        return false;
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
