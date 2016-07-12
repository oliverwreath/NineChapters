package com.oliver.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class CanJump {
    public static void main(String[] args) {
        testCanJump();
    }

    private static void testCanJump() {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
    }

    public static boolean canJump(int[] A) {
        if (A == null || A.length < 1) {
            return true;
        }

        int len = A.length;
        int furthest = 0;

        for (int i = 0; i < len; i++) {
            if (i > furthest) {
                break;
            }
            furthest = Math.max(furthest, i + A[i]);
        }

        return furthest >= len - 1;
    }

    public static boolean canJumpDP(int[] A) {
        if (A == null || A.length < 1) {
            return true;
        }

        int len = A.length;
        boolean[] f = new boolean[len];
        f[0] = true;

        for (int i = 0; i < len; i++) {
            if (!f[i]) {
                break;
            }
            for (int j = 1; j <= A[i] && i + j < len; j++) {
                f[i + j] = true;
            }
        }

        return f[len - 1];
    }
}
