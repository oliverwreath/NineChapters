package com.lintCode.Advanced.FollowUps;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class TriangleCount {
    private static final Logger logger = LoggerFactory.getLogger(TriangleCount.class);

    public static void main(String[] arg) {
        new TriangleCount().testKthLargestInNArrays();
    }

    private void testKthLargestInNArrays() {
        logger.info("{}", triangleCount(new int[]{3, 4, 6, 7}));
        logger.info("{}", triangleCount(new int[]{4, 4, 4, 4}));
        logger.info("{}", triangleCount(new int[]{8990, 3146, 9568, 3889, 7253, 7395, 10032, 6179, 1299, 8738, 1315, 1280, 830, 6593}));
    }

    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if (S == null || S.length < 3) {
            return 0;
        }

        int n = S.length;
        int counter = 0;
        Arrays.sort(S);
        for (int i = n - 1; i > 1; i--) {
            int z = i;
            int x = 0;
            int y = i - 1;
            while (x < y) {
                if (S[x] + S[y] > S[z]) {
                    counter += y - x;
//                    System.out.println("x = " + x + "; y = " + y + "; z = " + z);
                    y--;
                } else {
                    x++;
                }
            }
        }

        return counter;
    }
}
