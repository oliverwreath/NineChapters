package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class MinPathSum {
    public static void main(String[] args) {
        testMinPathSum();
    }

    private static void testMinPathSum() {
        System.out.println("result 0 = " + minPathSum(new int[][]{}));
        System.out.println("- -");
        System.out.println("result 3 = " + minPathSum(new int[][]{{1, 2}}));
        System.out.println("- -");
        System.out.println("result 5 = " + minPathSum(new int[][]{{1}, {4}}));
        System.out.println("- -");
        System.out.println("result 21 = " + minPathSum(new int[][]{{1, 2, 3},
                {3, 4, 5},
                {6, 5, 7},
                {4, 1, 8}}));
    }

//    public static int minPathSum(int[][] grid) {
//        // filter abnormal cases
//        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
//            return 0;
//        }
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] f = new int[2][n];
//        f[0][0] = grid[0][0];
//
//        for (int y = 1; y < n; y++) {
//            f[0][y] = grid[0][y] + f[0][y - 1];
//        }
//        for (int x = 1; x < m; x++) {
//            f[x % 2][0] = grid[x][0] + f[(x - 1) % 2][0];
//            for (int y = 1; y < n; y++) {
//                f[x % 2][y] = Math.min(f[(x - 1) % 2][y], f[x % 2][y - 1]) + grid[x][y];
//            }
//        }
//
//        return f[(m - 1) % 2][n - 1];
//    }

    public static int minPathSum(int[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][2];
        f[0][0] = grid[0][0];

        for (int x = 1; x < m; x++) {
            f[x][0] = f[x - 1][0] + grid[x][0];
        }
        for (int y = 1; y < n; y++) {
            f[0][y % 2] = grid[0][y] + f[0][(y - 1) % 2];
            for (int x = 1; x < m; x++) {
                f[x][y % 2] = Math.min(f[x - 1][y % 2], f[x][(y - 1) % 2]) + grid[x][y];
            }
        }

        return f[m - 1][(n - 1) % 2];
    }

//    public static int minPathSum(int[][] grid) {
//        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
//            return 0;
//        }
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[2][n];
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (i == 0 && j == 0) {
//                    dp[0][0] = grid[0][0];
//                } else if (j == 0) {
//                    dp[i % 2][0] = grid[i][0] + dp[(i - 1) % 2][0];
//                } else if (i == 0) {
//                    dp[0][j] = grid[0][j] + dp[0][j - 1];
//                } else {
//                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j], dp[i % 2][j - 1]) + grid[i][j];
//                }
//            }
//        }
//
//        return dp[(m - 1) % 2][n - 1];
//    }

//    public static int minPathSum(int[][] grid) {
//        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
//            return 0;
//        }
//
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] f = new int[m][n];
//        f[0][0] = grid[0][0];
//
//        for (int x = 1; x < m; x++) {
//            f[x][0] = grid[x][0] + f[x - 1][0];
//        }
//        for (int y = 1; y < n; y++) {
//            f[0][y] = grid[0][y] + f[0][y - 1];
//        }
//        for (int x = 1; x < m; x++) {
//            for (int y = 1; y < n; y++) {
//                f[x][y] = Math.min(f[x - 1][y], f[x][y - 1]) + grid[x][y];
//            }
//        }
//
//        return f[m - 1][n - 1];
//    }

    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
