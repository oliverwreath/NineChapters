package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class RangeSumQuery2D_Immutable_304 {
    private final static Logger logger = LoggerFactory.getLogger(RangeSumQuery2D_Immutable_304.class);

    public static void main(String[] arg) {
        new RangeSumQuery2D_Immutable_304().testRangeSumQueryImmutable_303();
    }

    private void testRangeSumQueryImmutable_303() {
        logger.info("{}", RangeSumQueryImmutable_303());
    }

    int RangeSumQueryImmutable_303() {
        NumMatrix NumMatrix = new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        System.out.println(NumMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(NumMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(NumMatrix.sumRegion(1, 2, 2, 4));
        return 0;
    }

    public class NumMatrix {
        int[][] matrix;
        int[][] sumsFromUpperLeft;

        public NumMatrix(int[][] matrix) {
            // handle extreme cases
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                this.matrix = matrix;
                this.sumsFromUpperLeft = new int[0][0];
                return;
            }

            // populate the subproblem results
            this.matrix = matrix;
            int n = matrix.length;
            int m = matrix[0].length;
            this.sumsFromUpperLeft = new int[n][m];
            sumsFromUpperLeft[0][0] = matrix[0][0];
            for (int i = 1; i < n; i++) {
                sumsFromUpperLeft[i][0] = sumsFromUpperLeft[i - 1][0] + matrix[i][0];
            }
            for (int j = 1; j < m; j++) {
                sumsFromUpperLeft[0][j] = sumsFromUpperLeft[0][j - 1] + matrix[0][j];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    sumsFromUpperLeft[i][j] = matrix[i][j] + sumsFromUpperLeft[i - 1][j] + sumsFromUpperLeft[i][j - 1] - sumsFromUpperLeft[i - 1][j - 1];
                }
            }

            // print to check
//            for (int i = 0; i < n; i++) {
//                System.out.println(Arrays.toString(sumsFromUpperLeft[i]));
//            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (row1 < 0 || col1 < 0 || row2 < 0 || col2 < 0) {
                return -1;
            }
            int n = matrix.length;
            int m = matrix[0].length;
            if (row1 >= n || col1 >= m || row2 >= n || col2 >= m) {
                return -1;
            }
            if (row1 > row2 || col1 > col2) {
                return -1;
            }
            if (row1 == 0 && col1 == 0) {
                return sumsFromUpperLeft[row2][col2];
            } else if (row1 == 0) {
                return sumsFromUpperLeft[row2][col2] - sumsFromUpperLeft[row2][col1 - 1];
            } else if (col1 == 0) {
                return sumsFromUpperLeft[row2][col2] - sumsFromUpperLeft[row1 - 1][col2];
            } else {
                int ans = sumsFromUpperLeft[row2][col2] - sumsFromUpperLeft[row2][col1 - 1] - sumsFromUpperLeft[row1 - 1][col2] + sumsFromUpperLeft[row1 - 1][col1 - 1];
                return ans;
            }
        }
    }

    // Your NumMatrix object will be instantiated and called as such:
    // NumMatrix numMatrix = new NumMatrix(matrix);
    // numMatrix.sumRegion(0, 1, 2, 3);
    // numMatrix.sumRegion(1, 2, 3, 4);
}
