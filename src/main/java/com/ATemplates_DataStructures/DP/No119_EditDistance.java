package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No119_EditDistance {
    private final static Logger logger = LoggerFactory.getLogger(No119_EditDistance.class);

    public static void main(String[] args) {
        testNo119_EditDistance();
    }

    private static void testNo119_EditDistance() {
        No119_EditDistance No119_EditDistance = new No119_EditDistance();
        MyLogger.info("result 3 v.s. " + No119_EditDistance.minDistance("mart", "karma"));
    }

    public int minDistance(String word1, String word2) {
        // filter abnormal cases
        if (word1 == null || word2 == null) {
            return 0;
        }
        if (word1.length() == 0) {
            return word2.length();
        }
        if (word2.length() == 0) {
            return word1.length();
        }

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + 1;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]);
                    }
                }
            }
        }

        // return the final result
        return dp[m][n];
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
