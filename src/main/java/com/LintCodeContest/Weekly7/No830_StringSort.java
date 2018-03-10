package com.LintCodeContest.Weekly7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class No830_StringSort {
    private final static Logger logger = LoggerFactory.getLogger(No830_StringSort.class);

    public static void main(String[] args) {
        No830_StringSort No830_StringSort = new No830_StringSort();
        No830_StringSort.testNo830_StringSort();
    }

    private void testNo830_StringSort() {
        MyLogger.info("result bbooeglmr v.s. " + stringSort("bloomberg"));
        MyLogger.info("result cdeilnot v.s. " + stringSort("lintcode"));
    }

    String stringSort(String S) {
        // filter abnormal cases
        if (S == null || S.length() == 0) {
            return S;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0;
        char frequentChar = 'z';
        for (int i = 0; i < S.length(); i++) {
            char key = S.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            if (map.get(key) > maxFrequency && key <= frequentChar) {
                maxFrequency = map.get(key);
                frequentChar = key;
            }
        }

//        System.out.println("maxFrequency = " + maxFrequency);
//        System.out.println("frequentChar = " + frequentChar);
//        System.out.println(map);
//        for (int i = 0; i < maxFrequency; i++) {
//            answerBuilder.append(frequentChar);
//        }
        List<MyEntry> list = new ArrayList<>(map.keySet().size());
        for (char key : map.keySet()) {
            list.add(new MyEntry(key, map.get(key)));
        }
        list.sort(comparator);
        StringBuilder answerBuilder = new StringBuilder();
        for (MyEntry myEntry : list) {
//            if (myEntry.key == frequentChar) {
//                continue;
//            }
            for (int i = 0; i < map.get(myEntry.key); i++) {
                answerBuilder.append(myEntry.key);
            }
        }

        // return the final result
        return answerBuilder.toString();
    }

    Comparator<MyEntry> comparator = new Comparator<MyEntry>() {
        @Override
        public int compare(MyEntry o1, MyEntry o2) {
            if (o2.frequency != o1.frequency) {
                return o2.frequency - o1.frequency;
            } else {
                return o1.key - o2.key;
            }
        }
    };

    class MyEntry {
        char key;
        int frequency;

        public MyEntry(char key, int frequency) {
            this.key = key;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "MyEntry{" +
                    "key=" + key +
                    ", frequency=" + frequency +
                    '}';
        }
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
