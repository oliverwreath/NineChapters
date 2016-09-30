package com.lintCode.Advanced.DPI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-30.
 */
public class CoinsInALineII {
    private final static Logger logger = LoggerFactory.getLogger(CoinsInALineII.class);

    public static void main(String[] arg) {
        testCoinsInALine();
    }

    private static void testCoinsInALine() {
        logger.info("{}", firstWillWin(new int[]{1, 2, 2}));
        logger.info("{}", firstWillWin(new int[]{1, 2, 4}));
    }

    private static long[] dp = new long[100000];
    private static long[] sum = new long[100000];

    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    static boolean firstWillWin(int[] values) {
        // write your code here
        if (values == null || values.length <= 0) {
            return false;
        }
        if (values.length < 3) {
            return true;
        }

        // fill the subproblems
        int n = values.length;
        sum[0] = values[n - 1];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + values[n - 1 - i];
        }
        dp[0] = values[n - 1];
        dp[1] = values[n - 1] + values[n - 2];
        for (int i = 2; i < n; i++) {
            dp[i] = sum[i] - Math.min(dp[i - 1], dp[i - 2]);
        }

        // print to check before committing
//        System.out.println(Arrays.toString(sum));
//        System.out.println(Arrays.toString(dp));

        // return the answer
        return (dp[n - 1] > dp[n - 2] || dp[n - 1] > dp[n - 3]);
    }
}
