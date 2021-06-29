package com.lintCode.BinarySearch1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/3/2016.
 */
public class No460_KClosestNumbers {
    private static final Logger logger = LoggerFactory.getLogger(No460_KClosestNumbers.class);

    public static void main(String[] arg) {
        testKClosestNumbers();
    }

    private static void testKClosestNumbers() {
        logger.info("{}", kClosestNumbers(new int[]{1, 2, 3}, 2, 2));
        logger.info("{}", kClosestNumbers(new int[]{1, 4, 6, 8}, 3, 3));
    }

    static int[] kClosestNumbers(int[] A, int target, int k) {
        // filter coner cases
        if (A == null || A.length == 0) {
            return new int[]{};
        }

        // binary search - most closest
        int len = A.length;
        int start = 0;
        int end = len - 1;
        int closestIndex = -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                closestIndex = mid;
                break;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // scan k closest
        if (closestIndex == -1) {
            int startDiff = Math.abs(A[start] - target);
            int endDiff = Math.abs(A[end] - target);
            if (startDiff < endDiff) {
                closestIndex = start;
            } else {
                closestIndex = end;
            }
        }
        int left = closestIndex - 1;
        int right = closestIndex + 1;
        for (int i = 1; i < k; i++) {

        }


        // return result
        return new int[0];
    }
}
//    Given A = [], target = 2 and k = 3, return [2, 1, 3].

//        Given A = [1, 4, 6, 8], target = 3 and k = 3, return [4, 1, 6].
