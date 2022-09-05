package com.ATemplatesDataStructures.Trie;

/**
 * Author: Oliver
 */
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
