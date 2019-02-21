package com.HackerRank.OpenBracketCodeSprint;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-15.
 */
public class CountingSpecialSubCubes {
    private static final Logger logger = LoggerFactory.getLogger(CountingSpecialSubCubes.class);

    public static void main(String[] args) {
//        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        new CountingSpecialSubCubes().countCubes(scan);
    }

    private void countCubes(Scanner scan) {
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            // read
            int n = scan.nextInt();
            int[][][] a = new int[n][n][n];
            int counter = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        a[i][j][k] = scan.nextInt();
                        if (a[i][j][k] == 1) {
                            counter++;
                        }
                    }
                }
            }
            // k == 1
            System.out.format("%d", counter);

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.println(Arrays.toString(a[i][j]));
//                }
//            }
//            System.out.println();

            // compute
            // k >= 2
            int[][][] lastDp = a;
            for (int k = 2; k <= n; k++) {
                counter = 0;
                int diff = k - 1;
                int len = n - diff;
                int[][][] dp = new int[len][len][len];
                for (int h = 0; h < len; h++) {
                    for (int i = 0; i < len; i++) {
                        for (int j = 0; j < len; j++) {
                            int max = lastDp[h][i][j];
                            for (int x = h; x < h + 2; x++) {
                                for (int y = i; y < i + 2; y++) {
                                    for (int z = j; z < j + 2; z++) {
                                        max = Math.max(max, lastDp[x][y][z]);
                                    }
                                }
                            }
                            dp[h][i][j] = max;
                            if (max == k) {
                                counter++;
                            }
                        }
                    }
                }
                System.out.format(" %d", counter);
                lastDp = dp;
            }
            System.out.println();
        }
    }

    private void testCountCubes(Scanner scan) {
        int n = 2;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    System.out.println(getIndex(i, j, k, n));
                }
            }
        }
    }

    private int getIndex(int i, int j, int k, int n) {
        return (i - 1) * n * n + (j - 1) * n + k - 1;
    }
}
