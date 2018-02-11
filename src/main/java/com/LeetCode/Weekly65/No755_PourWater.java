package com.LeetCode.Weekly65;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No755_PourWater {
    private final static Logger logger = LoggerFactory.getLogger(No755_PourWater.class);

    public static void main(String[] args) {
        testNo755_PourWater();
    }

    private static void testNo755_PourWater() {
        No755_PourWater No755_PourWater = new No755_PourWater();
        MyLogger.info("result [2,2,2,3,2,2,2] v.s. " + Arrays.toString(No755_PourWater.pourWater(new int[]{2, 1, 1, 2, 1, 2, 2}, 4, 3)));
        MyLogger.info("result [2,3,3,4] v.s. " + Arrays.toString(No755_PourWater.pourWater(new int[]{1, 2, 3, 4}, 2, 2)));
        MyLogger.info("result [4,4,4] v.s. " + Arrays.toString(No755_PourWater.pourWater(new int[]{3, 1, 3}, 5, 1)));
    }

    /**
     * @param heights
     * @param V
     * @param K
     * @return
     */
    public int[] pourWater(int[] heights, int V, int K) {
        // filter abnormal inputs
        if (heights == null || heights.length < 1) {
            return heights;
        }
        if (V < 1) {
            return heights;
        }
        if (K < 0 || K > heights.length - 1) {
            return heights;
        }

        // core logic
        for (int i = 0; i < V; i++) {
            int newHeight = heights[K];
            boolean isLeftLower = false;
            int minLeftHeight = newHeight;
            int minLeftIndex = K;
            for (int iLeft = K - 1; iLeft >= 0; iLeft--) {
                if (heights[iLeft] <= heights[iLeft + 1]) {
                    if (heights[iLeft] < minLeftHeight) {
                        isLeftLower = true;
                        minLeftHeight = heights[iLeft];
                        minLeftIndex = iLeft;
                    }
                } else {
                    break;
                }
            }
            if (isLeftLower) {
                heights[minLeftIndex]++;
            } else {
                boolean isRightLower = false;
                int minRightHeight = newHeight;
                int minRightIndex = K;
                for (int iRight = K + 1; iRight < heights.length; iRight++) {
                    if (heights[iRight - 1] >= heights[iRight]) {
                        if (heights[iRight] < minRightHeight) {
                            isRightLower = true;
                            minRightHeight = heights[iRight];
                            minRightIndex = iRight;
                        }
                    } else {
                        break;
                    }
                }
                if (isRightLower) {
                    heights[minRightIndex]++;
                } else {
                    heights[K]++;
                }
            }
        }

        return heights;
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
