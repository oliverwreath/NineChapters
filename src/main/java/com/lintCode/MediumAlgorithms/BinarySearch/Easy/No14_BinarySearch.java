package com.lintCode.MediumAlgorithms.BinarySearch.Easy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No14_BinarySearch {
    private final static Logger logger = LoggerFactory.getLogger(No14_BinarySearch.class);

    public static void main(String[] args) {
        No14_BinarySearch No14_BinarySearch = new No14_BinarySearch();
        No14_BinarySearch.testNo14_BinarySearch();
    }

    private void testNo14_BinarySearch() {
        int[] A = new int[]{1, 2, 3, 3, 4, 5, 10};
        MyLogger.info("result 2 v.s. " + binarySearch(A, 3));
    }

    public int binarySearch(int[] nums, int target) {
        // filter abnormal cases
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int begin = 0, end = nums.length - 1;
        while (begin + 1 < end) {
            int mid = (end - begin) / 2 + begin;
            if (nums[mid] < target) {
                begin = mid;
            } else {
                end = mid;
            }
        }
        if (nums[begin] == target) {
            return begin;
        } else if (nums[end] == target) {
            return end;
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
