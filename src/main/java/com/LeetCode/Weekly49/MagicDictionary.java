package com.LeetCode.Weekly49;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;

public class MagicDictionary {
    private static final Logger logger = LoggerFactory.getLogger(MagicDictionary.class);

    public static void main(String[] args) {
        testMagicDictionary_676();
    }

    private static void testMagicDictionary_676() {
        MagicDictionary magicDict = new MagicDictionary();
        String[] dict = new String[]{"hello", "leetcode"};
        magicDict.buildDict(dict);
        System.out.println("False = " + magicDict.search("hello"));
        System.out.println("True = " + magicDict.search("hhllo"));
        System.out.println("False = " + magicDict.search("hell"));
        System.out.println("False = " + magicDict.search("leetcoded"));
    }

    private HashMap<Integer, LinkedList<String>> myMap = new HashMap<>();

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        myMap.clear();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        // filter abnormal inputs
        if (dict == null || dict.length < 1) {
            return;
        }

        for (String word : dict) {
            int length = word.length();
            if (!myMap.containsKey(length)) {
                myMap.put(length, new LinkedList<>());
            }
            myMap.get(length).add(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        // filter abnormal inputs
        if (word == null) {
            return false;
        }

        int length = word.length();
        if (!myMap.containsKey(length)) {
            return false;
        } else {
            LinkedList<String> strings = myMap.get(length);
            for (String string : strings) {
                boolean oneOff = isOneOff(word, string);
                if (oneOff) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean isOneOff(String word, String string) {
        int counter = 0;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            if (word.charAt(i) != string.charAt(i)) {
                counter++;
                if (counter > 1) {
                    return false;
                }
            }
        }

        return counter == 1;
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
