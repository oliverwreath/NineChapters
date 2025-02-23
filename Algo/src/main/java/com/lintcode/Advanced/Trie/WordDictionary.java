package com.lintcode.Advanced.Trie;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class WordDictionary {

  private Trie trie;

  public static void main(String[] args) {
    WordDictionary wordDictionary = new WordDictionary();
    wordDictionary.addWord("bad");
    wordDictionary.addWord("dad");
    wordDictionary.addWord("mad");
    log.debug("{}", wordDictionary.search("pad"));  // return false
    log.debug("{}", wordDictionary.search("bad"));  // return true
    log.debug("{}", wordDictionary.search(".ad"));  // return true
    log.debug("{}", wordDictionary.search("b.."));  // return true
    log.debug("{}", wordDictionary.search("."));  // return false
    log.debug("{}", wordDictionary.search("a"));  // return false
    log.debug("{}", wordDictionary.search(""));  // return false
  }

  public WordDictionary() {
    trie = new Trie();
  }

  // Adds a word into the data structure.
  public void addWord(String word) {

    trie.insert(word);
  }

  // Returns if the word is in the data structure. A word could
  // contain the dot character '.' to represent any one letter.
  public boolean search(String word) {

    return search(0, word, this.trie.root);
  }

  public boolean search(int index, String word, TrieNode root) {

    if (word == null) {
      return true;
    }
    int n = word.length();
    if (n == index) {
      return root.isString;
    }
//        log.debug("index = " + index + "; word = " + word);
    char currentChar = word.charAt(index);
    if (currentChar != '.') {
      if (root.subtree.containsKey(currentChar)) {
        return search(index + 1, word, root.subtree.get(currentChar));
      }
    } else {
      boolean isFound = false;
      for (TrieNode trieNode : root.subtree.values()) {
        isFound = isFound || search(index + 1, word, trieNode);
        if (isFound) {
          return true;
        }
      }
    }
    return false;
  }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
