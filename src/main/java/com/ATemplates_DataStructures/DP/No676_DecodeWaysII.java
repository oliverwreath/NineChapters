package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No676_DecodeWaysII {
    private static final Logger logger = LoggerFactory.getLogger(No676_DecodeWaysII.class);

    public static void main(String[] args) {
        No676_DecodeWaysII No676_DecodeWaysII = new No676_DecodeWaysII();
        No676_DecodeWaysII.testNo676_DecodeWaysII();
    }

    private void testNo676_DecodeWaysII() {
        MyLogger.info("result 2 v.s. " + numDecodings("12"));
        MyLogger.info("result 18720 v.s. " + numDecodings("**1**"));
        MyLogger.info("result 1 v.s. " + numDecodings("10"));
        MyLogger.info("result 1 v.s. " + numDecodings("20"));
        MyLogger.info("result 133236775 v.s. " + numDecodings("**********1111111111"));
    }

    final int mod = 1000000007;

    int numDecodings(String S) {
        // filter abnormal cases
        if (S == null || S.length() == 0) {
            return 0;
        }

        long[] dp = new long[S.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= S.length(); i++) {
            if (i == 1) {
                if (S.charAt(i - 1) == '*') {
                    dp[i] = 9 * dp[i - 1];
                } else {
                    dp[i] = 1 * dp[i - 1];
                }
            } else {
                if (S.charAt(i - 1) == '*') {
                    dp[i] += 9 * dp[i - 1];
                    dp[i] %= mod;
                    if (S.charAt(i - 2) == '1') {
                        dp[i] += 9 * dp[i - 2];
                    } else if (S.charAt(i - 2) == '2') {
                        dp[i] += 6 * dp[i - 2];
                    } else if (S.charAt(i - 2) == '*') {
                        dp[i] += 15 * dp[i - 2];
                    }
                } else {
                    if (S.charAt(i - 1) != '0') {
                        dp[i] += dp[i - 1];
                        dp[i] %= mod;
                    }
                    if (S.charAt(i - 2) == '1') {
                        dp[i] += dp[i - 2];
                    } else if (S.charAt(i - 2) == '2' && S.charAt(i - 1) <= '6') {
                        dp[i] += dp[i - 2];
                    } else if (S.charAt(i - 2) == '*') {
                        dp[i] += (S.charAt(i - 1) <= '6' ? 2 : 1) * dp[i - 2];
                    }
                }
                dp[i] %= mod;
            }
        }

        // return the final result
        return (int) dp[S.length()];
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
