package com.LeetCode.TopGoogleQuestions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MedianOfTwoSortedArrays {
    private final static Logger logger = LoggerFactory.getLogger(MedianOfTwoSortedArrays.class);

    public static void main(String[] args) {
        testMedianOfTwoSortedArrays();
    }

    private static void testMedianOfTwoSortedArrays() {
        MedianOfTwoSortedArrays MedianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        MyLogger.info("result 2.0 v.s. " + MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        MyLogger.info("result 2.5 v.s. " + MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        MyLogger.info("result 1.5 v.s. " + MedianOfTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, null));
        MyLogger.info("result 3.5 v.s. " + MedianOfTwoSortedArrays.findMedianSortedArrays(null, new int[]{3, 4}));
    }

    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // filter abnormal inputs
        if (nums1 == null || nums1.length < 1) {
            return findMedianSortedArray(nums2);
        }
        if (nums2 == null || nums2.length < 1) {
            return findMedianSortedArray(nums1);
        }

        // core logic
        int m = nums1.length;
        int n = nums2.length;
        int xBegin = 0, yBegin = 0;
        int xEnd = m - 1, yEnd = n - 1;
        if (m > n) {
            while (xBegin + 1 < xEnd) {
                if (yBegin + 1 < yEnd) {
                    int xMid = xBegin + (xEnd - xBegin) / 2;
                    int yMid = yBegin + (yEnd - yBegin) / 2;
                } else {
                    

                }
            }
        }

        return -1.0;
    }

    private double findMedianSortedArray(int[] nums) {
        // filter abnormal inputs
        if (nums == null || nums.length < 1) {
            return 0.0;
        }

        // core logic
        if (nums.length % 2 == 0) {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        } else {
            return nums[nums.length / 2];
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
