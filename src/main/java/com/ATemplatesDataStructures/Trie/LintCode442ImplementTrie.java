package com.ATemplatesDataStructures.Trie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LintCode442ImplementTrie {

  public class Trie {

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

      TrieNode node = find(word, 0);
      return node != null && node.isWord;
    }

    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {

      TrieNode node = find(prefix, 0);
      return node != null;
    }
  }
}
