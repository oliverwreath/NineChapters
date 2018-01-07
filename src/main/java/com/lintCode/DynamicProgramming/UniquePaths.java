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

        int[][] dp = new int[m][n];

        for (int x = 0; x < m; x++) {
            dp[x][0] = 1;
        }
        for (int y = 1; y < n; y++) {
            dp[0][y] = 1;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
