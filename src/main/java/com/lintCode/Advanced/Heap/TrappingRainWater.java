package com.lintCode.Advanced.Heap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-02.
 */
public class TrappingRainWater {
    private final static Logger logger = LoggerFactory.getLogger(TrappingRainWater.class);

    public static void main(String[] arg) {
        testTrappingRainWater();
    }

    private static void testTrappingRainWater() {
        logger.info("{}", trapRainWater(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));// 6
    }

    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    static int trapRainWater(int[] heights) {
        // write your code here
        // handle extreme inputs
        if (heights == null || heights.length <= 2) {
            return 0;
        }

        // coompute
        int len = heights.length;
        int left = 0;
        int right = len - 1;
        int lastLeftPeak = left;
        int lastRightPeak = right;
        int leftHeight = heights[lastLeftPeak];
        int rightHeight = heights[lastRightPeak];
        long answer = 0;
        while (left < right) {
            if (leftHeight < rightHeight) {
                left++;
                if (left >= right) {
                    break;
                }
                if (heights[left] <= leftHeight) {
                    answer += leftHeight - heights[left];
                } else {
                    lastLeftPeak = left;
                    leftHeight = heights[lastLeftPeak];
                }
            } else {
                right--;
                if (left >= right) {
                    break;
                }
                if (heights[right] <= rightHeight) {
                    answer += rightHeight - heights[right];
                } else {
                    lastRightPeak = right;
                    rightHeight = heights[lastRightPeak];
                }
            }
        }

        // return answer
        return (int) answer;
    }
}
