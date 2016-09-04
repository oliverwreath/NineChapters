package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class MinPathSum {
    public static void main(String[] args) {
        testMinPathSum();
    }

    private static void testMinPathSum() {
        System.out.println(minPathSum(new int[][]{}));
        System.out.println("- -");
        System.out.println(minPathSum(new int[][]{{1, 2}}));
        System.out.println("- -");
        System.out.println(minPathSum(new int[][]{{1}, {4}}));
        System.out.println("- -");
        System.out.println(minPathSum(new int[][]{{1, 2, 3},
                {3, 4, 5},
                {6, 5, 7},
                {4, 1, 8}}));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        for (int x = 1; x < m; x++) {
            f[x][0] = grid[x][0] + f[x - 1][0];
        }
        for (int y = 1; y < n; y++) {
            f[0][y] = grid[0][y] + f[0][y - 1];
        }
        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                f[x][y] = Math.min(f[x - 1][y], f[x][y - 1]) + grid[x][y];
            }
        }

        return f[m - 1][n - 1];
    }
}
