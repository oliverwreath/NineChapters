package com.AdvancedAlgorithms.DP_I;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * nicely done!
 * Also sliding Array trick. Be careful that you can't initialize the first column at once now. You need to embedded it in the row scanning.
 */
public class Minimum_path_sum_110 {
    private static final Logger logger = LoggerFactory.getLogger(Minimum_path_sum_110.class);

    public static void main(String[] args) {
        Minimum_path_sum_110 thisClass = new Minimum_path_sum_110();
        thisClass.testMinimum_path_sum_110();
    }

    private void testMinimum_path_sum_110() {
        logger.info("result {} v.s. {}", "7", minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        logger.info("result {} v.s. {}", "6", minPathSum(new int[][]{{1, 3, 2}}));
    }

    public int minPathSum(int[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        long[][] dp = new long[2][n];
        dp[0][0] = grid[0][0];
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[i % 2][0] = grid[i][0] + dp[(i - 1) % 2][0];
            for (int j = 1; j < n; j++) {
                dp[i % 2][j] = grid[i][j] + Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]);
            }
        }

        // return the final result
        return (int) dp[(m - 1) % 2][n - 1];
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
