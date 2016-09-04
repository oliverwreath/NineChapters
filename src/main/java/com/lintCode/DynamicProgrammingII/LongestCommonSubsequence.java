package com.lintCode.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        testLongestCommonSubsequence();
    }

    private static void testLongestCommonSubsequence() {
        System.out.println(longestCommonSubsequence("ABCD", "EDCA"));
        System.out.println("- -");
        System.out.println(longestCommonSubsequence("ABCD", "EACB"));
        System.out.println("- -");
        System.out.println(longestCommonSubsequence("ABCD", "1A3B4C2323D"));
        System.out.println("- -");
    }

    public static int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() < 1 || B == null || B.length() < 1) {
            return 0;
        }

        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i - 1][j - 1] + 1, f[i][j]);
                }
            }
        }

        return f[m][n];
    }
}
