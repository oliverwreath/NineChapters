package com.LeetCode.Weekly7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class ValidWordAbbreviation_408 {
    private static final Logger logger = LoggerFactory.getLogger(ValidWordAbbreviation_408.class);

    public static void main(String[] arg) {
        testValidWordAbbreviation();
    }

    private static void testValidWordAbbreviation() {
        logger.info("{}", validWordAbbreviation("a", "2"));
        logger.info("{}", validWordAbbreviation("internationalization", "i12iz4n"));
        logger.info("{}", validWordAbbreviation("apple", "a2e"));
        logger.info("{}", validWordAbbreviation("hi", "1"));
        logger.info("{}", validWordAbbreviation("abbreviation", "a10n"));
    }

    static boolean validWordAbbreviation(String word, String abr) {
        // fitler abnormal inputs
        if (word == null && abr == null) {
            return true;
        }
        if (word == null || abr == null) {
            return false;
        }

        // walk through
        int n = word.length();
        int m = abr.length();
        int i = 0;
        int j = 0;
        for (; j < m; j++) {
            if (i >= n) {
                return false;
            }
//            System.out.println(i + " " + j + "; " + word.charAt(i) + " " + abr.charAt(j));
            char currentAbr = abr.charAt(j);
            if (Character.isDigit(currentAbr)) {
                if (currentAbr == '0') {
                    return false;
                }
                int number = currentAbr - '0';
                while (j + 1 < m && Character.isDigit(abr.charAt(j + 1))) {
                    number *= 10;
                    number += abr.charAt(j + 1) - '0';
                    j++;
                }
                i += number;
            } else {
                if (word.charAt(i) != currentAbr) {
                    return false;
                }
                i++;
            }
        }
//        System.out.println("i = " + i + "; j = " + j + "; n = " + n);
        if (i != n) {
            return false;
        }

        return true;
    }
}
