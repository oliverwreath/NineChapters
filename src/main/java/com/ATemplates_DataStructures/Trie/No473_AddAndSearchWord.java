package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No473_AddAndSearchWord {
    private final static Logger logger = LoggerFactory.getLogger(No473_AddAndSearchWord.class);

    public static void main(String[] args) {
        No473_AddAndSearchWord No473_AddAndSearchWord = new No473_AddAndSearchWord();
        No473_AddAndSearchWord.testNo473_AddAndSearchWord();
    }

    private void testNo473_AddAndSearchWord() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        MyLogger.info("result false v.s. " + wordDictionary.search("pad"));
        MyLogger.info("result true v.s. " + wordDictionary.search("bad"));
        MyLogger.info("result true v.s. " + wordDictionary.search(".ad"));
//        MyLogger.info("result true v.s. " + wordDictionary.search("b.."));
    }

    public class WordDictionary {
        /*
         * @param word: Adds a word into the data structure.
         * @return: nothing
         */
        public void addWord(String word) {
            // write your code here
            trie.insert(word);
        }

        /*
         * @param word: A word could contain the dot character '.' to represent any one letter.
         * @return: if the word is in the data structure.
         */
        public boolean search(String word) {
            // write your code here
            return trie.search(word);
        }

        Trie trie = new Trie();

        class TrieNode {
            TrieNode[] next;
            boolean isWord;

            public TrieNode() {
                this.next = new TrieNode[26];
                this.isWord = false;
            }
        }

        class Trie {
            TrieNode root;

            public Trie() {
                this.root = new TrieNode();
            }

            public void insert(String word) {
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

            public boolean search(String word) {
                if (word == null || word.length() == 0) {
                    return true;
                }

                return find(word, 0);
            }

            public boolean find(String word, int index) {
                if (word == null || word.length() == 0) {
                    return true;
                }

                return find(word, index, root);
            }

            public boolean find(String word, int index, TrieNode node) {
                if (index == word.length()) {
                    return node != null && node.isWord;
                }
                if (word.charAt(index) == '.') {
                    for (int pos = 0; pos < 26; pos++) {
                        if (node.next[pos] != null && find(word, index + 1, node.next[pos])) {
                            return true;
                        }
                    }
                    return false;
                } else {
                    int pos = word.charAt(index) - 'a';
                    if (node.next[pos] == null) {
                        return false;
                    } else {
                        return find(word, index + 1, node.next[pos]);
                    }
                }
            }
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
