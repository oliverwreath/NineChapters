package com.AdvancedAlgorithms.HeapStack.Stack.MonotonousStack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

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

        int result = 0;
        Stack<Bar> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            Bar newBar = new Bar(i, height[i]);
            result = Math.max(result, addToStack(newBar, stack));
            MyLogger.info(stack);
        }
        result = Math.max(result, addToStack(new Bar(height.length, 0), stack));
        MyLogger.info(stack);

        // return the final result
        return result;
    }

    private int addToStack(Bar newBar, Stack<Bar> stack) {//new Bar(x, number)
        int result = 0;
        while (!stack.isEmpty() && stack.peek().h >= newBar.h) {
            Bar pop = stack.pop();
            if (!stack.isEmpty()) {
                result = Math.max(result, (newBar.x - stack.peek().x - 1) * pop.h);
            } else {
                result = Math.max(result, newBar.x * pop.h);
            }
        }
        stack.push(newBar);
        return result;
    }

    private class Bar {
        int x;
        int h;

        public Bar(int x, int h) {
            this.x = x;
            this.h = h;
        }

        @Override
        public String toString() {
            return "Bar{" +
                    "x=" + x +
                    ", h=" + h +
                    '}';
        }
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
