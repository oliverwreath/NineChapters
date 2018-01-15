package com.LeetCode.Weekly67;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class No762_PrimeNumberOfSetBitsInBinaryRepresentation {
    private final static Logger logger = LoggerFactory.getLogger(No762_PrimeNumberOfSetBitsInBinaryRepresentation.class);

    public static void main(String[] args) {
        testNo762();
    }

    private static void testNo762() {
        No762_PrimeNumberOfSetBitsInBinaryRepresentation No762_PrimeNumberOfSetBitsInBinaryRepresentation = new No762_PrimeNumberOfSetBitsInBinaryRepresentation();
        MyLogger.info("result 4 v.s. " + No762_PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(6, 10));
        MyLogger.info("result 5 v.s. " + No762_PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(10, 15));
        MyLogger.info("result 23 v.s. " + No762_PrimeNumberOfSetBitsInBinaryRepresentation.countPrimeSetBits(842, 888));
    }

    /**
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        if (L > R) {
            return 0;
        }

        // core logic
        int counter = 0;
        for (int i = L; i <= R; i++) {
            if (isPrime(numberOfBits(i))) {
                counter++;
            }
        }

        return counter;
    }

    private int numberOfBits(int i) {
        int counter = 0;
        while (i > 0) {
            counter += i % 2;
            i /= 2;
        }
        return counter;
    }

    private static HashSet<Integer> primeSet = new HashSet<>();

    static {
        {
            primeSet.add(2);
            primeSet.add(3);
            primeSet.add(5);
            primeSet.add(7);
            primeSet.add(11);
            primeSet.add(13);
            primeSet.add(17);
            primeSet.add(19);
            primeSet.add(23);
            primeSet.add(29);
            primeSet.add(31);
        }
    }

    private boolean isPrime(int i) {
        return primeSet.contains(i);
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
