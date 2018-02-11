package com.LeetCode.Weekly53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;

public class MaxAreaofIsland_695 {
    private final static Logger logger = LoggerFactory.getLogger(MaxAreaofIsland_695.class);

    public static void main(String[] args) {
        testMaxAreaofIsland_695();
    }

    private static void testMaxAreaofIsland_695() {
        MaxAreaofIsland_695 maxAreaofIsland_695 = new MaxAreaofIsland_695();
        MyLogger.info("result 6 v.s. " + maxAreaofIsland_695.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
        MyLogger.info("result 0 v.s. " + maxAreaofIsland_695.maxAreaOfIsland(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
        }));
    }

    /**
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        // handle abnormal cases
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return 0;
        }

        // scan for an unsearched island
        int m = grid.length;
        int n = grid[0].length;

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = areaOfIsland(grid, i, j, m, n);
                    list.add(area);
                }
            }
        }

        MyLogger.debug("list = " + list);
        if (list.size() > 0) {
            Collections.sort(list);
            return list.get(list.size() - 1);
        } else {
            return 0;
        }
    }

    private int areaOfIsland(int[][] grid, int x, int y, int m, int n) {
        if (grid[x][y] == 0 || grid[x][y] == -1) {
            return 0;
        } else if (grid[x][y] == -1) {
            return 0;
        } else if (grid[x][y] == 1) {
            int sum = 1;
            grid[x][y] = -1;
            if (x + 1 <= m - 1) {
                sum += areaOfIsland(grid, x + 1, y, m, n);
            }
            if (x - 1 >= 0) {
                sum += areaOfIsland(grid, x - 1, y, m, n);
            }
            if (y + 1 <= n - 1) {
                sum += areaOfIsland(grid, x, y + 1, m, n);
            }
            if (y - 1 >= 0) {
                sum += areaOfIsland(grid, x, y - 1, m, n);
            }
            return sum;
        }
        return 0;
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
