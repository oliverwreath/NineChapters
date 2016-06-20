package com.oliver.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class LongestCommonSubstring {
    public static void main(String[] args) {
        testLongestCommonSubstring();
    }

    private static void testLongestCommonSubstring() {
        System.out.println(longestCommonSubstring("ABCD", "CBCE"));
        System.out.println("- -");
        System.out.println(longestCommonSubstring("aabcc", "dbbca"));
        System.out.println("- -");
        System.out.println(longestCommonSubstring("aabcc", "aabcc"));
        System.out.println("- -");
    }

    public static int longestCommonSubstring(String A, String B) {
        if (A == null || B == null) {
            return 0;
        }

        int m = A.length();
        int n = B.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) {
            f[0][j] = 0;
        }

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                    max = Math.max(max, f[i][j]);
                }
            }
        }

        return max;
    }
}
