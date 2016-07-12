package com.oliver.DynamicProgrammingII;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class MinDistance {
    public static void main(String[] args) {
        testMinDistance();
    }

    private static void testMinDistance() {
        System.out.println(minDistance("mart", "karma"));
        System.out.println("- -");
        System.out.println(minDistance("ABCD", "EDCA"));
        System.out.println("- -");
        System.out.println(minDistance("ABCD", "EACB"));
        System.out.println("- -");
        System.out.println(minDistance("ABCD", "1A3B4C2323D"));
        System.out.println("- -");
    }

    public static int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return -1;
        }

        int m = word1.length();
        int n = word2.length();
        int[][] f = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            f[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.min(f[i - 1][j] + 1, f[i][j - 1] + 1);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + 1);
                }
            }
        }

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(f[i]));
//        }
        return f[m][n];
    }
}
