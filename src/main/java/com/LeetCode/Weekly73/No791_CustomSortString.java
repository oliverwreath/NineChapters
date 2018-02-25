package com.LeetCode.Weekly73;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No791_CustomSortString {
    private final static Logger logger = LoggerFactory.getLogger(No791_CustomSortString.class);

    public static void main(String[] args) {
        No791_CustomSortString No791_CustomSortString = new No791_CustomSortString();
        No791_CustomSortString.testNo791_CustomSortString();
    }

    private void testNo791_CustomSortString() {
        MyLogger.info("result \"cabd\" v.s. " + customSortString("cab", "abcd"));
//        MyLogger.info("result \"cbad\" v.s. " + customSortString("cba", "abcd"));
    }

    String customSortString(String S, String T) {
        // filter abnormal cases
        if (T == null || T.length() == 0) {
            return T;
        }
        if (S == null || S.length() == 0) {
            return T;
        }

        map = new int[27];
        sequence = new int[27];
        for (int i = 0; i < 27; i++) {
            map[i] = -1;
            sequence[i] = -1;
        }
        for (int index = 0; index < S.length(); index++) {
            map[S.charAt(index) - 'a'] = index;
            sequence[index] = S.charAt(index) - 'a';
        }

        count = new int[27];
        for (int i = 0; i < T.length(); i++) {
            count[T.charAt(i) - 'a']++;
        }
//        System.out.println("map = " + Arrays.toString(map));
//        System.out.println("sequence = " + Arrays.toString(sequence));
//        System.out.println("count = " + Arrays.toString(count));
//        System.out.println("Sorted T = " + T);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < T.length() && sequence[i] != -1; i++) {
            int index = sequence[i];
            char currentChar = (char) (index + 'a');
//            System.out.println("index = " + index + "; currentChar = " + currentChar);
            for (int times = 0; times < count[index]; times++) {
                stringBuilder.append(currentChar);
            }
            count[index] = 0;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < count[i]; j++) {
                    stringBuilder.append((char) (i + 'a'));
                }
            }
        }
//        System.out.println("count = " + Arrays.toString(count));


        // return the final result
        return stringBuilder.toString();
    }

    int[] map;
    int[] sequence;
    int[] count;

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
