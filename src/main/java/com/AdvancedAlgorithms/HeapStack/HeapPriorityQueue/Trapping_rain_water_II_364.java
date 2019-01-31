package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class Trapping_rain_water_II_364 {
    private final static Logger logger = LoggerFactory.getLogger(Trapping_rain_water_II_364.class);

    public static void main(String[] args) {
        Trapping_rain_water_II_364 thisClass = new Trapping_rain_water_II_364();
        thisClass.testTrapping_rain_water_II_364();
    }

    private void testTrapping_rain_water_II_364() {
        logger.info("result {} v.s. {}", "14", trapRainWater(new int[][]{{12, 13, 0, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}}));
    }

    public int trapRainWater(int[][] heights) {
        // filter abnormal cases
        if (heights == null || heights.length == 0 || heights[0] == null || heights[0].length == 0) {
            return 0;
        }

        int result = 0;
        int m = heights.length, n = heights[0].length;
        boolean[][] isVisited = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((o1, o2) -> o1.height - o2.height);
        for (int i = 0; i < m; i++) {
            minHeap.add(new Cell(i, 0, heights[i][0]));
            isVisited[i][0] = true;
            minHeap.add(new Cell(i, n - 1, heights[i][n - 1]));
            isVisited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            minHeap.add(new Cell(0, j, heights[0][j]));
            isVisited[0][j] = true;
            minHeap.add(new Cell(m - 1, j, heights[m - 1][j]));
            isVisited[m - 1][j] = true;
        }

        while (true) {
            Cell minCell = minHeap.poll();
            boolean foundUnvisitedNeighbour = false;
            for (int t = 0; t < 4; t++) {
                int nx = minCell.x + dx[t];
                int ny = minCell.y + dy[t];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !isVisited[nx][ny]) {
                    if (minCell.height > heights[nx][ny]) {
                        result += minCell.height - heights[nx][ny];
                    }
                    minHeap.add(new Cell(nx, ny, Math.max(minCell.height, heights[nx][ny])));
                    foundUnvisitedNeighbour = true;
                    isVisited[nx][ny] = true;
                }
            }

            if (minHeap.isEmpty() && !foundUnvisitedNeighbour) {
                break;
            }
        }

        // return the final result
        return result;
    }

    private int[] dx = new int[]{0, 0, 1, -1};
    private int[] dy = new int[]{1, -1, 0, 0};

    class Cell {
        int height;
        int x;
        int y;

        public Cell(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Cell{" +
                    "height=" + height +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
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
    }
}
