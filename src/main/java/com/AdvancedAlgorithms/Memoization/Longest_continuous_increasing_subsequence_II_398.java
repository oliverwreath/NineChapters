package com.AdvancedAlgorithms.Memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * version 1: Simply working. aka DFS. TLE huh?
 */
public class Longest_continuous_increasing_subsequence_II_398 {
    private final static Logger logger = LoggerFactory.getLogger(Longest_continuous_increasing_subsequence_II_398.class);

    public static void main(String[] args) {
        Longest_continuous_increasing_subsequence_II_398 thisClass = new Longest_continuous_increasing_subsequence_II_398();
        thisClass.testLongest_continuous_increasing_subsequence_II_398();
    }

    private void testLongest_continuous_increasing_subsequence_II_398() {
        logger.info("result {} v.s. {}", "25", longestContinuousIncreasingSubsequence2(new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 24, 23, 6},
                {15, 18, 25, 22, 7},
                {14, 19, 20, 21, 8},
                {13, 12, 11, 10, 9}
        }));
    }

    private int max = 0;

    public int longestContinuousIncreasingSubsequence2(int[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // dp logic
        int m = grid.length, n = grid[0].length;
        boolean[][] hasVisited = new boolean[m][n];
        max = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                hasVisited[x][y] = true;
                dfs(grid, x, y, 1, hasVisited);
                hasVisited[x][y] = false;
            }
        }

        // return the final result
        return max;
    }

    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    private void dfs(int[][] grid, int x, int y, int length, boolean[][] hasVisited) {
        max = Math.max(max, length);
        int m = grid.length, n = grid[0].length;
        for (int t = 0; t < 4; t++) {
            int nx = x + dx[t];
            int ny = y + dy[t];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue;
            }
            if (hasVisited[nx][ny]) {
                continue;
            }
            if (grid[nx][ny] <= grid[x][y]) {
                continue;
            }
            hasVisited[nx][ny] = true;
            dfs(grid, nx, ny, length + 1, hasVisited);
            hasVisited[nx][ny] = false;
        }
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

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
