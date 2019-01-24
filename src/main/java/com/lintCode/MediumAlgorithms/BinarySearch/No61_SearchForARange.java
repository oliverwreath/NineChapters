package com.lintCode.MediumAlgorithms.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No61_SearchForARange {
    private final static Logger logger = LoggerFactory.getLogger(No61_SearchForARange.class);

    public static void main(String[] args) {
        No61_SearchForARange No61_SearchForARange = new No61_SearchForARange();
        No61_SearchForARange.testNo61_SearchForARange();
    }

    private void testNo61_SearchForARange() {
        int[] A = {5, 7, 7, 8, 8, 10};
        MyLogger.info("result 2 v.s. " + Arrays.toString(searchRange(A, 8)));
    }

    public int[] searchRange(int[] A, int target) {
        // filter abnormal cases
        int[] results = new int[]{-1, -1};
        if (A == null || A.length == 0) {
            return results;
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
        if (A[begin] == target) {
            results[0] = begin;
        } else if (A[end] == target) {
            results[0] = end;
        }

        begin = 0;
        end = A.length - 1;
        while (begin + 1 < end) {
            int mid = (end - begin) / 2 + begin;
            if (A[mid] <= target) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            results[1] = end;
        } else if (A[begin] == target) {
            results[1] = begin;
        }

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
