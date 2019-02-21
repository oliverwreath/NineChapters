package com.lintCode.Advanced.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-28.
 */
public class MinimumPathSum {
    private static final Logger logger = LoggerFactory.getLogger(MinimumPathSum.class);

    public static void main(String[] arg) {
        testMinimumPathSum();
    }

    private static void testMinimumPathSum() {
        logger.info("{}", minPathSum(new int[][]{}));
        logger.info("{}", "- -");
        logger.info("{}", minPathSum(new int[][]{{1, 2}}));
        logger.info("{}", "- -");
        logger.info("{}", minPathSum(new int[][]{{1}, {4}}));
        logger.info("{}", "- -");
        logger.info("{}", minPathSum(new int[][]{{1, 2, 3},
                {3, 4, 5},
                {6, 5, 7},
                {4, 1, 8}}));
    }

    /**
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[2][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[0][0] = grid[0][0];
                } else if (j == 0) {
                    dp[i % 2][0] = grid[i][0] + dp[(i - 1) % 2][0];
                } else if (i == 0) {
                    dp[0][j] = grid[0][j] + dp[0][j - 1];
                } else {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
                }
            }
        }

        return dp[(m - 1) % 2][n - 1];
    }
}
