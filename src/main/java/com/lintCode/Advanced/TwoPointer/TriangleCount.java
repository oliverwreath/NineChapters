package com.lintCode.Advanced.TwoPointer;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-18.
 */
public class TriangleCount {
    private final static Logger logger = LoggerFactory.getLogger(TriangleCount.class);

    public static void main(String[] arg) {
        new TriangleCount().testTwoSumII();
    }

    private void testTwoSumII() {
        logger.info("{}", triangleCount(new int[]{3, 4, 6, 7}));
        logger.info("{}", triangleCount(new int[]{4, 4, 4, 4}));
    }

    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        // handle extreme cases
        if (S == null || S.length < 3) {
            return 0;
        }

        // sort
        Arrays.sort(S);
        // two pointer
        int n = S.length;
        int counter = 0;
        for (int k = 2; k < n; k++) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (S[i] + S[j] > S[k]) {
                    counter += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }

        return counter;
    }
}
