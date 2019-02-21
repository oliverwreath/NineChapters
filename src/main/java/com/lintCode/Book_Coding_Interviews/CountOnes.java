package com.lintCode.Book_Coding_Interviews;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/4/2016.
 */
public class CountOnes {
    private static final Logger logger = LoggerFactory.getLogger(CountOnes.class);

    public static void main(String[] arg) {
        testCountOnes();
    }

    private static void testCountOnes() {
        logger.info("{}", countOnes(1023));
        logger.info("{}", countOnes(32));
        logger.info("{}", countOnes(5));
    }

    static int countOnes(int num) {
        int count = 0;
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }
}
