package com.Amazon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-19.
 */
public class SearchA2DMatrixII_240 {
    private final static Logger logger = LoggerFactory.getLogger(SearchA2DMatrixII_240.class);

    public static void main(String[] arg) {
        new SearchA2DMatrixII_240().testSearchA2DMatrix_74();
    }

    private void testSearchA2DMatrix_74() {
        int[] trueArray = new int[]{1, 2, 3, 10, 18, 15, 19, 22, 24, 30, 7};
        for (int i : trueArray) {
            logger.info("{} true = {}", i, searchMatrix(new int[][]{
                    {1, 4, 7, 11, 15},
                    {2, 5, 8, 12, 19},
                    {3, 6, 9, 16, 22},
                    {10, 13, 14, 17, 24},
                    {18, 21, 23, 26, 30}
            }, i));
        }

    }

//    /**
//     * method 1; from lower left
//     * @param matrix
//     * @param target
//     * @return
//     */
//    public boolean searchMatrix(int[][] matrix, int target) {
//        // write your code here
//        // handle extreme cases
//        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
//            return false;
//        }
//
//        //
//        int n = matrix.length;
//        int m = matrix[0].length;
//        int i = n - 1;
//        int j = 0;
//        while (i >= 0 && j < m) {
//            if (matrix[i][j] == target) {
//                return true;
//            } else if (matrix[i][j] < target) {
//                j++;
//            } else {
//                i--;
//            }
//        }
//
//        return false;
//    }

    /**
     * method 2; from upper right
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        // handle extreme cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        //
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }

        return false;
    }
}
