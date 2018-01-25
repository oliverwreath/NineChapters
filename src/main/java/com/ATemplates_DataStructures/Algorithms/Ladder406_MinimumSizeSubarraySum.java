package com.ATemplates_DataStructures.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Ladder406_MinimumSizeSubarraySum {
    private final static Logger logger = LoggerFactory.getLogger(Ladder406_MinimumSizeSubarraySum.class);

    public static void main(String[] args) {
        testLadder406_MinimumSizeSubarraySum();
    }

    private static void testLadder406_MinimumSizeSubarraySum() {
        Ladder406_MinimumSizeSubarraySum Ladder406_MinimumSizeSubarraySum = new Ladder406_MinimumSizeSubarraySum();
        MyLogger.info("result 2 v.s. " + Ladder406_MinimumSizeSubarraySum.minimumSize(new int[]{2, 3, 1, 2, 4, 3}, 7));
        MyLogger.info("result -1 v.s. " + Ladder406_MinimumSizeSubarraySum.minimumSize(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2113, 1, 1}, 12345));
    }

    /**
     * @param nums
     * @param s
     * @return
     */
    public int minimumSize(int[] nums, int s) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        // write your code here
        int left = 0, right = 0;
        int len = nums.length;
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        while (right < len) {
            if (sum >= s) {
                min = Math.min(min, right - left + 1);
            }
            System.out.println("sum = " + sum);

            if (sum >= s && left < right) {
                sum -= nums[left++];
            } else {
                if (right == len - 1) {
                    break;
                }
                sum += nums[++right];
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
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
