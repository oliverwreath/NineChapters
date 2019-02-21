package com.LeetCode.Weekly65;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No756_PyramidTransitionMatrix {
    private static final Logger logger = LoggerFactory.getLogger(No756_PyramidTransitionMatrix.class);

    public static void main(String[] args) {
        testNo756_PyramidTransitionMatrix();
    }

    private static void testNo756_PyramidTransitionMatrix() {
        No756_PyramidTransitionMatrix No756_PyramidTransitionMatrix = new No756_PyramidTransitionMatrix();
        MyLogger.info("result 2 v.s. " + No756_PyramidTransitionMatrix.pyramidTransition("XYZ", Arrays.asList("XYD", "YZE", "DEA", "FFF")));
        MyLogger.info("result 1 v.s. " + No756_PyramidTransitionMatrix.pyramidTransition("XXYX", Arrays.asList("XXX", "XXY", "XYX", "XYY", "YXZ")));
    }

    /**
     * @param bottom
     * @param allowed
     * @return
     */
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // filter abnormal inputs
        if (bottom == null || bottom.length() < 2) {
            return true;
        }
        if (allowed == null || allowed.size() < 1) {
            return false;
        }

        // core logic
        HashMap<String, LinkedList<Character>> hashMap = new HashMap<>();

        // preprocess
        for (String s : allowed) {
            String key = s.substring(0, 2);
            if (!hashMap.containsKey(key)) {
                hashMap.put(key, new LinkedList<>());
            }
            hashMap.get(key).add(s.charAt(2));
        }

        int len = bottom.length();
        for (int t = 0; t < len - 1; t++) {
            int currentLen = bottom.length();
            String[] newBottom = new String[currentLen - 1];
            for (int i = 0; i < currentLen - 1; i++) {
                String key = bottom.substring(i, i + 2);
                if (!hashMap.containsKey(key)) {
                    return false;
                } else {
                    LinkedList<Character> characterLinkedList = hashMap.get(key);
                }
            }
        }

        return false;
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
