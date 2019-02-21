package com.LeetCode.gg;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class PlusOne_66 {
    private static final Logger logger = LoggerFactory.getLogger(PlusOne_66.class);

    public static void main(String[] arg) {
        new PlusOne_66().testLongestAbsoluteFilePath_388();
    }

    private void testLongestAbsoluteFilePath_388() {
//        logger.info("{}", plusOne(new int[]{}));
//        logger.info("{}", plusOne(new int[]{0}));
//        System.out.println();
//        logger.info("{}", plusOne(new int[]{-1}));
//        logger.info("{}", plusOne(new int[]{-6}));
        logger.info("{}", plusOne(new int[]{1, 9, 9}));
    }

    public int[] plusOne(int[] digits) {
        // handle extreme cases
        if (digits == null || digits.length == 0) {
            return new int[]{1};
        }

        // add one
        boolean hasCarry = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (hasCarry) {
                if (digits[i] == 9) {
                    hasCarry = true;
                    digits[i] = 0;
                } else {
                    digits[i] += 1;
                    hasCarry = false;
                }
            }
        }

        // final hasCarry?
        if (hasCarry) {
            int[] ret = new int[digits.length + 1];
            ret[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                ret[i + 1] = digits[i];
            }
            return ret;
        } else {
            return digits;
        }
    }
}
