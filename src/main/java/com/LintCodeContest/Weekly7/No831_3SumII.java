package com.LintCodeContest.Weekly7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No831_3SumII {
    private static final Logger logger = LoggerFactory.getLogger(No831_3SumII.class);

    public static void main(String[] args) {
        No831_3SumII No831_3SumII = new No831_3SumII();
        No831_3SumII.testNo831_3SumII();
    }

    private void testNo831_3SumII() {
        MyLogger.info("result 1 v.s. " + threeSum2(0));
        MyLogger.info("result 1 v.s. " + threeSum2(1));
    }

    int threeSum2(int n) {
        // filter abnormal cases
        if (n < 0) {
            return -1;
        }

        int counter = 0;
        for (int x = 0; x < 1000000; x++) {
            if (x * x > n) {
                break;
            }
            for (int y = x; y < 1000000; y++) {
                int left = x * x + y * y;
                if (left > n) {
                    break;
                }
                for (int z = y; z < 1000000; z++) {
                    int right = n - z * z;
                    if (left > right) {
                        break;
                    } else if (left == right) {
                        counter++;
                    }
                }
            }
        }

        // return the final result
        return counter;
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
