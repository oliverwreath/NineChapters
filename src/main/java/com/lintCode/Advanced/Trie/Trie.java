package com.lintCode.Advanced.Trie;

/**
 * Created by yanli on 2016-10-02.
 */
public class Trie {
    private TrieNode root;

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
