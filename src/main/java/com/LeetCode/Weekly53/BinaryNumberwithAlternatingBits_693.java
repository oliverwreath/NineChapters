package com.LeetCode.Weekly53;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BinaryNumberwithAlternatingBits_693 {
    private final static Logger logger = LoggerFactory.getLogger(BinaryNumberwithAlternatingBits_693.class);

    public static void main(String[] args) {
        testBinaryNumberwithAlternatingBits_693();
    }

    private static void testBinaryNumberwithAlternatingBits_693() {
        BinaryNumberwithAlternatingBits_693 binaryNumberwithAlternatingBits_693 = new BinaryNumberwithAlternatingBits_693();
        MyLogger.info("result True v.s. " + binaryNumberwithAlternatingBits_693.hasAlternatingBits(5));
        MyLogger.info("result False v.s. " + binaryNumberwithAlternatingBits_693.hasAlternatingBits(7));
    }

    /**
     * @param n
     * @return
     */
    static public boolean hasAlternatingBits(int n) {
        if (n > 0) {
            int lastBit = n % 2;
            n = n / 2;
            while (n > 0) {
                int currentBit = n % 2;
                if (currentBit == lastBit) {
                    return false;
                } else {
                    lastBit = currentBit;
                    n = n / 2;
                }
            }
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
