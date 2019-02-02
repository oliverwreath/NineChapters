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
 * Version 2: TBD. Could use Sliding array - save space.
 */
public class Edit_Distance_119 {
    private final static Logger logger = LoggerFactory.getLogger(Edit_Distance_119.class);

    public static void main(String[] args) {
        Edit_Distance_119 thisClass = new Edit_Distance_119();
        thisClass.testLongest_common_subsequence_77();
    }

    private void testLongest_common_subsequence_77() {
        logger.info("result {} v.s. {}", "3", minDistance("mart", "karma"));
        logger.info("result {} v.s. {}", "1", minDistance("b", ""));
//        logger.info("result {} v.s. {}", "2", minDistance("ABCD", "EACB"));
    }

    public int minDistance(String A, String B) {
        // filter abnormal cases
        if (A == null || A.length() == 0) {
            return B == null ? 0 : B.length();
        }
        if (B == null || B.length() == 0) {
            return A == null ? 0 : A.length();
        }

        // dp logic
        int m = A.length(), n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }

        MyLogger.info(m);
        MyLogger.info(n);
        for (int i = 0; i <= m; i++) {
            MyLogger.info(Arrays.toString(dp[i]));
        }

        // return the final result
        return dp[m][n];
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = false;
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
