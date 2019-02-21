package com.LeetCode.Weekly67;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class No765_CouplesHoldingHands {
    private static final Logger logger = LoggerFactory.getLogger(No765_CouplesHoldingHands.class);

    public static void main(String[] args) {
        testNo765_CouplesHoldingHands();
    }

    private static void testNo765_CouplesHoldingHands() {
        No765_CouplesHoldingHands No765_CouplesHoldingHands = new No765_CouplesHoldingHands();
        MyLogger.info("result 1 v.s. " + No765_CouplesHoldingHands.minSwapsCouples(new int[]{0, 2, 1, 3}));
        MyLogger.info("result 0 v.s. " + No765_CouplesHoldingHands.minSwapsCouples(new int[]{3, 2, 0, 1}));
        MyLogger.info("result 2 v.s. " + No765_CouplesHoldingHands.minSwapsCouples(new int[]{6, 2, 1, 0, 4, 3, 5, 7}));
        MyLogger.info("result 3 v.s. " + No765_CouplesHoldingHands.minSwapsCouples(new int[]{0, 2, 4, 6, 7, 1, 3, 5}));
        MyLogger.info("result 3 v.s. " + No765_CouplesHoldingHands.minSwapsCouples(new int[]{1, 4, 0, 5, 8, 7, 6, 3, 2, 9}));
    }

    /**
     * @param row
     * @return
     */
    public int minSwapsCouples(int[] row) {
        // filter abnormal cases
        if (row == null || row.length == 0) {
            return 0;
        }

        // core logic
        int swapCounter = 0;
        HashMap<Integer, Integer> lookup = new HashMap<>();
        for (int i = 0; i < row.length; i++) {
            lookup.put(row[i], i);
        }
        for (int i = 0; i < row.length; i += 2) {
            if (!isPair(row[i], row[i + 1])) {
                swap(row, i + 1, lookup.get(getPartner(row[i])), lookup);
                swapCounter++;
            }
        }

        // return the final result
        return swapCounter;
    }

    private int getPartner(int i) {
        if (i % 2 == 0) {
            return i + 1;
        } else {
            return i - 1;
        }
    }

    private void swap(int[] row, int i, int j, HashMap<Integer, Integer> lookup) {
        int tmp = row[i];
        lookup.put(row[i], j);
        lookup.put(row[j], i);
        row[i] = row[j];
        row[j] = tmp;
    }

    private boolean isPair(int a, int b) {
        return a / 2 == b / 2;
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
