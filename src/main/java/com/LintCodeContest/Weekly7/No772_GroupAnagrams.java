package com.LintCodeContest.Weekly7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No772_GroupAnagrams {
    private static final Logger logger = LoggerFactory.getLogger(No772_GroupAnagrams.class);

    public static void main(String[] args) {
        No772_GroupAnagrams No772_GroupAnagrams = new No772_GroupAnagrams();
        No772_GroupAnagrams.testNo772_GroupAnagrams();
    }

    private void testNo772_GroupAnagrams() {
        MyLogger.info("result [\n" +
                "    [\"ate\", \"eat\",\"tea\"],\n" +
                "    [\"nat\",\"tan\"],\n" +
                "    [\"bat\"]\n" +
                "] v.s. \n" + groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    List<List<String>> groupAnagrams(String[] A) {
        ArrayList<List<String>> answer = new ArrayList<>();
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return answer;
        }
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (String string : A) {
            HashMap<Character, Integer> mm = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                char key = string.charAt(i);
                if (mm.containsKey(key)) {
                    mm.put(key, mm.get(key) + 1);
                } else {
                    mm.put(key, 1);
                }
            }
            if (!map.containsKey(mm)) {
                map.put(mm, new LinkedList<>());
            }
            map.get(mm).add(string);
        }

        answer.addAll(map.values());

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
