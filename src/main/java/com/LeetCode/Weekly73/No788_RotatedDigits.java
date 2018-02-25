package com.LeetCode.Weekly73;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No788_RotatedDigits {
    private final static Logger logger = LoggerFactory.getLogger(No788_RotatedDigits.class);

    public static void main(String[] args) {
        No788_RotatedDigits No788_RotatedDigits = new No788_RotatedDigits();
        No788_RotatedDigits.testNo788_RotatedDigits();
    }

    private void testNo788_RotatedDigits() {
        MyLogger.info("result 4 v.s. " + rotatedDigits(10));
        MyLogger.info("result 247 v.s. " + rotatedDigits(857));
    }

    public int rotatedDigits(int N) {
        // filter abnormal cases
        int count = 0;
        this.N = N;
        for (int i = 1; i <= N; i++) {
            if (isGood(i)) {
                count++;
            }
        }

        // return the final result
        return count;
    }

    int N;
    int[] change = new int[]{0, 0, 5, -1, -1, 2, 9, -1, 0, 6};

    private boolean isGood(int i) {
        boolean isChange = false;
        while (i > 0) {
            int digit = i % 10;
            i /= 10;
            if (change[digit] == -1) {
                return false;
            } else if (change[digit] != 0) {
                isChange = true;
            }
        }
        return isChange;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
