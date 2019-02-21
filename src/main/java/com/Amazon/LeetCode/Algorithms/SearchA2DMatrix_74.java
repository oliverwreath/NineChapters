package com.Amazon.LeetCode.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class SearchA2DMatrix_74 {
    private static final Logger logger = LoggerFactory.getLogger(SearchA2DMatrix_74.class);

    public static void main(String[] arg) {
        new SearchA2DMatrix_74().testSearchA2DMatrix_74();
    }

    private void testSearchA2DMatrix_74() {
        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 3));
        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 1));
        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 10));

        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 23));

        logger.info("7 true = {}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 7));
        logger.info("20 true = {}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 20));
        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 50));
        logger.info("{}", searchMatrix(new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        }, 24));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        // handle extreme cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        //
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        if (n == 1) {
            row = 0;
        } else {
            int start = 0;
            int end = n - 1;
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (matrix[mid][0] == target) {
                    return true;
                } else if (matrix[mid][0] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (matrix[end][0] <= target) {
//                if (matrix[row][end] == target) {
//                    return true;
//                }
                row = end;
//                System.out.println("row = end = " + row);
            } else if (matrix[start][0] <= target) {
//                if (matrix[row][start] == target) {
//                    return true;
//                }
                row = start;
//                System.out.println("row = start = " + row);
            } else {
                return false;
            }
        }
//        System.out.println("row = " + row);
        int start = 0;
        int end = m - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (matrix[row][start] == target) {
            return true;
        } else if (matrix[row][end] == target) {
            return true;
        }

        return false;
    }
}
