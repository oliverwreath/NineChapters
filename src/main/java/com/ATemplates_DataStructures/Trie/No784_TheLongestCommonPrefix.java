package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class No784_TheLongestCommonPrefix {
    private static final Logger logger = LoggerFactory.getLogger(No784_TheLongestCommonPrefix.class);

    public static void main(String[] args) {
        testNo784_TheLongestCommonPrefix();
    }

    private static void testNo784_TheLongestCommonPrefix() {
        No784_TheLongestCommonPrefix No784_TheLongestCommonPrefix = new No784_TheLongestCommonPrefix();
        List<String> list = new LinkedList<>();
        list.add("abcba");
        list.add("acc");
        list.add("abwsf");
        MyLogger.info("result 2 v.s. " + No784_TheLongestCommonPrefix.theLongestCommonPrefix(list, "abse"));
        list.clear();
        list.add("aaa");
        list.add("bbb");
        list.add("aabb");
        MyLogger.info("result 3 v.s. " + No784_TheLongestCommonPrefix.theLongestCommonPrefix(list, "aaab"));
    }

    /**
     * @param dic
     * @param target
     * @return
     */
    public int theLongestCommonPrefix(List<String> dic, String target) {
        // write your code here
        // filter abnormal cases
        if (dic == null || dic.size() == 0) {
            return 0;
        }

        Trie trie = new Trie();
        for (String s : dic) {
            trie.insert(s);
        }

        int answer = 0;
        for (int i = 1; i < target.length(); i++) {
            if (trie.startsWith(target.substring(0, i))) {
                answer++;
            }
        }

        // return the final result
        return answer;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public Trie(TrieNode TrieNode) {
            root = TrieNode;
        }

        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    now.subtree.put(s.charAt(i), new TrieNode());
                }
                now = now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isString = true;
            now.times = 1;
        }

        public void insert(String s, int times) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    now.subtree.put(s.charAt(i), new TrieNode());
                }
                now = now.subtree.get(s.charAt(i));
            }
            now.s = s;
            now.isString = true;
            now.times = times;
        }

        public boolean search(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                if (!now.subtree.containsKey(s.charAt(i))) {
                    return false;
                }
                now = now.subtree.get(s.charAt(i));
            }
            return now.isString;
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

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }

    class TrieNode {
        String s;
        boolean isString;
        int times;
        HashMap<Character, TrieNode> subtree;

        public TrieNode() {
            // TODO Auto-generated constructor stub
            isString = false;
            subtree = new HashMap<>();
            s = "";
            times = 0;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "s='" + s + '\'' +
                    ", isString=" + isString +
                    ", subtree=" + subtree +
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
