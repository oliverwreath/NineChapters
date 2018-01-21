package com.LeetCode.Weekly68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;

public class No768_MaxChunksToMakeSorted2 {
    private final static Logger logger = LoggerFactory.getLogger(No768_MaxChunksToMakeSorted2.class);

    public static void main(String[] args) {
        testNo768_MaxChunksToMakeSorted2();
    }

    private static void testNo768_MaxChunksToMakeSorted2() {
        No768_MaxChunksToMakeSorted2 No768_MaxChunksToMakeSorted2 = new No768_MaxChunksToMakeSorted2();
        MyLogger.info("result 1 v.s. " + No768_MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
        MyLogger.info("result 4 v.s. " + No768_MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        MyLogger.info("result 3 v.s. " + No768_MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{1, 0, 1, 3, 2}));
        MyLogger.info("result 2 v.s. " + No768_MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
    }

    /**
     * @param arr an array of Integer
     * @return an integer
     */
    public int maxChunksToSorted(int[] arr) {
        // filter abnormal cases
        if (arr == null || arr.length == 0) {
            return 1;
        }

        // core logic
        int max = arr[0];
        int cutCounter = 1;
        int[] copy = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copy);
//        System.out.println(Arrays.toString(copy));
//        System.out.println(Arrays.toString(arr));
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length - 1; i++) {
//            System.out.println("i = " + i);
//            System.out.println("map = " + map);
            if (stepAndIsEmpty(copy[i], arr[i], map)) {
//                System.out.println("Got a cut! i = " + i);
//                System.out.println("copy[i] = " + copy[i]);
//                System.out.println("arr[i] = " + arr[i]);
                cutCounter++;
            }
        }

        // return the final result
        return cutCounter;
    }

    private boolean stepAndIsEmpty(int keyToAdd, int keyToKill, HashMap<Integer, Integer> map) {
        if (keyToAdd != keyToKill) {
            if (map.containsKey(keyToAdd)) {
                if (map.get(keyToAdd) + 1 == 0) {
                    map.remove(keyToAdd);
                } else {
                    map.put(keyToAdd, map.get(keyToAdd) + 1);
                }
            } else {
                map.put(keyToAdd, 1);
            }
            if (map.containsKey(keyToKill)) {
                if (map.get(keyToKill) - 1 == 0) {
                    map.remove(keyToKill);
                } else {
                    map.put(keyToKill, map.get(keyToKill) - 1);
                }
            } else {
                map.put(keyToKill, -1);
            }
        }
        return map.isEmpty();
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
