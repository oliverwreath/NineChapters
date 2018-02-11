package com.LeetCode.Weekly42;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;

public class MaximumLengthOfPairChain_646 {
    private final static Logger logger = LoggerFactory.getLogger(MaximumLengthOfPairChain_646.class);

    public static void main(String[] args) {
        testMaximumLengthOfPairChain_646();
    }

    private static void testMaximumLengthOfPairChain_646() {
        MaximumLengthOfPairChain_646 MaximumLengthOfPairChain_646 = new MaximumLengthOfPairChain_646();
        MyLogger.info("result 2 = " + MaximumLengthOfPairChain_646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        MyLogger.info("result 3 = " + MaximumLengthOfPairChain_646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {5, 6}}));
        MyLogger.info("result 2 = " + MaximumLengthOfPairChain_646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 6}}));
    }

    /**
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length < 1 || pairs[0] == null || pairs[0].length < 1) {
            return 0;
        }

        int len = pairs.length;
        ArrayList<Pair> pairs1 = new ArrayList<Pair>(len);
        for (int i = 0; i < len; i++) {
            pairs1.add(new Pair(pairs[i][0], pairs[i][1]));
        }
        pairs1.sort(Comparator.comparingInt(o -> o.x));

        int counter = 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLength = dp[0];
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int i1 = 0; i1 < i; i1++) {
                if (pairs1.get(i1).y < pairs1.get(i).x) {
                    dp[i] = Math.max(dp[i], dp[i1] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
