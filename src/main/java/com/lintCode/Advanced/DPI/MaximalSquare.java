package com.lintCode.Advanced.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-28.
 */
public class MaximalSquare {
    private final static Logger logger = LoggerFactory.getLogger(MaximalSquare.class);

    public static void main(String[] arg) {
        testMaximalSquare();
    }

    private static void testMaximalSquare() {
        logger.info("{}", maxSquare(new int[][]{{1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}}));
    }

    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    static int maxSquare(int[][] matrix) {
        // write your code here
        // filter abnormal inputs
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // fill subproblem results
        int R = matrix.length;
        int C = matrix[0].length;
        int[][] dp = new int[2][C];
        int maxLength = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (i == 0 || j == 0) {
                    dp[i % 2][j] = matrix[i][j];
                } else {
                    if (matrix[i][j] == 0) {
                        dp[i % 2][j] = 0;
                    } else {
                        dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1], Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1])) + 1;
                    }
                }
                maxLength = Math.max(maxLength, dp[i % 2][j]);
            }
        }

        // print to check before committing
//        for (int i = 0; i < R; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        // return the final result
        return maxLength * maxLength;
    }
}
