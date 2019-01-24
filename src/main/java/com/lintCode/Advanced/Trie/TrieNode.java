package com.lintCode.Advanced.Trie;

/**
 * Created by yanli on 2016-10-01.
 */

import java.util.HashMap;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
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

