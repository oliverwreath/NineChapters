package com.lintCode.BackPack;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-25.
 */
public class BackPackIII {
    private final static Logger logger = LoggerFactory.getLogger(BackPackIII.class);

    public static void main(String[] arg) {
        testBackPackIII();
    }

    private static void testBackPackIII() {
        logger.info("{}", backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
    }

    /**
     * @param A an integer array
     * @param V an integer array
     * @param m an integer
     * @return an array
     */
    static int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }

        // fill the result matrix
        int n = A.length;
        int[][] ret = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j - A[i - 1] >= 0) {
                    ret[i][j] = Math.max(ret[i - 1][j], ret[i][j - A[i - 1]] + V[i - 1]);
                } else {
                    ret[i][j] = ret[i - 1][j];
                }
            }
        }

//        for (int i = 0; i <= n; i++) {
//            System.out.println(Arrays.toString(ret[i]));
//        }

        // return result
        return ret[n][m];
    }
}
