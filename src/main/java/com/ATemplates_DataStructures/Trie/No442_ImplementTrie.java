package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No442_ImplementTrie {
    private final static Logger logger = LoggerFactory.getLogger(No442_ImplementTrie.class);

    public static void main(String[] args) {
        No442_ImplementTrie No442_ImplementTrie = new No442_ImplementTrie();
        No442_ImplementTrie.testNo442_ImplementTrie();
    }

    private void testNo442_ImplementTrie() {
        Trie trie = new Trie();
        trie.insert("lintcode");
        MyLogger.info("result false v.s. " + trie.search("code"));
        MyLogger.info("result true v.s. " + trie.startsWith("lint"));
        MyLogger.info("result false v.s. " + trie.startsWith("linterror"));
        trie.insert("linterror");
        MyLogger.info("result true v.s. " + trie.search("lintcode"));
        MyLogger.info("result true v.s. " + trie.startsWith("linterror"));
    }

    class Trie {
        class TrieNode {
            TrieNode[] next;
            boolean isWord;

            public TrieNode() {
                this.next = new TrieNode[26];
                this.isWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            // do intialization if necessary
            root = new TrieNode();
        }

        /*
         * @param word: a word
         * @return: nothing
         */
        public void insert(String word) {
            // write your code here
            if (word == null || word.length() == 0) {
                return;
            }

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.next[pos] == null) {
                    node.next[pos] = new TrieNode();
                }
                node = node.next[pos];
            }
            node.isWord = true;
        }

        public TrieNode find(String word, int index) {
            if (word == null || word.length() == 0) {
                return root;
            }

            return find(word, index, root);
        }

        public TrieNode find(String word, int index, TrieNode node) {
            if (index == word.length()) {
                return node;
            }

            int pos = word.charAt(index) - 'a';
            if (node.next[pos] == null) {
                return null;
            } else {
                return find(word, index + 1, node.next[pos]);
            }
        }

        /*
         * @param word: A string
         * @return: if the word is in the trie.
         */
        public boolean search(String word) {
            // write your code here
            TrieNode node = find(word, 0);
            return node != null && node.isWord;
        }

        /*
         * @param prefix: A string
         * @return: if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            // write your code here
            TrieNode node = find(prefix, 0);
            return node != null;
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
