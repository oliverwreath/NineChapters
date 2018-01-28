package com.ATemplates_DataStructures.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

/**
 * Created by yanli on 2016-10-02.
 */
public class TrappingRainWaterII {
    private final static Logger logger = LoggerFactory.getLogger(TrappingRainWaterII.class);

    public static void main(String[] arg) {
        testTrappingRainWaterII();
    }

    private static void testTrappingRainWaterII() {
        logger.info("14 == {}", new TrappingRainWaterII().trapRainWater(new int[][]{
                {12, 13, 0, 12},
                {13, 4, 13, 12},
                {13, 8, 10, 12},
                {12, 13, 12, 12},
                {13, 13, 13, 13}}));
    }

    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        //
        if (heights == null || heights.length < 3 || heights[0].length < 3) {
            return 0;
        }

        //
        int m = heights.length;
        int n = heights[0].length;
        int[][] flag = new int[m][n];
        PriorityQueue<Cell> heap = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (int i = 1; i < m - 1; i++) {
            flag[i][0] = 1;
            flag[i][n - 1] = 1;
            heap.add(new Cell(i, 0, heights[i][0]));
            heap.add(new Cell(i, n - 1, heights[i][n - 1]));
        }
        for (int j = 1; j < n - 1; j++) {
            flag[0][j] = 1;
            flag[m - 1][j] = 1;
            heap.add(new Cell(0, j, heights[0][j]));
            heap.add(new Cell(m - 1, j, heights[m - 1][j]));
        }
        flag[0][0] = 1;
        flag[0][n - 1] = 1;
        flag[m - 1][0] = 1;
        flag[m - 1][n - 1] = 1;
        int result = 0;
        int countDown = (m - 2) * (n - 2);
        int max = Integer.MIN_VALUE;
        while (countDown > 0) {
            Cell cell = heap.poll();
            max = Math.max(cell.val, max);
            for (int i = 0; i < 4; i++) {
                int x = cell.x + dx[i];
                int y = cell.y + dy[i];
                if (isValid(x, y, m, n) && flag[x][y] == 0) {
                    if (max > heights[x][y]) {
                        result += max - heights[x][y];
                    }
                    flag[x][y] = 1;
                    heap.add(new Cell(x, y, heights[x][y]));
                    countDown--;
                }
            }
        }

        return result;
    }

    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    static class Cell {
        int x;
        int y;
        int val;

        public Cell() {
        }

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
