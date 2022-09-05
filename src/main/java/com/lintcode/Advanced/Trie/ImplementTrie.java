package com.lintcode.Advanced.Trie;

/**
 * Author: Oliver
 */

import java.util.HashMap;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class ImplementTrie {
  class TrieNode {
    Character s;
    boolean isString;
    HashMap<Character, TrieNode> subtree;

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
}
