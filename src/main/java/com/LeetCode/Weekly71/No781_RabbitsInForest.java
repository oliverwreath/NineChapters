package com.LeetCode.Weekly71;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class No781_RabbitsInForest {
    private static final Logger logger = LoggerFactory.getLogger(No781_RabbitsInForest.class);

    public static void main(String[] args) {
        No781_RabbitsInForest no781_RabbitsInForest = new No781_RabbitsInForest();
        no781_RabbitsInForest.testNo781_RabbitsInForest();
    }

    private void testNo781_RabbitsInForest() {
        MyLogger.info("result 5 v.s. " + numRabbits(new int[]{1, 1, 2}));
        MyLogger.info("result 11 v.s. " + numRabbits(new int[]{10, 10, 10}));
        MyLogger.info("result 0 v.s. " + numRabbits(new int[]{}));
    }

    public int numRabbits(int[] answers) {
        // filter abnormal cases
        if (answers == null || answers.length == 0) {
            return 0;
        }
        if (answers.length == 1) {
            return answers[0] + 1;
        }

        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int key : answers) {
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            int key = integerIntegerEntry.getKey();
            int val = integerIntegerEntry.getValue();
            if (val % (key + 1) == 0) {
                answer += val;
            } else {
                answer += (val / (key + 1) + 1) * (key + 1);
            }
        }

        // return the final result
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
