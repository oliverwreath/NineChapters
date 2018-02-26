package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No775_PalindromePairs {
    private final static Logger logger = LoggerFactory.getLogger(No775_PalindromePairs.class);

    public static void main(String[] args) {
        No775_PalindromePairs No775_PalindromePairs = new No775_PalindromePairs();
        No775_PalindromePairs.testNo775_PalindromePairs();
    }

    private void testNo775_PalindromePairs() {
        MyLogger.info("result [[0, 1], [1, 0]] v.s. " + palindromePairs(new String[]{"bat", "tab", "cat"}));
        MyLogger.info("result [[0, 1], [1, 0], [3, 2], [2, 4]]  v.s. " + palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
    }

    List<List<Integer>> palindromePairs(String[] words) {
        // filter abnormal cases
        this.answer = new ArrayList<>();
        if (words == null || words.length == 0) {
            return answer;
        }

        int len = words.length;
        this.words = words;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (j == i) {
                    continue;
                }
                searchAndAddPalidrome(i, j);
            }
        }

        // return the final result
        return answer;
    }

    List<List<Integer>> answer;
    String[] words;

    private void searchAndAddPalidrome(int i, int j) {
        if (words[i].length() == words[j].length()) {
            int left = 0;
            int right = words[j].length() - 1;
            while (0 <= right) {
                if (words[i].charAt(left) != words[j].charAt(right)) {
                    return;
                }
                left++;
                right--;
            }
            this.answer.add(Arrays.asList(i, j));
        } else if (words[i].length() < words[j].length()) {
            int left = 0;
            int right = words[j].length() - 1;
            while (left < words[i].length()) {
                if (words[i].charAt(left) != words[j].charAt(right)) {
                    return;
                }
                left++;
                right--;
            }

            left = 0;
            while (left + 1 < right) {
                if (words[j].charAt(left) != words[j].charAt(right)) {
                    return;
                }
                left++;
                right--;
            }
            if (left != right && words[j].charAt(left) != words[j].charAt(right)) {
                return;
            }
            this.answer.add(Arrays.asList(i, j));
        } else {
            int left = 0;
            int right = words[j].length() - 1;
            while (right >= 0) {
                if (words[i].charAt(left) != words[j].charAt(right)) {
                    return;
                }
                left++;
                right--;
            }

            right = words[i].length() - 1;
            while (left + 1 < right) {
                if (words[i].charAt(left) != words[i].charAt(right)) {
                    return;
                }
                left++;
                right--;
            }
            if (left != right && words[i].charAt(left) != words[i].charAt(right)) {
                return;
            }
            this.answer.add(Arrays.asList(i, j));
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
