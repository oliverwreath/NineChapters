package com.ATemplates_DataStructures.DP.RangeDP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class No430_ScrambleString {
    private static final Logger logger = LoggerFactory.getLogger(No430_ScrambleString.class);

    public static void main(String[] args) {
        No430_ScrambleString No476_StoneGame = new No430_ScrambleString();
        No476_StoneGame.testNo476_StoneGame();
    }

    private void testNo476_StoneGame() {
        MyLogger.info("result true v.s. " + isScramble("abcd", "badc"));
//        MyLogger.info("result true v.s. " + isScramble("rgtae", "great"));
//        MyLogger.info("result false v.s. " + isScramble("rgtae", "grea"));
    }

    public boolean isScramble(String s1, String s2) {
        // filter abnormal cases
        if (s1 == null || s1.length() == 0) {
            return s2 == null || s2.length() == 0;
        }
        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();
        dp = new boolean[len][len][len + 1];
//        sum = new int[len][len];
        flag = new boolean[len][len][len + 1];
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);

        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                System.out.println(Arrays.toString(dp[i][j]));
            }
            System.out.println();
        }

        // return the final result
        return helper(0, 0, len);
    }

    boolean[][][] dp;
    //    int[][] sum;
    boolean[][][] flag;

    boolean helper(int x, int y, int n) {
        if (flag[x][y][n]) {
            return dp[x][y][n];
        }
        flag[x][y][n] = true;
//        if (n == 1) {
//            dp[x][y][n] = s1.charAt(x) == s2.charAt(y);
//            return dp[x][y][n];
//        }

        for (int k = 1; k < n; k++) {
            dp[x][y][n] |= (helper(x, y, k) && helper(x + k, y + k, n - k)) ||
                    (helper(x, y + n - k, k) && helper(x + k, y, n - k));
        }
        return dp[x][y][n];
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
