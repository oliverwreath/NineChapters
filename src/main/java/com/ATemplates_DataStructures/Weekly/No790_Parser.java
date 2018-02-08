package com.ATemplates_DataStructures.Weekly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class No790_Parser {
    private final static Logger logger = LoggerFactory.getLogger(No790_Parser.class);

    public static void main(String[] args) {
        testNo790_Parser();
    }

    private static void testNo790_Parser() {
        No790_Parser No790_Parser = new No790_Parser();
        MyLogger.info("result True v.s. " + No790_Parser.canBeGenerated(new String[]{"S -> abc", "S -> aA", "A -> b", "A -> c"}, 'S', "ac"));
        MyLogger.info("result False v.s. " + No790_Parser.canBeGenerated(new String[]{"S -> abc", "S -> aA", "A -> b", "A -> c"}, 'S', "a"));
    }

    /**
     * @param generator
     * @param startSymbol
     * @param target
     * @return
     */
    public boolean canBeGenerated(String[] generator, char startSymbol, String target) {
        // Write your code here.
        if (generator == null || generator.length == 0) {
            return false;
        }

        HashMap<Character, List<String>> map = new HashMap<>();
        for (String s : generator) {
            int i = s.indexOf("->");
//            System.out.println(s.charAt(i));
//            System.out.println(s.substring(i + 3, s.length()));
            if (!map.containsKey(s.charAt(0))) {
                map.put(s.charAt(0), new LinkedList<>());
            }
            map.get(s.charAt(0)).add(s.substring(i + 3, s.length()));
//            System.out.println("map = " + map);
        }

        boolean hasMore = true;
//        List<Object> answers = new LinkedList<>();
        HashSet<Object> answers = new HashSet<>();
        answers.add(startSymbol);
        HashSet<Object> visited = new HashSet<>();
        while (hasMore) {
            hasMore = false;

            HashSet<Object> tmp = new HashSet<>();
            for (Object answer : answers) {
                if (answer instanceof Character) {
                    if (!visited.contains(answer)) {
                        if (map.containsKey(answer)) {
                            for (String s : map.get(answer)) {
                                if (!answers.contains(s)) {
                                    if (s.equals(target)) {
                                        return true;
                                    }
                                    tmp.add(s);
                                    hasMore = true;
                                }
                            }
                        }
                    }
                } else if (answer instanceof String) {
                    if (!visited.contains(answer)) {
                        for (int i = 0; i < ((String) answer).length(); i++) {
                            if (Character.isUpperCase(((String) answer).charAt(i)) && map.containsKey(((String) answer).charAt(i))) {
                                for (String ss : map.get(((String) answer).charAt(i))) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    if (i > 0) {
                                        stringBuilder.append(((String) answer).substring(0, i));
                                    }
                                    stringBuilder.append(ss);
                                    if (i < ((String) answer).length() - 1) {
                                        stringBuilder.append(((String) answer).substring(i + 1));
                                    }
                                    String s = stringBuilder.toString();
                                    if (!answers.contains(s)) {
                                        if (s.equals(target)) {
                                            return true;
                                        }
                                        tmp.add(s);
                                        hasMore = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            answers.addAll(tmp);
        }
//        System.out.println("map = " + map);
//        System.out.println("answers = " + answers);

        // return the final result
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
