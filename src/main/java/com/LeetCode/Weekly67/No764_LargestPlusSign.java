package com.LeetCode.Weekly67;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No764_LargestPlusSign {
    private final static Logger logger = LoggerFactory.getLogger(No764_LargestPlusSign.class);

    public static void main(String[] args) {
        testNo764_LargestPlusSign();
    }

    private static void testNo764_LargestPlusSign() {
        No764_LargestPlusSign No764_LargestPlusSign = new No764_LargestPlusSign();
//        MyLogger.info("result 2 v.s. " + No764_LargestPlusSign.orderOfLargestPlusSign(5, new int[][]{
//                {4, 2}
//        }));
//        MyLogger.info("result 1 v.s. " + No764_LargestPlusSign.orderOfLargestPlusSign(2, new int[][]{}));
//        MyLogger.info("result 0 v.s. " + No764_LargestPlusSign.orderOfLargestPlusSign(1, new int[][]{
//                {0, 0}
//        }));
        MyLogger.info("result 1 v.s. " + No764_LargestPlusSign.orderOfLargestPlusSign(2, new int[][]{
                {0, 0},
                {0, 1},
                {1, 0}
        }));
    }

    /**
     * @param N
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        // filter abnormal cases
        if (mines == null || mines.length == 0) {
            return (N + 1) / 2;
        }

        // core logic
        int m = mines.length;
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = 1;
            }
        }
        for (int[] mine : mines) {
            matrix[mine[0]][mine[1]] = 0;
        }

        int[][] dpUp = new int[N][N];
        int[][] dpDown = new int[N][N];
        int[][] dpLeft = new int[N][N];
        int[][] dpRight = new int[N][N];
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i - 1][j] == 0) {
                    dpUp[i][j] = 0;
                } else {
                    dpUp[i][j] = dpUp[i - 1][j] + 1;
                }
            }
        }
        for (int i = N - 2; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (matrix[i + 1][j] == 0) {
                    dpDown[i][j] = 0;
                } else {
                    dpDown[i][j] = dpDown[i + 1][j] + 1;
                }
            }
        }
        //left
        for (int j = 1; j < N; j++) {
            for (int i = 0; i < N; i++) {
                if (matrix[i][j - 1] == 0) {
                    dpLeft[i][j] = 0;
                } else {
                    dpLeft[i][j] = dpLeft[i][j - 1] + 1;
                }
            }
        }
        //right
        for (int j = N - 2; j >= 0; j--) {
            for (int i = 0; i < N; i++) {
                if (matrix[i][j + 1] == 0) {
                    dpRight[i][j] = 0;
                } else {
                    dpRight[i][j] = dpRight[i][j + 1] + 1;
                }
            }
        }
        // Final Scan
        int maxK = 0;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                if (matrix[i][j] == 1) {
                    maxK = Math.max(maxK, 1 + Math.min(Math.min(dpUp[i][j], dpDown[i][j]), Math.min(dpLeft[i][j], dpRight[i][j])));
                }
            }
        }
        if (maxK < 1) {
//            System.out.println("maxK = " + maxK);
            for (int i = 0; i < N; i++) {
//                System.out.println("i = " + i);
                if (matrix[i][0] == 1 || matrix[i][N - 1] == 1) {
                    maxK = 1;
                    return maxK;
                }
            }
            for (int j = 1; j < N - 1; j++) {
//                System.out.println("j = " + j);
                if (matrix[0][j] == 1 || matrix[N - 1][j] == 1) {
                    maxK = 1;
                    return maxK;
                }
            }
        }
        // check
//        System.out.println("check matrix");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
//        System.out.println("up");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dpUp[i]));
//        }
//        System.out.println("down");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dpDown[i]));
//        }
//        System.out.println("left");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dpLeft[i]));
//        }
//        System.out.println("right");
//        for (int i = 0; i < N; i++) {
//            System.out.println(Arrays.toString(dpRight[i]));
//        }

        // return the final result
        return maxK;
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
