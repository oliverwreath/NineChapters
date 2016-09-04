package com.lintCode.DynamicProgramming;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class Triangle {
    public static void main(String[] args) {
        testMinimumTotal();
    }

    private static void testMinimumTotal() {
        System.out.println(minimumTotal(new int[][]{}));
        System.out.println(minimumTotal(new int[][]{{1}, {3, 4}}));
        System.out.println("- -");
        System.out.println(minimumTotal(new int[][]{{2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}}));
    }

    private static int minimumTotal(int[][] triangle) {
        if (triangle == null || triangle.length < 1 || triangle[0] == null || triangle[0].length < 1) {
            return 0;
        }

        int h = triangle.length;
        int[][] f = new int[h][h];
        for (int i = 0; i < h; i++) {
            for (int i1 = 0; i1 < i + 1; i1++) {
                f[i][i1] = triangle[i][i1];
            }
        }

        for (int i = h - 2; i >= 0; i--) {
            for (int i1 = 0; i1 < (i + 1); i1++) {
                f[i][i1] += Math.min(f[i + 1][i1], f[i + 1][i1 + 1]);
            }
        }
        return f[0][0];
    }
}
