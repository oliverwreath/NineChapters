package com.NineChapters.TwoPointers.Reverse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidPalindrome_415 {
    private static final Logger logger = LoggerFactory.getLogger(ValidPalindrome_415.class);

    public static void main(String[] args) {
        testValidPalindrome_415();
    }

    private static void testValidPalindrome_415() {
        logger.info("result true v.s. {}", isPalindrome("A man, a plan, a canal: Panama"));
        logger.info("result false v.s. {}", isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        // filter abnormal cases
        if (s == null || s.length() == 0) {
            return true;
        }

        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            } else {
                left++;
                right--;
                continue;
            }
        }

        // return the final result
        return true;
    }

    private static boolean isValid(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
