package com.lintCode.BackPack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-25.
 */
public class BackPackII {
    private final static Logger logger = LoggerFactory.getLogger(BackPackII.class);

    public static void main(String[] arg) {
        testBackPackII();
    }

    private static void testBackPackII() {
        logger.info("{}", backPackII(11, new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A  & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    static int backPackII(int m, int[] A, int V[]) {
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
                    ret[i][j] = Math.max(ret[i - 1][j], ret[i - 1][j - A[i - 1]] + V[i - 1]);
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
