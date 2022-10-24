package com.ATemplatesDataStructures.Trie;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No559_TrieService {

  public static void main(String[] args) {
    No559_TrieService No559_TrieService = new No559_TrieService();
    No559_TrieService.testNo559_TrieService();
  }

  private void testNo559_TrieService() {
    TrieService trieService = new TrieService();
    trieService.insert("abc", 2);
    trieService.insert("ac", 4);
    trieService.insert("ab", 9);
  }

  public class TrieNode {

    public NavigableMap<Character, TrieNode> children;
    public List<Integer> top10;

    public TrieNode() {
      children = new TreeMap<>();
      top10 = new ArrayList<>();
    }
  }

  public class TrieService {

    private TrieNode root;

    public TrieService() {
      root = new TrieNode();
    }

    public TrieNode getRoot() {
      // Return root of trie root, and
      // lintcode will print the tree struct.
      return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
      // Write your cod here
      if (word == null || word.length() == 0) {
        return;
      }

      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        if (!node.children.containsKey(word.charAt(i))) {
          node.children.put(word.charAt(i), new TrieNode());
        }
        node = node.children.get(word.charAt(i));
        int index = 0;
        for (int a : node.top10) {
          if (frequency >= a) {
            break;
          }
          index++;
        }
        node.top10.add(index, frequency);
        if (node.top10.size() == 10) {
          node.top10.remove(node.top10.size() - 1);
        }
      }
    }
  }

}
