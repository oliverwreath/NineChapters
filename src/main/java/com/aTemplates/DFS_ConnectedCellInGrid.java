package com.aTemplates;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DFS_ConnectedCellInGrid {
    private final static Logger logger = LoggerFactory.getLogger(DFS_ConnectedCellInGrid.class);

    public static void main(String[] arg) {
        new DFS_ConnectedCellInGrid().testDFS_ConnectedCellInGrid();
    }

    private void testDFS_ConnectedCellInGrid() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int grid[][] = new int[n][m];
        for (int grid_i = 0; grid_i < n; grid_i++) {
            for (int grid_j = 0; grid_j < m; grid_j++) {
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        System.out.println(getBiggestRegion(grid));
    }

    private int getBiggestRegion(int[][] matrix) {
        // handle extreme cases
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        // DFS core logic
        int n = matrix.length;
        int m = matrix[0].length;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    count = 0;
                    dfsHelper(n, m, i, j, matrix);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }

        // return the answer
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        return maxCount;
    }

    int count = 0;

    private void dfsHelper(int n, int m, int i, int j, int[][] matrix) {
        if (matrix[i][j] == 1) {
            count++;
            matrix[i][j] = -1;
            // up
            if (i - 1 >= 0) {
                dfsHelper(n, m, i - 1, j, matrix);
            }
            // down
            if (i + 1 < n) {
                dfsHelper(n, m, i + 1, j, matrix);
            }
            // left
            if (j - 1 >= 0) {
                dfsHelper(n, m, i, j - 1, matrix);
            }
            // right
            if (j + 1 < m) {
                dfsHelper(n, m, i, j + 1, matrix);
            }
        }
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
