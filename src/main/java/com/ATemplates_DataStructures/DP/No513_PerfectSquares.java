package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No513_PerfectSquares {
    private final static Logger logger = LoggerFactory.getLogger(No513_PerfectSquares.class);

    public static void main(String[] args) {
        No513_PerfectSquares No513_PerfectSquares = new No513_PerfectSquares();
        No513_PerfectSquares.testNo513_PerfectSquares();
    }

    private void testNo513_PerfectSquares() {
        MyLogger.info("result 3 v.s. " + numSquares(12));
        MyLogger.info("result 2 v.s. " + numSquares(13));
    }

    int numSquares(int n) {
        // filter abnormal cases
        if (n < 0) {
            return -1;
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int sn : SN) {
                if (i - sn >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - sn] + 1);
                } else {
                    break;
                }
            }
        }

        // return the final result
        return dp[n];
    }

    static int[] SN = new int[1000];

    static {
        for (int i = 1; i <= SN.length; i++) {
            SN[i - 1] = i * i;
        }
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
