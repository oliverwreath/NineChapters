package com.LeetCode.Weekly68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No769_MaxChunksToMakeSorted1 {
    private final static Logger logger = LoggerFactory.getLogger(No769_MaxChunksToMakeSorted1.class);

    public static void main(String[] args) {
        testNo769_MaxChunksToMakeSorted1();
    }

    private static void testNo769_MaxChunksToMakeSorted1() {
        No769_MaxChunksToMakeSorted1 No769_MaxChunksToMakeSorted1 = new No769_MaxChunksToMakeSorted1();
        MyLogger.info("result 1 v.s. " + No769_MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
        MyLogger.info("result 4 v.s. " + No769_MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
        MyLogger.info("result 2 v.s. " + No769_MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{1, 2, 3, 0, 4}));
    }

    /**
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        // filter abnormal cases
        if (arr == null || arr.length == 0) {
            return 1;
        }

        // core logic
        int[] map = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map[arr[i]] = i;
        }
        int minCut = 0;
        int cutCounter = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            int tmpRquire = Math.max(map[arr[i]], arr[i]);
            minCut = Math.max(minCut, tmpRquire);
            if (minCut <= i) {
//                System.out.println("Got a cut!! minCut = " + minCut);
//                System.out.println("cutCounter = " + cutCounter);
//                System.out.println("tmpRquire = " + tmpRquire);
//                System.out.println("i = " + i);
                minCut = i + 1;
                cutCounter++;
            }
        }

        // return the final result
        return cutCounter;
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
