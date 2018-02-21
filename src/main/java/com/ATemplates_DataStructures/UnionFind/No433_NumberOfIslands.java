package com.ATemplates_DataStructures.UnionFind;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No433_NumberOfIslands {
    private final static Logger logger = LoggerFactory.getLogger(No433_NumberOfIslands.class);

    public static void main(String[] args) {
        No433_NumberOfIslands No433_NumberOfIslands = new No433_NumberOfIslands();
        No433_NumberOfIslands.testNo433_NumberOfIslands();
    }

    private void testNo433_NumberOfIslands() {
        MyLogger.info("result 3 v.s. " + numIslands(new boolean[][]{
                {true, true, false, false, false},
                {false, true, false, false, true},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, true}
        }));
    }

    public int numIslands(boolean[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        this.m = grid.length;
        this.n = grid[0].length;
        this.grid = grid;
        this.visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        // return the final result
        return count;
    }

    int m;
    int n;
    boolean[][] grid;
    boolean[][] visited;

    void dfs(int i, int j) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        if (i - 1 >= 0 && grid[i][j]) {
            dfs(i - 1, j);
        }
        if (i + 1 < m && grid[i][j]) {
            dfs(i + 1, j);
        }
        if (j - 1 >= 0 && grid[i][j]) {
            dfs(i, j - 1);
        }
        if (j + 1 < n && grid[i][j]) {
            dfs(i, j + 1);
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
