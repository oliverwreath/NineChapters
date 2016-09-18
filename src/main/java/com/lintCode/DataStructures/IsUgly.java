package com.lintCode.DataStructures;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/18/2016.
 */
public class IsUgly {
    private final static Logger logger = LoggerFactory.getLogger(IsUgly.class);

    public static void main(String[] arg) {
        testIsUgly();
    }

    private static void testIsUgly() {
        logger.info("{}", isUgly(8));
        logger.info("{}", isUgly(14));
    }

    /**
     * @param num an integer
     * @return true if num is an ugly number or false
     */
    static boolean isUgly(int num) {
        // Write your code here
        if (num < 1) {
            return false;
        }
        if (num == 1) {
            return true;
        }

        while (num >= 2 && num % 2 == 0) {
            num /= 2;
        }
        while (num >= 3 && num % 3 == 0) {
            num /= 3;
        }
        while (num >= 5 && num % 5 == 0) {
            num /= 5;
        }

        return num == 1;
    }
}
