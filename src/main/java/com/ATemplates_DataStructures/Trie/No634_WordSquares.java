package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class No634_WordSquares {
    private static final Logger logger = LoggerFactory.getLogger(No634_WordSquares.class);

    public static void main(String[] args) {
        No634_WordSquares No634_WordSquares = new No634_WordSquares();
        No634_WordSquares.testNo634_WordSquares();
    }

    private void testNo634_WordSquares() {
        MyLogger.info("result [[\"wall\",\"area\",\"lead\",\"lady\"],[\"ball\",\"area\",\"lead\",\"lady\"]] v.s. " + wordSquares(new String[]{"area", "lead", "wall", "lady", "ball"}));
    }

    class TrieNode {
        TrieNode[] next;
        List<String> startsWith;

        public TrieNode() {
            this.next = new TrieNode[26];
            startsWith = new ArrayList<>();
        }
    }

    class Trie {
        TrieNode root;

        Trie(String[] words) {
            this.root = new TrieNode();
            for (String word : words) {
                if (word == null || word.length() == 0) {
                    continue;
                }
                TrieNode node = root;
                for (int i = 0; i < word.length(); i++) {
                    int pos = word.charAt(i) - 'a';
                    if (node.next[pos] == null) {
                        node.next[pos] = new TrieNode();
                    }
                    node = node.next[pos];
                    node.startsWith.add(word);
                }
            }
        }

        List<String> findByPrefix(String prefix) {
            List<String> answer = new ArrayList<>();
            TrieNode node = root;
            for (int i = 0; i < prefix.length(); i++) {
                int pos = prefix.charAt(i) - 'a';
                if (node.next[pos] == null) {
                    return answer;
                }
                node = node.next[pos];
            }
            answer.addAll(node.startsWith);
            return answer;
        }
    }

    List<List<String>> wordSquares(String[] words) {
        // filter abnormal cases
        this.answer = new ArrayList<>();
        if (words == null || words.length == 0) {
            return answer;
        }

        this.targetLength = words[0].length();
        List<String> ansBuilder = new ArrayList<>();
        this.trie = new Trie(words);
        for (String word : words) {
            ansBuilder.add(word);
            dfs(ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
        }

        // return the final result
        return answer;
    }

    List<List<String>> answer;
    int targetLength;
    Trie trie;

    private void dfs(List<String> ansBuilder) {
        if (ansBuilder.size() == targetLength) {
            answer.add(new ArrayList<>(ansBuilder));
            return;
        }

        int pos = ansBuilder.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : ansBuilder) {
            prefixBuilder.append(s.charAt(pos));
        }
        List<String> candidates = trie.findByPrefix(prefixBuilder.toString());
        for (String candidate : candidates) {
            ansBuilder.add(candidate);
            dfs(ansBuilder);
            ansBuilder.remove(ansBuilder.size() - 1);
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
