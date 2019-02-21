package com.lintCode.MediumAlgorithms.BinarySearch.Easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No60_SearchInsert {
    private static final Logger logger = LoggerFactory.getLogger(No60_SearchInsert.class);

    public static void main(String[] args) {
        No60_SearchInsert No60_SearchInsert = new No60_SearchInsert();
        No60_SearchInsert.testNo60_SearchInsert();
    }

    private void testNo60_SearchInsert() {
        MyLogger.info("result 2 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 5));
        MyLogger.info("result 1 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 2));
        MyLogger.info("result 4 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 7));
        MyLogger.info("result 0 v.s. " + searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    public int searchInsert(int[] A, int target) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int begin = 0, end = A.length - 1;
        while (begin + 1 < end) {
            int mid = (end - begin) / 2 + begin;
            if (A[mid] < target) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (A[begin] >= target) {
            return begin;
        } else if (A[end] >= target) {
            return end;
        } else {
            return end + 1;
        }

        // return the final result
//        return -1;
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
