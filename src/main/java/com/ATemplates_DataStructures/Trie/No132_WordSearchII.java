package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class No132_WordSearchII {
    private final static Logger logger = LoggerFactory.getLogger(No132_WordSearchII.class);

    public static void main(String[] args) {
        No132_WordSearchII No132_WordSearchII = new No132_WordSearchII();
        No132_WordSearchII.testNo132_WordSearchII();
    }

    private void testNo132_WordSearchII() {
        List<String> words = Arrays.asList("dog", "dad", "dgdg", "can", "again");
        MyLogger.info("result {\"dog\", \"dad\", \"can\", \"again\"} v.s. " + wordSearchII(new char[][]{
                {'d', 'o', 'a', 'f'},
                {'a', 'g', 'a', 'i'},
                {'d', 'c', 'a', 'n'}
        }, words));
    }

    class TrieNode {
        TrieNode[] next;
        boolean isWord;
        String s;

        public TrieNode() {
            this.next = new TrieNode[26];
            this.isWord = false;
            this.s = "";
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "isWord=" + isWord +
                    ", s='" + s + '\'' +
                    '}';
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
            node.s = word;
        }

        public TrieNode find(String word) {
            if (word == null || word.length() == 0) {
                return root;
            }

            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                int pos = word.charAt(i) - 'a';
                if (node.next[pos] == null) {
                    return null;
                } else {
                    node = node.next[pos];
                }
            }
            return node;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = find(prefix);
            return node != null;
        }

        public boolean startsWith(char ch) {
            return startsWith(String.valueOf(ch));
        }

//        public boolean search(String word) {
//            TrieNode node = find(word);
//            return node != null && node.isWord;
//        }

        @Override
        public String toString() {
            return "Trie{" +
                    "root=" + root +
                    '}';
        }
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        this.answers = new HashSet<>();
        if (words == null || words.size() == 0) {
            return new ArrayList<>(answers);
        }
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
            return new ArrayList<>(answers);
        }

        this.words = words;
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        System.out.println("trie = " + trie);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (trie.startsWith(board[i][j])) {
                    dfs(i, j, trie.root);
                }
            }
        }

        // return the final result
        return new ArrayList<>(answers);
    }

    HashSet<String> answers;
    List<String> words;
    char[][] board;
    int m;
    int n;
    Trie trie;

    private boolean dfs(int i, int j, TrieNode node) {
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '#') {
            return false;
        }
        int pos = board[i][j] - 'a';
        if (node.next[pos] == null) {
            return false;
        }
        node = node.next[pos];
        if (node.isWord) {
            answers.add(node.s);
        }

        char tmp = board[i][j];
        board[i][j] = '#';
        boolean answer = dfs(i - 1, j, node)
                || dfs(i + 1, j, node)
                || dfs(i, j - 1, node)
                || dfs(i, j + 1, node);
        board[i][j] = tmp;
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
