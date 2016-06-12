package com.oliver.DynamicProgramming;

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
        System.out.println(minPathSum(new int[][]{     {1, 2, 3},
                {3,4, 5},
        {6,5,7},
        {4,1,8}}));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];

        for (int i = 1; i < m; i++) {
            f[i][0] = grid[i][0] + grid[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = grid[0][i] + grid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }

        return f[m - 1][n -1];
    }
}
