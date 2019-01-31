package com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * this depends on the maxAreaInHist
 */
public class MaximalRectangle_510 {
    private final static Logger logger = LoggerFactory.getLogger(MaximalRectangle_510.class);

    public static void main(String[] args) {
        MaximalRectangle_510 thisClass = new MaximalRectangle_510();
        thisClass.testMaximalRectangle_510();
    }

    private void testMaximalRectangle_510() {
        logger.info("result {} v.s. {}", "6", maximalRectangle(
                new boolean[][]{
                        {true, true, false, false, true},
                        {false, true, false, false, true},
                        {false, false, true, true, true},
                        {false, false, true, true, true},
                        {false, false, false, false, true}
                }
        ));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    public int maximalRectangle(boolean[][] matrix) {
        // filter abnormal cases
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return 0;
        }

        // intermediate intMatrix
        int m = matrix.length, n = matrix[0].length;
        int[][] intMatrix = new int[m][n];
        for (int y = 0; y < n; y++) {
            intMatrix[0][y] = matrix[0][y] ? 1 : 0;
        }

        for (int x = 1; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (!matrix[x][y]) {
                    intMatrix[x][y] = 0;
                } else {
                    intMatrix[x][y] = 1 + intMatrix[x - 1][y];
                }
            }
        }

        // for every row, do the histogram trick of Monotonous Stack
        int max = 0;
        for (int x = 0; x < m; x++) {
            max = Math.max(max, largestRectangleArea(intMatrix[x]));
        }

        // return the final result
        return max;
    }

    public int largestRectangleArea(int[] height) {
        // filter abnormal cases
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int currentHeight = i == height.length ? 0 : height[i];
            while (!stack.isEmpty() && currentHeight <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        // return the final max
        return max;
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
