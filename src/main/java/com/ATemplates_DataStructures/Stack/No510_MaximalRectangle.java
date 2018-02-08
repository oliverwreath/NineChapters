package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class No510_MaximalRectangle {
    private final static Logger logger = LoggerFactory.getLogger(No510_MaximalRectangle.class);

    public static void main(String[] args) {
        testNo510_MaximalRectangle();
    }

    private static void testNo510_MaximalRectangle() {
        No510_MaximalRectangle No510_MaximalRectangle = new No510_MaximalRectangle();
        boolean[][] matrix = new boolean[][]{
                {true, true, false, false, true},
                {false, true, false, false, true},
                {false, false, true, true, true},
                {false, false, true, true, true},
                {false, false, false, false, true},
        };
        MyLogger.info("result 6 v.s. " + No510_MaximalRectangle.maximalRectangle(matrix));
    }

    public int maximalRectangle(boolean[][] matrix) {
        // write your code here
        // filter abnormal cases
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxAnswer = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] h = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    h[i][j] = matrix[i][j] ? 1 : 0;
                }
            } else {
                for (int j = 0; j < n; j++) {
                    h[i][j] = matrix[i][j] ? 1 + h[i - 1][j] : 0;
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(h[i]));
//        }

        // step 2
        for (int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for (int j = 0; j <= n; j++) {
                int current = (j == n) ? -1 : h[i][j];
                while (!stack.isEmpty() && current <= h[i][stack.peek()]) {
                    int height = h[i][stack.pop()];
                    int weight = stack.isEmpty() ? j : j - stack.peek() - 1;
                    max = Math.max(max, height * weight);
                }
                stack.push(j);
            }
//            System.out.println(max);
            maxAnswer = Math.max(maxAnswer, max);
        }

        // return the final result
        return maxAnswer;
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
