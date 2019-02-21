package com.ATemplates_DataStructures.DP.memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class No395_CoinsInALineII {
    private static final Logger logger = LoggerFactory.getLogger(No395_CoinsInALineII.class);

    public static void main(String[] args) {
        No395_CoinsInALineII No394_CoinsInALine = new No395_CoinsInALineII();
        No394_CoinsInALine.testNo394_CoinsInALine();
    }

    private void testNo394_CoinsInALine() {
        MyLogger.info("result false v.s. " + firstWillWin(new int[]{}));
        MyLogger.info("result true v.s. " + firstWillWin(new int[]{1, 2, 2}));
        MyLogger.info("result false v.s. " + firstWillWin(new int[]{1, 2, 4}));
        MyLogger.info("result false v.s. " + firstWillWin(new int[]{100, 200, 400, 300, 400, 800, 500, 600, 1200}));
    }

    boolean firstWillWin(int[] values) {
        // filter abnormal cases
        if (values == null || values.length <= 0) {
            return false;
        }
        if (values.length <= 2) {
            return true;
        }

        int len = values.length - 1;
        map.clear();
        map.put(-1, 0);
        map.put(0, values[len]);
        map.put(1, values[len] + values[len - 1]);
        map.put(2, values[len - 1] + values[len - 2]);
        boolean answer = helper(len, values) > Math.min(helper(len - 1, values), helper(len - 2, values));
        System.out.println(map);
        return answer;
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    int helper(int key, int[] values) {
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int answer = Math.max(values[values.length - 1 - key] + Math.min(helper(key - 2, values), helper(key - 3, values)),
                values[values.length - 1 - key] + values[values.length - 1 - key + 1] + Math.min(helper(key - 3, values), helper(key - 4, values)));
        map.put(key, answer);
        return answer;
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
