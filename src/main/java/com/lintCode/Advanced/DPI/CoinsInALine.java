package com.lintCode.Advanced.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-30.
 */
public class CoinsInALine {
    private static final Logger logger = LoggerFactory.getLogger(CoinsInALine.class);

    public static void main(String[] arg) {
        testCoinsInALine();
    }

    private static void testCoinsInALine() {
        logger.info("{}", firstWillWin(5));
        logger.info("{}", firstWillWin(6));
        logger.info("{}", firstWillWin(7));
        logger.info("{}", firstWillWin(8));
        logger.info("{}", firstWillWin(9));
    }

    private static boolean[] dp = new boolean[10000];

    /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    static boolean firstWillWin(int n) {
        // write your code here
        if (n < 1) {
            return false;
        }

        // fill the subproblems
        dp[1] = true;
        dp[2] = true;
        for (int i = 3; i <= n; i++) {
            dp[i] = (!dp[i - 1]) || (!dp[i - 2]);
        }

        // return the answer
        return dp[n];
    }
}
