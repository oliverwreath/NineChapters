package com.LeetCode.SmarkingAlgorithmContest;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-22.
 */
public class KthSmallestInLexicographicalOrder_440 {
    private static final Logger logger = LoggerFactory.getLogger(KthSmallestInLexicographicalOrder_440.class);

    public static void main(String[] arg) {
        new KthSmallestInLexicographicalOrder_440().testKthSmallestInLexicographicalOrder_440();
    }

    private void testKthSmallestInLexicographicalOrder_440() {
//        logger.info("{}", testKthNumber(999, 2));
//        logger.info("{}", findKthNumber(203, 203));
//        logger.info("10 = {}", findKthNumber(13, 13));
//        logger.info("{}", findKthNumber(99, 99));
//        logger.info("{}", findKthNumber(999, 999));
//        logger.info("{}", findKthNumber(965, 965));
//        logger.info("{}", findKthNumber(99999965, 99999965));
        logger.info("{}", findKthNumber(100, 10));
//        logger.info("10 = {}", findKthNumber(13, 2));
//        for (int k = 1; k < 100; k++) {
//            int a = (k - 1) / 11 + 1;
//            int b = (k + 9) % 11;
////            myLogger.info(a + " " + b);
//            if (b == 10) {
//                System.out.println(a);
//            } else {
//                System.out.println(a * 10 + b);
//            }
//        }

//        for (int k = 2; k < 3; k++) {
//            int a = (k - 1) / 11 + 1;
//            int b = (k + 9) % 11;
////            myLogger.info(a + " " + b);
//            if (b == 10) {
//                System.out.println(a);
//            } else {
//                System.out.println(a * 10 + b);
//            }
//        }
    }

    public int findKthNumber(int n, int k) {
        // write your code here
        // handle extreme cases
        if (n < 10) {
//            [1, 2, 3, 4, 5, 6, 7, 8, 9] 9 * 1
            return k;
        }
        firstDigit = -1;

        int counter = 0;
        int maxLength = getMaxLength(n);
        myLogger.info("n = " + n + "; maxLength = " + maxLength + "; firstDigit = " + firstDigit);
        for (int begin = 1; begin <= 9; begin++) {
            for (int len = 1; len < maxLength; len++) {
                int localCounter = (int) Math.pow(10, len - 1);
                myLogger.info("begin = " + begin + "; len = " + len + "; localCounter = " + localCounter + "; counter = " + counter);
                if (k - counter > localCounter) {
                    counter += localCounter;
                } else {
                    int ans = begin * (int) Math.pow(10, len - 1) + k - counter - 1;
                    return ans;
                }
            }
            if (begin <= firstDigit) {
                int len = maxLength;
                if (begin < firstDigit) {
                    int localCounter = (int) Math.pow(10, len - 1);
                    myLogger.info("begin = " + begin + "; len = " + len + "; localCounter = " + localCounter + "; counter = " + counter);
                    if (k - counter > localCounter) {
                        counter += localCounter;
                    } else {
                        int ans = begin * (int) Math.pow(10, len - 1) + k - counter - 1;
                        return ans;
                    }
                } else {
                    int localCounter = (n - firstDigit * (int) Math.pow(10, len - 1) + 1);
                    myLogger.info("begin = " + begin + "; len = " + len + "; localCounter = " + localCounter + "; counter = " + counter);
                    if (k - counter > localCounter) {
                        counter += localCounter;
                    } else {
                        int ans = begin * (int) Math.pow(10, len - 1) + k - counter - 1;
                        return ans;
                    }
                }
            }
            myLogger.info();
        }

        return 0;
    }

    int firstDigit = -1;

    private int getMaxLength(int n) {
        int len = 0;
        while (n > 0) {
            len++;
            firstDigit = n;
            n /= 10;
        }
        return len;
    }

    public int testKthNumber(int n, int k) {
        // write your code here
        // handle extreme cases
        String[] a = new String[n];
        for (int i = 1; i <= n; i++) {
            a[i - 1] = String.valueOf(i);
        }
        Arrays.sort(a);
        myLogger.info("a = " + Arrays.toString(a));

        return 0;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info() {
            if (isLogging) {
                System.out.println();
            }
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
