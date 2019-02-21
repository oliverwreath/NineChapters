package com.ATemplates_DataStructures.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No752_RogueKnightSven {
    private static final Logger logger = LoggerFactory.getLogger(No752_RogueKnightSven.class);

    public static void main(String[] args) {
        No752_RogueKnightSven No752_RogueKnightSven = new No752_RogueKnightSven();
        No752_RogueKnightSven.testNo752_RogueKnightSven();
    }

    private void testNo752_RogueKnightSven() {
        MyLogger.info("result 1 v.s. " + getNumberOfWays(1, 1, 1, new int[]{0, 1}));
        MyLogger.info("result 0 v.s. " + getNumberOfWays(1, 1, 1, new int[]{0, 2}));
        MyLogger.info("result 2 v.s. " + getNumberOfWays(2, 3, 2, new int[]{0, 1, 1}));
        MyLogger.info("result 1 v.s. " + getNumberOfWays(2, 3, 2, new int[]{0, 3, 1}));
    }

    long getNumberOfWays(int n, int m, int limit, int[] cost) {
        // filter abnormal cases
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j == m ? 1 : 0;
                } else if (j + cost[i] <= m) {
                    for (int s = Math.max(i - limit, 0); s < i; s++) {
                        dp[i][j] += dp[s][j + cost[i]];
                    }
                }
            }
        }

        long answer = 0;
        for (int j = 0; j <= m; j++) {
            answer += dp[n][j];
        }
//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        // return the final result
        return answer;
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
