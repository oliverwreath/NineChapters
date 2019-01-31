package com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

/**
 * nicely done, could be more concise, consider it done.
 */
public class Largest_rectangle_in_histogram_122 {
    private final static Logger logger = LoggerFactory.getLogger(Largest_rectangle_in_histogram_122.class);

    public static void main(String[] args) {
        Largest_rectangle_in_histogram_122 thisClass = new Largest_rectangle_in_histogram_122();
        thisClass.testLargest_rectangle_in_histogram_122();
    }

    private void testLargest_rectangle_in_histogram_122() {
        logger.info("result {} v.s. {}", "10", largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
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
        private static final boolean isInfoing = false;
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
