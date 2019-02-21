package com.LeetCode.Weekly7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-01.
 */
public class MinimumUniqueWordAbbreviation_411 {
    private static final Logger logger = LoggerFactory.getLogger(MinimumUniqueWordAbbreviation_411.class);

    public static void main(String[] arg) {
        testMinimumUniqueWordAbbreviation_411();
    }

    private static void testMinimumUniqueWordAbbreviation_411() {
        List<String> dict = new LinkedList<String>();
        dict.add("blade");
        logger.info("{}", minAbbreviation("apple", dict));
        dict.add("plain");
        dict.add("amber");
        logger.info("{}", minAbbreviation("apple", dict));
    }

    static String minAbbreviation(String target, List<String> dictionary) {
        if (target == null || target.length() == 0) {
            return target;
        }
        if (target.length() == 1) {
            return target;
        }
        if (dictionary.size() == 0) {
            return String.valueOf(target.length());
        }

        int n = target.length();
        boolean canFullNumber = true;
        Trie trie = new Trie();
        Trie reverseTrie = new Trie();
        for (String dict : dictionary) {
            if (dict.length() == n) {
                canFullNumber = false;
                trie.insert(dict);
                reverseTrie.insert(reverse(dict));
            }
        }
        if (canFullNumber) {
            return String.valueOf(target.length());
        }
        String smallestAbr = getSmallestAbr(target, reverse(target), trie, reverseTrie);

        return smallestAbr;
    }

    static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    static String getSmallestAbr(String target, String reverseTarget, Trie trie, Trie reverseTrie) {
//        System.out.println("getSmallestAbr() begin");
//        System.out.println("target = " + target + "; reverseTarget= " + reverseTarget);
//        System.out.println("trie = " + trie);
//        System.out.println("reverseTrie = " + reverseTrie);
        int n = target.length();
        boolean can = true;
        for (int i = 1; i < n - 1; i++) {
            if (!trie.startsWith(target.substring(0, i))) {
//                System.out.println("hit");
                return target.substring(0, i) + String.valueOf(n - i);
            }
            if (!reverseTrie.startsWith(reverseTarget.substring(0, i))) {
//                System.out.println("hit");
                return String.valueOf(n - i) + target.substring(n - i, n);
            }
        }

//        System.out.println("NOT hit");
        return target;
    }

    static boolean validWordAbbreviation(String word, String abr) {
        // fitler abnormal inputs
        if (word == null && abr == null) {
            return true;
        }
        if (word == null || abr == null) {
            return false;
        }

        // walk through
        int n = word.length();
        int m = abr.length();
        int i = 0;
        int j = 0;
        for (; j < m; j++) {
            if (i >= n) {
                return false;
            }
//            System.out.println(i + " " + j + "; " + word.charAt(i) + " " + abr.charAt(j));
            char currentAbr = abr.charAt(j);
            if (Character.isDigit(currentAbr)) {
                if (currentAbr == '0') {
                    return false;
                }
                int number = currentAbr - '0';
                while (j + 1 < m && Character.isDigit(abr.charAt(j + 1))) {
                    number *= 10;
                    number += abr.charAt(j + 1) - '0';
                    j++;
                }
                i += number;
            } else {
                if (word.charAt(i) != currentAbr) {
                    return false;
                }
                i++;
            }
        }
//        System.out.println("i = " + i + "; j = " + j + "; n = " + n);
        if (i != n) {
            return false;
        }

        return true;
    }

    static class TrieNode {
        Character s;
        boolean isString;
        HashMap<Character, TrieNode> subtree;

        @Override
        public String toString() {
            return "TrieNode{" +
                    "s=" + s +
                    ", subtree=" + subtree +
                    '}';
        }

        public TrieNode() {
            // TODO Auto-generated constructor stub
            isString = false;
            subtree = new HashMap<Character, TrieNode>();
        }

        public TrieNode(char valChar) {
            this.s = valChar;
            isString = false;
            subtree = new HashMap<Character, TrieNode>();
        }
    }

    static class Trie {
        private TrieNode root;

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            int n = word.length();
            TrieNode current = root;
            for (int i = 0; i < n; i++) {
                char tmpChar = word.charAt(i);
                if (current.subtree.containsKey(tmpChar)) {
                    current = current.subtree.get(tmpChar);
                    continue;
                } else {
                    TrieNode newNode = new TrieNode(tmpChar);
                    current.subtree.put(tmpChar, newNode);
                    current = newNode;
                }
            }
            current.isString = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            int n = word.length();
            TrieNode current = root;
            for (int i = 0; i < n; i++) {
                char tmpChar = word.charAt(i);
                if (current.subtree.containsKey(tmpChar)) {
                    current = current.subtree.get(tmpChar);
                    continue;
                } else {
                    return false;
                }
            }

            return current.isString;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            int n = prefix.length();
            TrieNode current = root;
            for (int i = 0; i < n; i++) {
                char tmpChar = prefix.charAt(i);
                if (current.subtree.containsKey(tmpChar)) {
                    current = current.subtree.get(tmpChar);
                    continue;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
