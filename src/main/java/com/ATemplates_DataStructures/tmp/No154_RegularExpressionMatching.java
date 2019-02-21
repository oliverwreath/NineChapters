package com.ATemplates_DataStructures.tmp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No154_RegularExpressionMatching {
    private static final Logger logger = LoggerFactory.getLogger(No154_RegularExpressionMatching.class);

    public static void main(String[] args) {
        No154_RegularExpressionMatching No154_RegularExpressionMatching = new No154_RegularExpressionMatching();
        No154_RegularExpressionMatching.testNo154_RegularExpressionMatching();
    }

    private void testNo154_RegularExpressionMatching() {
        MyLogger.info("result true v.s. " + isMatch("aa", ".*"));
        MyLogger.info("result true v.s. " + isMatch("ab", ".*"));
        MyLogger.info("result true v.s. " + isMatch("aab", "c*a*b"));
        MyLogger.info("result true v.s. " + isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
        MyLogger.info("result true v.s. " + isMatch("aasdfasdfasdfasdfs", "aasdf.*asdf.*asdf.*asdf.*s"));
        MyLogger.info("result true v.s. " + isMatch("aasdf", "aasdf.*"));
        MyLogger.info("result true v.s. " + isMatch("", ".*"));
        MyLogger.info("result true v.s. " + isMatch("aaa", "a*a"));
    }

    public boolean isMatch(String A, String B) {
        // filter abnormal cases
        if (A == null) {
            return B == null;
        }
        if (A.equals(B)) {
            return true;
        }

        int m = A.length();
        int n = B.length();
        flag = new boolean[m + 1][n + 1];
        dp = new boolean[m + 1][n + 1];
        if (MyLogger.isDebugging) {
            System.out.println("m = " + m + "; n = " + n);
        }

        boolean answer = helper(m, n, A, B);
        if (MyLogger.isDebugging) {
            System.out.println("flag = ");
            for (int i = 0; i <= m; i++) {
                System.out.println(Arrays.toString(flag[i]));
            }
            System.out.println("dp = ");
            for (int i = 0; i <= m; i++) {
                System.out.println(Arrays.toString(dp[i]));
            }
        }
        return answer;
    }

    boolean[][] flag;
    boolean[][] dp;

    boolean helper(int i, int j, String A, String B) {
        if (flag[i][j]) {
            return dp[i][j];
        }
        flag[i][j] = true;

        if (j == 0) {
            dp[i][j] = i == 0;
            return dp[i][j];
        }
        if (i == 0) {
            dp[i][j] = isEmpty(j - 1, B);
            return dp[i][j];
        }
        if (B.charAt(j - 1) == '*') {
            if (j == 1) {
                dp[i][j] = helper(i, j - 1, A, B);
            } else {
                dp[i][j] |= helper(i, j - 2, A, B);
                if (B.charAt(j - 2) == '.' || B.charAt(j - 2) == A.charAt(i - 1)) {
                    dp[i][j] |= helper(i - 1, j, A, B);
                }
            }
        } else {
            dp[i][j] = (B.charAt(j - 1) == '.' || B.charAt(j - 1) == A.charAt(i - 1)) && helper(i - 1, j - 1, A, B);
        }

        return dp[i][j];
    }

    boolean isEmpty(int j, String B) {
        if (j % 2 == 0) {
            return false;
        }
        for (int i = 1; i <= j; i += 2) {
            if (B.charAt(i) != '*') {
                return false;
            }
        }
        return true;
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
