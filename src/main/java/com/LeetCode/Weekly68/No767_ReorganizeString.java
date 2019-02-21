package com.LeetCode.Weekly68;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class No767_ReorganizeString {
    private static final Logger logger = LoggerFactory.getLogger(No767_ReorganizeString.class);

    public static void main(String[] args) {
        testNo767_ReorganizeString();
    }

    private static void testNo767_ReorganizeString() {
        No767_ReorganizeString No767_ReorganizeString = new No767_ReorganizeString();
        MyLogger.info("result aba v.s. " + No767_ReorganizeString.reorganizeString("aab"));
        MyLogger.info("result \"\" v.s. " + No767_ReorganizeString.reorganizeString("aaab"));
    }

    /**
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        // filter abnormal cases
        if (S == null || S.length() < 2) {
            return S;
        }

        int len = S.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char oneChar = S.charAt(i);
            if (map.containsKey(oneChar)) {
                map.put(oneChar, map.get(oneChar) + 1);
            } else {
                map.put(oneChar, 1);
            }
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);
        for (Character character : map.keySet()) {
            pq.add(new Entry(character, map.get(character)));
        }
        if (pq.size() < 2) {
            return "";
        }
//        FirstSecondMaxPQ firstSecondMaxPQ = new FirstSecondMaxPQ(pq);

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                // high frequency
//                resultBuilder.append(firstSecondMaxPQ.getFirst());
            } else {
                // low frequency
//                resultBuilder.append(firstSecondMaxPQ.getSecond());
            }
        }
//        int max = Integer.MIN_VALUE;
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            max = Math.max(max, entry.getValue());
//        }
//        if (max > S.length() / 2) {
//            return "";
//        }

        // return the final result
        return resultBuilder.toString();
    }

    private class Entry {
        Character character;
        int frequency;

        public Entry(Character character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "character=" + character +
                    ", frequency=" + frequency +
                    '}';
        }
    }

//    private class FirstSecondMaxPQ {
//        PriorityQueue<Entry> pq;
//        Entry first;
//        Entry second;
//
//        public FirstSecondMaxPQ(PriorityQueue<Entry> pq) {
//            this.pq = pq;
//            this.first = pq.poll();
//            this.second = pq.poll();
//        }
//
//        boolean isFirstEmpty() {
//            if (first.frequency > 0) {
//                return false;
//            } else if (second.frequency > 0) {
//                first = second;
//                second =
//            } else if (pq.isEmpty()){
//                return true;
//            }
//        }
//
//        char getFirst() {
//            if (this.first.frequency < 1) {
//                if (this.second.frequency < 1) {
//                    this.first = pq.poll();
//                } else {
//                    this.first = second;
//                    this.second = pq.poll();
//                }
//            }
//            first[1]--;
//            return (char) first[0];
//        }
//
//        char getSecond() {
//            if (this.second.frequency < 1) {
//                if (pq.isEmpty()) {
//
//                } else {
//                    this.second = pq.poll();
//                }
//            }
//            second.frequency--;
//            return (char) second[0];
//        }
//
//        @Override
//        public String toString() {
//            return "FirstSecondMaxPQ{" +
//                    "pq=" + pq +
//                    ", first=" + Arrays.toString(first) +
//                    ", second=" + Arrays.toString(second) +
//                    '}';
//        }
//    }

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
