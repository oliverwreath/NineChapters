package com.LeetCode.Weekly65;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No754_ReachANumber {
    private final static Logger logger = LoggerFactory.getLogger(No754_ReachANumber.class);

    public static void main(String[] args) {
        testNo754_ReachANumber();
    }

    private static void testNo754_ReachANumber() {
        No754_ReachANumber No754_ReachANumber = new No754_ReachANumber();
        MyLogger.info("result 2 v.s. " + No754_ReachANumber.reachNumber(3));
        MyLogger.info("result 3 v.s. " + No754_ReachANumber.reachNumber(2));
        for (int i = 0; i < 13; i++) {
            MyLogger.info(i + ": result ? v.s. " + No754_ReachANumber.reachNumber(i));
        }
    }

    /**
     * @param target
     * @return
     */
    public int reachNumber(int target) {
        // filter abnormal inputs
        if (target == 0) {
            return 0;
        }
        if (target < 0) {
            target = -target;
        }

        // core logic
        int i = 0;
        int sum = 0;
        while (true) {
            i++;
            sum += i;
            if (sum < target) {
                continue;
            } else if (sum > target) {
                if ((sum - target) % 2 == 0) {
                    return i;
                } else {
                    continue;
                }
            } else {
                return i;
            }
        }
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
