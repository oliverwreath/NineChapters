package com.LintCodeContest.Weekly9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No897_IslandCity {
    private static final Logger logger = LoggerFactory.getLogger(No897_IslandCity.class);

    public static void main(String[] args) {
        No897_IslandCity No897_IslandCity = new No897_IslandCity();
        No897_IslandCity.testNo897_IslandCity();
    }

    private void testNo897_IslandCity() {
        MyLogger.info("result 0 v.s. " + numIslandCities(new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1}
        }));
        MyLogger.info("result 2 v.s. " + numIslandCities(new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {0, 0, 2, 1, 2},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 2}
        }));
    }

    int numIslandCities(int[][] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        this.m = A.length;
        this.n = A[0].length;
        this.A = A;
        this.visited = new boolean[m][n];
        int counter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 2 && !visited[i][j]) {
                    dfs(i, j);
                    counter++;
                }
            }
        }

        // return the final result
        return counter;
    }

    int[][] A;
    boolean[][] visited;
    int m;
    int n;

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        if (A[i][j] == 0) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        A[i][j] = 2;
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
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
