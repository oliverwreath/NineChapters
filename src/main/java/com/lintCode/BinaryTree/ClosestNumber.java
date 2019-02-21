package com.lintCode.BinaryTree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/3/2016.
 */
public class ClosestNumber {
    private static final Logger logger = LoggerFactory.getLogger(ClosestNumber.class);

    public static void main(String[] arg) {
        testClosestNumber();
    }

    private static void testClosestNumber() {
        logger.info("{}", closestNumber(new int[]{1, 2, 3}, 2));
        logger.info("{}", closestNumber(new int[]{1, 4, 6}, 3));
        logger.info("{}", closestNumber(new int[]{1, 4, 6}, 5));
        logger.info("{}", closestNumber(new int[]{1, 3, 3, 4}, 2));
    }

    static int closestNumber(int[] A, int target) {
        // filter corner cases
        if (A == null || A.length == 0) {
            return -1;
        }
        if (A.length == 1) {
            return 0;
        }

        // binary search
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            } else {
                if (A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        // return result
        int startDiff = Math.abs(A[start] - target);
        int endDiff = Math.abs(A[end] - target);
        if (startDiff < endDiff) {
            return start;
        } else {
            return end;
        }
    }
}
