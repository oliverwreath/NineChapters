package com.LeetCode.Weekly68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No766_ToeplitzMatrix {
    private static final Logger logger = LoggerFactory.getLogger(No766_ToeplitzMatrix.class);

    public static void main(String[] args) {
        testNo766_ToeplitzMatrix();
    }

    private static void testNo766_ToeplitzMatrix() {
        No766_ToeplitzMatrix No766_ToeplitzMatrix = new No766_ToeplitzMatrix();
        MyLogger.info("result False v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1, 2},
                {2, 2}
        }));
        MyLogger.info("result True v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1, 2}
        }));
        MyLogger.info("result True v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1}
        }));
        MyLogger.info("result True v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        }));
//        MyLogger.info("result 1 v.s. " + No766_ToeplitzMatrix.isToeplitzMatrix("10"));
    }

    /**
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        // filter abnormal cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }

        // core logic
        int m = matrix.length;
        int n = matrix[0].length;
        if (MyLogger.isDebugging) {
            for (int[] aMatrix : matrix) {
                System.out.println(Arrays.toString(aMatrix));
            }
            for (int T = m - 1; T >= 0; T--) {
                int i = T;
                int j = 0;
                final int target = matrix[i][j];
                System.out.println("Shu: " + matrix[i][j]);
                i++;
                j++;
                while (isValid(i, j, m, n)) {
                    System.out.println("Shu: " + matrix[i][j]);
                    if (matrix[i][j] != target) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
            for (int T = 1; T < n; T++) {
                int i = 0;
                int j = T;
                final int target = matrix[i][j];
                System.out.println("heng: " + matrix[i][j]);
                i++;
                j++;
                while (isValid(i, j, m, n)) {
                    System.out.println("heng: " + matrix[i][j]);
                    if (matrix[i][j] != target) {
                        return false;
                    }
                    i++;
                    j++;
                }
            }
        }

        for (int T = m - 1; T >= 0; T--) {
            int i = T;
            int j = 0;
            final int target = matrix[i][j];
            i++;
            j++;
            while (isValid(i, j, m, n)) {
                if (matrix[i][j] != target) {
                    return false;
                }
                i++;
                j++;
            }
        }
        for (int T = 1; T < n; T++) {
            int i = 0;
            int j = T;
            final int target = matrix[i][j];
            i++;
            j++;
            while (isValid(i, j, m, n)) {
                if (matrix[i][j] != target) {
                    return false;
                }
                i++;
                j++;
            }
        }

        // return the final result
        return true;
    }

    private boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
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
