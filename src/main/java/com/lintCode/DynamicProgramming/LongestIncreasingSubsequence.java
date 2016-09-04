package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        testlongestIncreasingSubsequence();
    }

    private static void testlongestIncreasingSubsequence() {
        System.out.println(longestIncreasingSubsequence(new int[]{2, 3, 1, 1, 4}));
        System.out.println(longestIncreasingSubsequence(new int[]{3, 2, 1, 0, 4}));
        System.out.println(longestIncreasingSubsequence(new int[]{5, 4, 1, 2, 3}));
        System.out.println(longestIncreasingSubsequence(new int[]{4, 2, 4, 5, 3, 7}));
        System.out.println(longestIncreasingSubsequence(new int[]{88, 4, 24, 82, 86, 1, 56, 74, 71, 9, 8, 18, 26, 53, 77, 87, 60, 27, 69, 17, 76, 23, 67, 14, 98, 13, 10, 83, 20, 43, 39, 29, 92, 31, 0, 30, 90, 70, 37, 59}));
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int len = nums.length;
        int[] f = new int[len];
        for (int i = 0; i < len; i++) {
            f[i] = 1;
        }

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] <= nums[j]) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
