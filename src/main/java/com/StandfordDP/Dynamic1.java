package com.StandfordDP;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-09-26.
 */
public class Dynamic1 {
    private static final Logger logger = LoggerFactory.getLogger(Dynamic1.class);

    public static void main(String[] arg) {
        testDynamic1();
    }

    private static void testDynamic1() {
        logger.info("{}", backPackVariation(new int[]{1, 3, 4}, 10));
    }

    static int backPackVariation(int[] numbers, int n) {
        // filter abnormal inputs
        if (numbers == null || numbers.length == 0) {
            return 1;
        }

        // populate the subproblem result array
        int len = numbers.length;
        int[] ret = new int[n + 1];
        ret[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < len; j++) {
                if (i - numbers[j] >= 0) {
                    ret[i] += ret[i - numbers[j]];
                }
            }
        }

        // print to verify before commiting
        System.out.println(Arrays.toString(ret));

        // return result
        return ret[n];
    }
}
