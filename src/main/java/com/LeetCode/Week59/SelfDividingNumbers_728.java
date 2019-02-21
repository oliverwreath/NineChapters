package com.LeetCode.Week59;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers_728 {
    private static final Logger logger = LoggerFactory.getLogger(SelfDividingNumbers_728.class);

    public static void main(String[] args) {
        testSelfDividingNumbers_728();
    }

    private static void testSelfDividingNumbers_728() {
        SelfDividingNumbers_728 SelfDividingNumbers_728 = new SelfDividingNumbers_728();
        MyLogger.info("result [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22] v.s. " + SelfDividingNumbers_728.selfDividingNumbers(1, 22));
    }

    /**
     * @param left
     * @param right
     * @return
     */
    public List<Integer> selfDividingNumbers(int left, int right) {
        if (left > right) {
            return new LinkedList<>();
        }

        // core logic
        List<Integer> result = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividingNumber(int number) {
        int originalNumber = number;
        while (number > 0) {
            int digit = number % 10;
            if (digit == 0 || originalNumber % digit != 0) {
                return false;
            }
            number /= 10;
        }

        return true;
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
