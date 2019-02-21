package com.AdvancedAlgorithms.DP_II.TwoSequence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. Okay DP.
 * <p>
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD. Could be Sliding array - save space.
 */
public class Longest_common_subsequence_77 {
    private static final Logger logger = LoggerFactory.getLogger(Longest_common_subsequence_77.class);

    public static void main(String[] args) {
        Longest_common_subsequence_77 thisClass = new Longest_common_subsequence_77();
        thisClass.testLongest_common_subsequence_77();
    }

    private void testLongest_common_subsequence_77() {
        logger.info("result {} v.s. {}", "1", longestCommonSubsequence("ABCD", "EDCA"));
        logger.info("result {} v.s. {}", "2", longestCommonSubsequence("ABCD", "EACB"));
    }

    public int longestCommonSubsequence(String A, String B) {
        // filter abnormal cases
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        // dp logic
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0);
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        // return the final result
        return dp[m][n];
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
