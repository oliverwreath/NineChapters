package com.ATemplatesDataStructures.Trie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode473AddAndSearchWord {

  public class WordDictionary {

    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {

      trie.insert(word);
    }

    /*
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {

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
}
