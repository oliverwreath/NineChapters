package com.LeetCode.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class PartitionEqualSubsetSum_416 {
    private final static Logger logger = LoggerFactory.getLogger(PartitionEqualSubsetSum_416.class);

    public static void main(String[] arg) {
        new PartitionEqualSubsetSum_416().testLongestPalindrome_409();
    }

    private void testLongestPalindrome_409() {
        logger.info("true = {}", canPartition(new int[]{1, 5, 11, 5}));
        logger.info("false = {}", canPartition(new int[]{1, 2, 3, 5}));
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }

        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
//        System.out.println("totalSum = " + totalSum);

        if (totalSum % 2 != 0) {
            return false;
        }

        // dp
        int m = totalSum / 2 + 1;
        boolean[][] dp = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (nums[0] < n) {
            dp[0][nums[0]] = true;
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j - nums[i] >= 0) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        return dp[n - 1][m - 1];
    }
}
