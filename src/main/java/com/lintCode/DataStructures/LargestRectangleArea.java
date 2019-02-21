package com.lintCode.DataStructures;

import java.util.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/19/2016.
 */
public class LargestRectangleArea {
    private static final Logger logger = LoggerFactory.getLogger(LargestRectangleArea.class);

    public static void main(String[] arg) {
        testLargestRectangleArea();
    }

    private static void testLargestRectangleArea() {
        logger.info("{}", largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        logger.info("{}", largestRectangleArea(new int[]{1, 1}));
        logger.info("{}", largestRectangleArea(new int[]{5, 4, 1, 2}));
    }

    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    static int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stackOfIndex = new Stack<Integer>();
        int max = 0;
        int len = height.length;
        for (int i = 0; i < len; i++) {
            if (!stackOfIndex.isEmpty()) {
//                System.out.println("stackOfIndex=" + stackOfIndex);
                while (!stackOfIndex.isEmpty() && height[stackOfIndex.peek()] >= height[i]) {
                    int h = height[stackOfIndex.pop()];
                    int w = stackOfIndex.isEmpty() ? i : i - stackOfIndex.peek() - 1;
//                    logger.info("h * w = {} * {} = {}", h, w, h * w);
                    max = Math.max(max, h * w);
                }
            }
            stackOfIndex.push(i);
        }

        // clear the stack
        while (!stackOfIndex.isEmpty()) {
            int h = height[stackOfIndex.pop()];
            int w = stackOfIndex.isEmpty() ? len : len - stackOfIndex.peek() - 1;
//            logger.info("h * w = {} * {} = {}", h, w, h * w);
            max = Math.max(max, h * w);
        }

        return max;
    }
}
