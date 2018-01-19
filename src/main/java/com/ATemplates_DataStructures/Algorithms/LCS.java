package com.ATemplates_DataStructures.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class LCS {
    private final static Logger logger = LoggerFactory.getLogger(LCS.class);

    public static void main(String[] args) {
        //code
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m < 1) {
                System.out.println(n);
            } else if (n < 1) {
                System.out.println(m);
            }
            String string1 = scanner.next();
            String string2 = scanner.next();
            int[][] dp = new int[m][n];
            int globalMax = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (string1.charAt(i) == string2.charAt(j)) {
                        int localMax = 0;
                        for (int x = 0; x < i; x++) {
                            for (int y = 0; y < j; y++) {
                                localMax = Math.max(localMax, dp[x][y]);
                            }
                        }
                        dp[i][j] = localMax + 1;
                        globalMax = Math.max(globalMax, dp[i][j]);
                    }
                }
            }

            System.out.println(globalMax);
        }
    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
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
