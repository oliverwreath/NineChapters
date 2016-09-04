package com.lintCode.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class IsInterleave {
    public static void main(String[] args) {
        testIsInterleave();
    }

    private static void testIsInterleave() {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println("- -");
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println("- -");
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if ((s1.length() + s2.length()) != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        int k = s3.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = s3.length() == 0;
        for (int i = 1; i <= m; i++) {
            f[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int j = 1; j <= n; j++) {
            f[0][j] = s2.substring(0, j).equals(s3.substring(0, j));
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return f[m][n];
    }
}
