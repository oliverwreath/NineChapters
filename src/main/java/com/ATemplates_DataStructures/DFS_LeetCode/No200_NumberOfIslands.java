package com.ATemplates_DataStructures.DFS_LeetCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No200_NumberOfIslands {
    private final static Logger logger = LoggerFactory.getLogger(No200_NumberOfIslands.class);

    public static void main(String[] args) {
        testNo200_NumberOfIslands();
    }

    private static void testNo200_NumberOfIslands() {
        No200_NumberOfIslands No200_NumberOfIslands = new No200_NumberOfIslands();
        MyLogger.info("result 1 v.s. " + No200_NumberOfIslands.numIslands(new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
        MyLogger.info("result 3 v.s. " + No200_NumberOfIslands.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        }));
    }

    /**
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // DFS
        int counter = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
//            System.out.println("DFS for i");
            for (int j = 0; j < n; j++) {
//                System.out.println("DFS for j");
                if (grid[i][j] == '1') {
//                    System.out.println("DFS for grid[i][j] == '1'");
                    dfsHelper(i, j, m, n, grid);
                    counter++;
                }
            }
        }

        // return the final result
        return counter;
    }

    private void dfsHelper(int i, int j, int m, int n, char[][] grid) {
        if (isValid(i, j, m, n) && grid[i][j] == '1') {
            grid[i][j] = '9';
            // horizontally
            dfsHelper(i, j - 1, m, n, grid);
            dfsHelper(i, j + 1, m, n, grid);
            // vertically
            dfsHelper(i - 1, j, m, n, grid);
            dfsHelper(i + 1, j, m, n, grid);
        }
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
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
