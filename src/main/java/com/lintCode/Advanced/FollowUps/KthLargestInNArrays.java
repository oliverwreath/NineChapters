package com.lintCode.Advanced.FollowUps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class KthLargestInNArrays {
    private static final Logger logger = LoggerFactory.getLogger(KthLargestInNArrays.class);

    public static void main(String[] arg) {
        new KthLargestInNArrays().testKthLargestInNArrays();
    }

    private void testKthLargestInNArrays() {
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 1));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 2));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 3));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 4));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 5));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 6));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 7));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 8));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 9));
        logger.info("{}", KthInArrays(new int[][]{{1, 5, 7},
                {3, 7, 8},
                {4, 8, 9},}, 10));

        logger.info("{}", KthInArrays(new int[][]{{9, 3, 2, 4, 7}, {1, 2, 3, 4, 8}}, 3));
        logger.info("{}", KthInArrays(new int[][]{{9, 3, 2, 4, 8}, {1, 2, 3, 4, 2}}, 1));

        logger.info("{}", KthInArrays(new int[][]{
                {11},
                {1, 2, 3, 4, 112, 87},
                {564},
                {789, 12, 15}}, 7));
    }

    /**
     * @param arrays a list of array
     * @param k      an integer
     * @return an integer, K-th largest element in N arrays
     */
    public int KthInArrays(int[][] arrays, int k) {
        // write your code here
        // handle extreme cases
        if (arrays == null || arrays.length == 0) {
            return -1;
        }
        if (k == 0) {
            return -1;
        }

        int n = arrays.length;
        int m = arrays[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(n, cellComparator);
        for (int i = 0; i < n; i++) {
            Arrays.sort(arrays[i]);
            if (arrays[i].length > 0) {
                heap.add(new Cell(arrays[i][arrays[i].length - 1], i, arrays[i].length - 1));
            }
        }
        for (int i = k; i > 1; i--) {
            Cell poll = heap.poll();
            if (poll.y > 0) {
                heap.add(new Cell(arrays[poll.x][poll.y - 1], poll.x, poll.y - 1));
            }
        }

        if (heap.isEmpty()) {
            return -1;
        } else {
            return heap.poll().val;
        }
    }

    Comparator<Cell> cellComparator = new Comparator<Cell>() {
        public int compare(Cell o1, Cell o2) {
            return o2.val - o1.val;
        }
    };

    private class Cell {
        int val;
        int x;
        int y;

        public Cell() {
        }

        public Cell(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
}
