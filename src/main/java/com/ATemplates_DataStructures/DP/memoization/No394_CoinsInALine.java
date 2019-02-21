package com.ATemplates_DataStructures.DP.memoization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class No394_CoinsInALine {
    private static final Logger logger = LoggerFactory.getLogger(No394_CoinsInALine.class);

    public static void main(String[] args) {
        No394_CoinsInALine No394_CoinsInALine = new No394_CoinsInALine();
        No394_CoinsInALine.testNo394_CoinsInALine();
    }

    private void testNo394_CoinsInALine() {
        MyLogger.info("result false v.s. " + firstWillWin(0));
        MyLogger.info("result true v.s. " + firstWillWin(1));
        MyLogger.info("result true v.s. " + firstWillWin(2));
        MyLogger.info("result false v.s. " + firstWillWin(3));
        MyLogger.info("result true v.s. " + firstWillWin(4));
        MyLogger.info("result true v.s. " + firstWillWin(5));
        MyLogger.info("result true v.s. " + firstWillWin(9999));
    }

    boolean firstWillWin(int n) {
        // filter abnormal cases
        if (n <= 0) {
            return false;
        }

        map.clear();
        map.put(0, false);
        map.put(1, true);
        map.put(2, true);
        map.put(3, false);
        return helper(n);
    }

    HashMap<Integer, Boolean> map = new HashMap<>();

    boolean helper(int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean answer = helper(key - 2) && helper(key - 3) || (helper(key - 3) && helper(key - 4));

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
