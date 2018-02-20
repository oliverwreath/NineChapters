package com.ATemplates_DataStructures.FollowUp7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * dynamic programming
 * DP Elements:
 * 1. state:
 * dp ijt means the combinations, of picking j numbers, from the first i numbers. that sum to the t.
 * <p>
 * 2. Init
 * dp 0j mean no number to pick, target 0 would meet, otherwise haha
 * dp i0 mean pick 0 numbers, same as above.
 * <p>
 * 3. Func
 * dp ijt = no pick -> dp i - 1, j, t
 * pick   -> dp i - 1, j - 1, t - A[i]
 * <p>
 * 4. Answer
 * dp len, k
 */
public class No89_kSum {
    private final static Logger logger = LoggerFactory.getLogger(No89_kSum.class);

    public static void main(String[] args) {
        No89_kSum No89_kSum = new No89_kSum();
        No89_kSum.testNo89_kSum();
    }

    private void testNo89_kSum() {
        MyLogger.info("result 2 v.s. " + kSum(new int[]{1, 2, 3, 4}, 2, 5));
        MyLogger.info("result 231 v.s. " + kSum(new int[]{1, 4, 6, 8, 10, 13, 15, 17, 18, 21, 23, 26, 27, 28, 29, 30, 32, 35, 36}, 9, 133));
        MyLogger.info("result 1 v.s. " + kSum(new int[]{1, 4, 6, 8, 10, 13, 15, 17, 18, 21, 23, 26, 27, 28, 29, 30, 32, 35, 36}, 2, 71));
        MyLogger.info("result 3 v.s. " + kSum(new int[]{1, 4, 6, 8, 10, 13, 15, 17, 18, 21, 23, 26, 27, 28, 29, 30, 32, 35, 36}, 2, 62));
    }

    public int kSum(int[] A, int k, int target) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return target == 0 ? 1 : 0;
        }

        dp = new int[A.length + 1][k + 1][target + 1];
        flag = new boolean[A.length + 1][k + 1][target + 1];
        this.A = A;

        // return the final result
        helper(A.length, k, target);
//        for (int i = 0; i <= A.length; i++) {
//            for (int j = 0; j <= k; j++) {
//                System.out.println(Arrays.toString(flag[i][j]));
//            }
//        }
//        for (int i = 0; i <= A.length; i++) {
//            for (int j = 0; j <= k; j++) {
//                System.out.println(Arrays.toString(dp[i][j]));
//            }
//        }
        return dp[A.length][k][target];
    }

    int[][][] dp;
    boolean[][][] flag;
    int[] A;

    public int helper(int i, int j, int t) {
        if (flag[i][j][t]) {
            return dp[i][j][t];
        }
        flag[i][j][t] = true;

        if (i < j) {
            dp[i][j][t] = 0;
        } else if (i == 0 || j == 0) {
            dp[i][j][t] = t == 0 ? 1 : 0;
        } else {
            dp[i][j][t] = helper(i - 1, j, t);
            if (t - A[i - 1] >= 0) {
                dp[i][j][t] += helper(i - 1, j - 1, t - A[i - 1]);
            }
        }

        return dp[i][j][t];
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
