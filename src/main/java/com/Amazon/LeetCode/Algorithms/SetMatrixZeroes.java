package com.Amazon.LeetCode.Algorithms;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class SetMatrixZeroes {
    private static final Logger logger = LoggerFactory.getLogger(SetMatrixZeroes.class);

    public static void main(String[] arg) {
        new SetMatrixZeroes().testSetMatrixZeroes();
    }

    private void testSetMatrixZeroes() {
        int[][] matrix = {
                {9, 9, 0, 9},
                {9, 0, 9, 9},
                {9, 9, 0, 9},
                {9, 9, 9, 9}
        };
        logger.info("before = ");
        for (int i = 0; i < matrix.length; i++) {
            logger.info("{}", Arrays.toString(matrix[i]));
        }
        setZeroes(matrix);
        logger.info("after = ");
        for (int i = 0; i < matrix.length; i++) {
            logger.info("{}", Arrays.toString(matrix[i]));
        }
    }

    public void setZeroes(int[][] matrix) {
        // write your code here
        // handle extreme cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }

        // in place
        int n = matrix.length;
        int m = matrix[0].length;
        // mark
        boolean i0 = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    if (j == 0) {
                        i0 = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                    printMatrix(matrix);
                }
            }
        }

        // paint
        for (int j = 1; j < m; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < n; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (i0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }
        printMatrix(matrix);

        return;
    }

    private void printMatrix(int[][] matrix) {
        if (isLogging) {
            if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
                return;
            }

            for (int i = 0; i < matrix.length; i++) {
                System.out.println(Arrays.toString(matrix[i]));
            }
        }
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

//    static {
//        isLogging = true;
//    }
}
