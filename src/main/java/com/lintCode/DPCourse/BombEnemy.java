package com.lintCode.DPCourse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by yanli on 2017-07-10.
 */
public class BombEnemy {
    private final static Logger logger = LoggerFactory.getLogger(BombEnemy.class);

    public static void main(String[] args) {
        testBombEnemy();
    }

    private static void testBombEnemy() {
        BombEnemy bombEnemy = new BombEnemy();
        char[][] grid = new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        };
        MyLogger.debug("result 3 = " + bombEnemy.maxKilledEnemies(grid));
//        MyLogger.debug("result 1 = " + bombEnemy.maxKilledEnemies("10"));
    }

    /**
     * @param grid Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */
    public int maxKilledEnemies(char[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        //
        int maxKill = 0;
        int m = grid.length;
        int n = grid[0].length;
        int up[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    up[i][j] = grid[i][j] == 'E' ? 1 : 0;
                } else {
                    if (grid[i][j] == 'W') {
                        up[i][j] = 0;
                    } else if (grid[i][j] == 'E') {
                        up[i][j] = up[i - 1][j] + 1;
                    } else {
                        up[i][j] = up[i - 1][j];
                    }
                }
            }
        }

        int down[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i == m - 1) {
                    down[i][j] = grid[i][j] == 'E' ? 1 : 0;
                } else {
                    if (grid[i][j] == 'W') {
                        down[i][j] = 0;
                    } else if (grid[i][j] == 'E') {
                        down[i][j] = down[i + 1][j] + 1;
                    } else {
                        down[i][j] = down[i + 1][j];
                    }
                }
            }
        }

        int left[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                if (j == 0) {
                    left[i][j] = grid[i][j] == 'E' ? 1 : 0;
                } else {
                    if (grid[i][j] == 'W') {
                        left[i][j] = 0;
                    } else if (grid[i][j] == 'E') {
                        left[i][j] = left[i][j - 1] + 1;
                    } else {
                        left[i][j] = left[i][j - 1];
                    }
                }
            }
        }

        int right[][] = new int[m][n];
        for (int j = n - 1; j >= 0; j--) {
            for (int i = 0; i < m; i++) {
                if (j == n - 1) {
                    right[i][j] = grid[i][j] == 'E' ? 1 : 0;
                } else {
                    if (grid[i][j] == 'W') {
                        right[i][j] = 0;
                    } else if (grid[i][j] == 'E') {
                        right[i][j] = right[i][j + 1] + 1;
                    } else {
                        right[i][j] = right[i][j + 1];
                    }
                }
            }
        }

        int sum[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = up[i][j] + down[i][j] + left[i][j] + right[i][j];
//                if (grid[i][j] == 'E') {
//                    sum[i][j] -= 3;
//                }
            }
        }
        MyLogger.debug("up:");
        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(up[i]));
        }
        MyLogger.debug("down:");
        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(down[i]));
        }
        MyLogger.debug("left:");
        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(left[i]));
        }
        MyLogger.debug("right:");
        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(right[i]));
        }
        MyLogger.debug("sum:");
        for (int i = 0; i < m; i++) {
            MyLogger.debug(Arrays.toString(sum[i]));
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0') {
                    maxKill = Math.max(maxKill, sum[i][j]);
                }
            }
        }

        // return the final result
        return maxKill;
    }

    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
