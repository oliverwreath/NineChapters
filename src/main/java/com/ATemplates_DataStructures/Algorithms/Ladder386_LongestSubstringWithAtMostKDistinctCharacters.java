package com.ATemplates_DataStructures.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Ladder386_LongestSubstringWithAtMostKDistinctCharacters {
    private final static Logger logger = LoggerFactory.getLogger(Ladder386_LongestSubstringWithAtMostKDistinctCharacters.class);

    public static void main(String[] args) {
        testLadder386_LongestSubstringWithAtMostKDistinctCharacters();
    }

    private static void testLadder386_LongestSubstringWithAtMostKDistinctCharacters() {
        Ladder386_LongestSubstringWithAtMostKDistinctCharacters Ladder386_LongestSubstringWithAtMostKDistinctCharacters = new Ladder386_LongestSubstringWithAtMostKDistinctCharacters();
//        MyLogger.info("result 4 v.s. " + Ladder386_LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("eceba", 3));
        MyLogger.info("result 0 v.s. " + Ladder386_LongestSubstringWithAtMostKDistinctCharacters.lengthOfLongestSubstringKDistinct("onykowalsrolughyufhxigqkwalvfo", 0));
    }

    /**
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if (s == null || s.length() < 1 || k < 1) {
            return 0;
        }

        int start = 0;
        int len = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < len; end++) {
            if (hashMap.size() == k && !hashMap.containsKey(s.charAt(end))) {
                // find the smallest value in map
                int min = Integer.MAX_VALUE;
                for (int value : hashMap.values()) {
                    min = Math.min(min, value);
                }
                // remove
//                System.out.println("hashMap = " + hashMap);
//                System.out.println("start, min = " + start + ", " + min);
                hashMap.remove(s.charAt(min));
                // start
                start = min + 1;
            }
            hashMap.put(s.charAt(end), end);

            max = Math.max(max, end - start + 1);
        }

        return max;
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
