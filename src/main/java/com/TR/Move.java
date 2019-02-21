package com.TR;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Move {
    private static final Logger logger = LoggerFactory.getLogger(Move.class);

    public static void main(String[] args) {
        testMove();
    }

    private static void testMove() {
        Move Move = new Move();
        MyLogger.info("result 1 v.s. " + Move.moves(new int[]{13, 10, 21, 20}));
        MyLogger.info("result 2 v.s. " + Move.moves(new int[]{8, 5, 11, 4, 6}));
//        MyLogger.info("result 1 v.s. " + Move.moves("10"));
    }

    static int moves(int[] a) {
        // core logic
//        System.out.println(Arrays.toString(a));
        int len = a.length;
        int count = 0;
        int i = 0, j = len - 1;
        while (i < j) {
            while (a[i] % 2 == 0 && i < j) {
                i++;
            }
            if (i < j) {
                while (a[j] % 2 == 1 && i < j) {
                    j--;
                }
            }
            if (i < j) {
                count++;
                i++;
                j--;
            }
        }
        return count;
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
