package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class UniquePathsWithObstacles {
    public static void main(String[] args) {
        testUniquePathsWithObstacles();
    }

    private static void testUniquePathsWithObstacles() {
        int[][] obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println("- -");
        obstacleGrid = new int[][]{
                {0, 0, 0},
                {0, 0, 1},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println("- -");
        obstacleGrid = new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
                {1, 0},
                {0, 0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
        System.out.println("- -");
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length < 1 || obstacleGrid[0] == null || obstacleGrid[0].length < 1) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int x = 1; x < m; x++) {
            if (obstacleGrid[x][0] != 1) {
                f[x][0] = obstacleGrid[x - 1][0] == 1 ? 0 : f[x - 1][0];
            }
        }
        for (int y = 1; y < n; y++) {
            if (obstacleGrid[0][y] != 1) {
                f[0][y] = obstacleGrid[0][y - 1] == 1 ? 0 : f[0][y - 1];
            }
        }

        for (int x = 1; x < m; x++) {
            for (int y = 1; y < n; y++) {
                if (obstacleGrid[x][y] != 1) {
                    f[x][y] = (obstacleGrid[x - 1][y] == 1 ? 0 : f[x - 1][y]) + (obstacleGrid[x][y - 1] == 1 ? 0 : f[x][y - 1]);
                }
            }
        }

        return f[m - 1][n - 1];
    }
}
