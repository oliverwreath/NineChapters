package com.LeetCode.BinarySearch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-28.
 */
public class FindMinimumInRotatedSortedArray_153 {
    private static final Logger logger = LoggerFactory.getLogger(FindMinimumInRotatedSortedArray_153.class);

    public static void main(String[] arg) {
        new FindMinimumInRotatedSortedArray_153().testFindMinimumInRotatedSortedArray_153();
    }

    private void testFindMinimumInRotatedSortedArray_153() {
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 0));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 1));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 2));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 4));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 5));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 6));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 7));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, -1));
        logger.info("{}", binarySearch(new int[]{0, 1, 2, 4, 5, 6, 7}, 9));

        logger.info("{}", findMin(new int[]{0, 1, 2, 4, 5, 6, 7}));
        logger.info("{}", findMin(new int[]{7, 0, 1, 2, 4, 5, 6,}));
        logger.info("{}", findMin(new int[]{6, 7, 0, 1, 2, 4, 5}));
    }

    public int findMin(int[] nums) {
        // handle extreme cases
        if (nums == null || nums.length == 0) {
            return -1;
        }

        // dp, bfs, binarySearch, divide conquer?
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        // return the answer
        if (nums[start] < nums[end]) {
            return nums[start];
        } else {
            return nums[end];
        }
    }

    private int binarySearch(int[] nums, int target) {
        // handle extreme cases
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            } else if (nums[mid] > target) {
                end = mid;
            } else {
                return mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
