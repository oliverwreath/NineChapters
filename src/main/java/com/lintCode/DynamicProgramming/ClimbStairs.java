package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class ClimbStairs {
    public static void main(String[] args) {
        testClimbStairs();
    }

    private static void testClimbStairs() {
        for (int i = 0; i < 8; i++) {
            System.out.println(climbStairs(i));
        }
    }

    public static int climbStairs(int n) {
        if (n < 1) {
            return 1;
        }

        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }

        return f[n];
    }
}
