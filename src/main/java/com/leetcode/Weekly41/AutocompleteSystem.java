package com.leetcode.Weekly41;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class AutocompleteSystem {
  public static void main(String[] args) {
    testAutocompleteSystem();
  }

  private static void testAutocompleteSystem() {
    AutocompleteSystem autocompleteSystem = new AutocompleteSystem(new String[]{"i love you", "island", "ironman", "i love leetcode"}, new int[]{5, 3, 2, 2});
    log.info("result 2 = " + autocompleteSystem.input('i'));
    log.info("result 2 = " + autocompleteSystem.input(' '));
    log.info("result 2 = " + autocompleteSystem.input('a'));
    log.info("result 2 = " + autocompleteSystem.input('#'));
  }

  private Trie trie = new Trie();
  private String prefix = "";

  public AutocompleteSystem(String[] sentences, int[] times) {
    int length = sentences.length;
    for (int i = 0; i < length; i++) {
      trie.insert(sentences[i], times[i]);
    }

    log.debug(String.valueOf(trie));
  }

  public List<String> input(char c) {
    prefix += c;
    boolean b = trie.startsWith(prefix);

    return null;
  }

  /**
   * @param A an array of Integer
   * @return an integer
   */
  static int longestIncreasingContinuousSubsequence(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    // return the final result
    return -1;
  }


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
}
