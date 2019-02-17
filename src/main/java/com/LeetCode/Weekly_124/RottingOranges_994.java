package com.LeetCode.Weekly_124;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
public class RottingOranges_994 {
    private final static Logger logger = LoggerFactory.getLogger(RottingOranges_994.class);

    public static void main(String[] args) {
        RottingOranges_994 thisClass = new RottingOranges_994();
        thisClass.testRottingOranges_994();
    }

    private void testRottingOranges_994() {
        logger.info("result {} v.s. {}", "4", orangesRotting(new int[][]{
                {2, 1, 1}, {1, 1, 0}, {0, 1, 1}
        }));
        logger.info("result {} v.s. {}", "-1", orangesRotting(new int[][]{
                {2, 1, 1}, {0, 1, 1}, {1, 0, 1}
        }));
        logger.info("result {} v.s. {}", "0", orangesRotting(new int[][]{
                {0, 2}
        }));
    }

    public int orangesRotting(int[][] grid) {
        // filter abnormal cases
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        // searching logic
        int m = grid.length, n = grid[0].length;
        List<Point> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }

        int turns = 0;
        boolean isMakingProgress = true;
        while (isMakingProgress) {
            isMakingProgress = false;
            List<Point> tmpList = new ArrayList<>();
            for (Point point : list) {
                for (int t = 0; t < 4; t++) {
                    int x = dx[t] + point.x;
                    int y = dy[t] + point.y;
                    if (x >= 0 && y >= 0 && x < m && y < n) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            tmpList.add(new Point(x, y));
                            isMakingProgress = true;
                        }
                    }
                }
            }
            if (isMakingProgress) {
                list.addAll(tmpList);
                turns++;
            }
        }

        // return the final result
        return hasFresh(grid) ? -1 : turns;
    }

    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};

    private boolean hasFresh(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
