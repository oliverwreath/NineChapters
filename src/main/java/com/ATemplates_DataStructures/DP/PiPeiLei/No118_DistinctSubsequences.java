package com.ATemplates_DataStructures.DP.PiPeiLei;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No118_DistinctSubsequences {
    private static final Logger logger = LoggerFactory.getLogger(No118_DistinctSubsequences.class);

    public static void main(String[] args) {
        No118_DistinctSubsequences No118_DistinctSubsequences = new No118_DistinctSubsequences();
        No118_DistinctSubsequences.testNo118_DistinctSubsequences();
    }

    private void testNo118_DistinctSubsequences() {
        MyLogger.info("result 3 v.s. " + numDistinct("rabbbit", "rabbit"));
    }

    public int numDistinct(String S, String T) {
        // filter abnormal cases
        if (S == null || S.length() == 0) {
            return 0;
        }
        if (T == null || T.length() == 0) {
            return 1;
        }

        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (S.charAt(i - 1) == T.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i - 1][j];
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
