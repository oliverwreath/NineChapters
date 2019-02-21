package com.ATemplates_DataStructures.Algorithms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Ladder384_LongestSubstringWithoutRepeatingCharacters {
    private static final Logger logger = LoggerFactory.getLogger(Ladder384_LongestSubstringWithoutRepeatingCharacters.class);

    public static void main(String[] args) {
        testLadder384_LongestSubstringWithoutRepeatingCharacters();
    }

    private static void testLadder384_LongestSubstringWithoutRepeatingCharacters() {
        Ladder384_LongestSubstringWithoutRepeatingCharacters Ladder384_LongestSubstringWithoutRepeatingCharacters = new Ladder384_LongestSubstringWithoutRepeatingCharacters();
//        MyLogger.info("result 1 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("aaaa"));
//        MyLogger.info("result 3 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
        MyLogger.info("result 9 v.s. " + Ladder384_LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("gehmbfqmozbpripibusbezagafqtypz"));
    }

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if (s == null || s.length() < 1) {
            return 0;
        }

        int start = 0;
        int len = s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int end = 0; end < len; end++) {
            if (hashMap.containsKey(s.charAt(end))) {
                int newStart = hashMap.get(s.charAt(end)) + 1;
                for (int i = start; i < newStart; i++) {
                    hashMap.remove(s.charAt(i));
                }
                start = newStart;
            }
//            System.out.println("end, start = " + end + ", " + start);
//            System.out.println("hashMap = " + hashMap);
            hashMap.put(s.charAt(end), end);
//            System.out.println("hashMap = " + hashMap);

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
