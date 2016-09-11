package com.LeetCode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/10/2016.
 */
public class IntegerReplacement {
    private final static Logger logger = LoggerFactory.getLogger(IntegerReplacement.class);

    public static void main(String[] arg) {
        testIntegerReplacement();
    }

    private static void testIntegerReplacement() {
//        logger.info("{}", integerReplacement(8));//3
//        logger.info("{}", integerReplacement(7));//4
//        logger.info("{}", integerReplacement(3));//2
        for (int i = 0; i < 20000; i++) {
            logger.info("integerReplacement({}) = {}", i, integerReplacement(i));
        }
    }

    static final int LEN = 100000002;
    static byte[] min = new byte[LEN];

    static {
        for (int i = 0; i < LEN; i++) {
            min[i] = Byte.MIN_VALUE;
        }
        min[1] = 0;
    }

    public static int integerReplacement(int n) {
        // abnormal inputs
        if (n < 1) {
            return Integer.MAX_VALUE;
        }

        if (min[n] < 0) {
            byte counter;
            if (n % 2 == 0) {
                counter = (byte) (1 + integerReplacement(n / 2));
            } else {
                counter = (byte) (1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1)));
            }
            min[n] = counter;
            return counter;
        } else {
            return (int) min[n];
        }
    }
}
