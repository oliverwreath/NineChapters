package com.ATemplates_DataStructures.DP.memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No200_LongestPalindromicSubstring {
    private final static Logger logger = LoggerFactory.getLogger(No200_LongestPalindromicSubstring.class);

    public static void main(String[] args) {
        No200_LongestPalindromicSubstring No200_LongestPalindromicSubstring = new No200_LongestPalindromicSubstring();
        No200_LongestPalindromicSubstring.testNo200_LongestPalindromicSubstring();
    }

    private void testNo200_LongestPalindromicSubstring() {
        MyLogger.info("result cdzdc v.s. " + longestPalindrome("abcdzdcab"));
        MyLogger.info("result bb v.s. " + longestPalindrome("abb"));
    }

    String longestPalindrome(String s) {
        // filter abnormal cases
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
//        if(s.length() == 2){
//            if(s.charAt(0) == s.charAt(1)) {
//                return s;
//            }else {
//                return s.substring(0,1);
//            }
//        }
//        if(s.length() == 3) {
//
//        }

        int len = s.length();
        dp = new int[len][len];
        flag = new boolean[len][len];
        max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                helper(i, j, s);
            }
        }
//        helper(0, len - 1, s);
        return s.substring(maxI, maxJ + 1);
    }

    int[][] dp;
    boolean[][] flag;
    int max;
    int maxI;
    int maxJ;

    int helper(int i, int j, String s) {
        if (flag[i][j]) {
            return dp[i][j];
        }
        flag[i][j] = true;

        if (i > j) {
            dp[i][j] = 0;
        } else if (i == j) {
            dp[i][j] = 1;
        } else if (i + 1 == j) {
            dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 0;
        } else {
            dp[i][j] = helper(i + 1, j - 1, s) > 0 && (s.charAt(i) == s.charAt(j)) ? 2 + helper(i + 1, j - 1, s) : 0;
        }

        if (dp[i][j] > max) {
            max = dp[i][j];
            maxI = i;
            maxJ = j;
        }
        return dp[i][j];
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
