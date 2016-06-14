package com.oliver.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class Jump {
    public static void main(String[] args) {
        testJump();
    }

    private static void testJump() {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{3, 2, 1, 0, 4}));
    }

    public static int jump(int[] A) {
        if (A == null || A.length < 1) {
            return 0;
        }

        int len = A.length;
        int[] jump = new int[len];
        for (int i = 0; i < len; i++) {
            jump[i] = Integer.MAX_VALUE;
        }
        jump[0] = 0;

        for (int i = 0; i < len; i++) {
            if (jump[i] == Integer.MAX_VALUE) {
                break;
            }
            for (int j = 1; j <= A[i] && i + j < len; j++) {
                jump[i + j] = Math.min(jump[i + j], jump[i] + 1);
            }
        }

        return jump[len - 1];
    }
}
