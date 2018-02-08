package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class No122_LargestRectangleInHistogram {
    private final static Logger logger = LoggerFactory.getLogger(No122_LargestRectangleInHistogram.class);

    public static void main(String[] args) {
        testNo122_LargestRectangleInHistogram();
    }

    private static void testNo122_LargestRectangleInHistogram() {
        No122_LargestRectangleInHistogram No122_LargestRectangleInHistogram = new No122_LargestRectangleInHistogram();
        MyLogger.info("result 10 v.s. " + No122_LargestRectangleInHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
//        MyLogger.info("result 1 v.s. " + No122_LargestRectangleInHistogram.largestRectangleArea("10"));
    }

    public int largestRectangleArea(int[] height) {
        // write your code here
        // filter abnormal cases
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            int current = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && current <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                System.out.println(h + " * " + w);
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
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
