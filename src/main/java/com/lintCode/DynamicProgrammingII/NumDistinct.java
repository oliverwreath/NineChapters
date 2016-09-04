package com.lintCode.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class NumDistinct {
    public static void main(String[] args) {
        testNumDistinct();
    }

    private static void testNumDistinct() {
        System.out.println(numDistinct("mart", "karma"));
        System.out.println("- -");
        System.out.println(numDistinct("rabbbit", "rabbit"));
        System.out.println("- -");
        System.out.println(numDistinct("ABCD", "EACB"));
        System.out.println("- -");
        System.out.println(numDistinct("ABCD", "1A3B4C2323D"));
        System.out.println("- -");
    }

    public static int numDistinct(String S, String T) {
        if (S == null || T == null) {
            return -1;
        }

        int m = S.length();
        int n = T.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }
        for (int j = 1; j <= n; j++) {
            f[0][j] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j] + f[i - 1][j - 1];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        return f[m][n];
    }
}
