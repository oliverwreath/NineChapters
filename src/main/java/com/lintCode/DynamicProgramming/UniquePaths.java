package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class UniquePaths {
    public static void main(String[] args) {
        testUniquePaths();
    }

    private static void testUniquePaths() {
        System.out.println(uniquePaths(0, 0));
        System.out.println("- -");
        System.out.println(uniquePaths(1, 2));
        System.out.println("- -");
        System.out.println(uniquePaths(3, 1));
        System.out.println("- -");
        System.out.println(uniquePaths(3, 5));
    }

    public static int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }

        int[][] f = new int[m][n];
        f[0][0] = 1;

        for (int x = 1; x < m; x++) {
            f[x][0] = 1;
        }
        for (int y = 1; y < n; y++) {
            f[0][y] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                f[x][y] = f[x - 1][y] + f[x][y - 1];
            }
        }

        return f[m - 1][n - 1];
    }
}
