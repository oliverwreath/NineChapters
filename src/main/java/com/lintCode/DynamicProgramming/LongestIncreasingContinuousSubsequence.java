package com.lintCode.DynamicProgramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-27.
 */
public class LongestIncreasingContinuousSubsequence {
    private final static Logger logger = LoggerFactory.getLogger(LongestIncreasingContinuousSubsequence.class);

    public static void main(String[] arg) {
        testLongestIncreasingContinuousSubsequence();
    }

    private static void testLongestIncreasingContinuousSubsequence() {
        logger.info("{}", longestIncreasingContinuousSubsequence(new int[]{5, 4, 2, 1, 3}));
        logger.info("{}", longestIncreasingContinuousSubsequence(new int[]{5, 1, 2, 3, 4}));
    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    static int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        // filter abnormal inputs
        if (A == null || A.length == 0) {
            return 0;
        }

        // fill the subproblem results
        int maxLength = 1;
        int length = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
        }
        length = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                length++;
                maxLength = Math.max(maxLength, length);
            } else {
                length = 1;
            }
        }

        // return the final result
        return maxLength;
    }
}
