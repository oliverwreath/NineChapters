package com.LeetCode.Weekly63;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class No748_shortestCompletingWord {
    private final static Logger logger = LoggerFactory.getLogger(No748_shortestCompletingWord.class);

    public static void main(String[] args) {
        testNo748_shortestCompletingWord();
    }

    private static void testNo748_shortestCompletingWord() {
        No748_shortestCompletingWord No748_shortestCompletingWord = new No748_shortestCompletingWord();
        MyLogger.info("result steps v.s. " + No748_shortestCompletingWord.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        MyLogger.info("result pest v.s. " + No748_shortestCompletingWord.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    /**
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // filter abnormal inputs
        if (words == null || words.length < 1) {
            return "";
        }
        if (licensePlate == null || licensePlate.length() < 1) {
            Arrays.sort(words);
            return words[0];
        }

        // core logic
        int len = licensePlate.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char currentChar = Character.toLowerCase(licensePlate.charAt(i));
            if (Character.isAlphabetic(currentChar)) {
                if (!hashMap.containsKey(currentChar)) {
                    hashMap.put(currentChar, 1);
                } else {
                    hashMap.put(currentChar, hashMap.get(currentChar) + 1);
                }
            }
        }

        Arrays.sort(words, Comparator.comparingInt(String::length));
        if (hashMap.keySet().isEmpty()) {
            return words[0];
        }
        for (String currentWord : words) {
            int wordLength = currentWord.length();
            MyLogger.debug("currentWord = " + currentWord);
            HashMap<Character, Integer> tmpHashMap = new HashMap<>(hashMap);
            MyLogger.debug("tmpHashMap = " + tmpHashMap);
            for (int i1 = 0; i1 < wordLength; i1++) {
                if (Character.isAlphabetic(currentWord.charAt(i1))) {
                    if (tmpHashMap.containsKey(currentWord.charAt(i1))) {
                        if (tmpHashMap.get(currentWord.charAt(i1)) < 2) {
                            tmpHashMap.remove(currentWord.charAt(i1));
                            if (tmpHashMap.keySet().isEmpty()) {
                                return currentWord;
                            }
                        } else {
                            tmpHashMap.put(currentWord.charAt(i1), tmpHashMap.get(currentWord.charAt(i1)) - 1);
                        }
                    }
                }
                if (tmpHashMap.keySet().isEmpty()) {
                    return currentWord;
                }
            }
        }

        return "";
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
