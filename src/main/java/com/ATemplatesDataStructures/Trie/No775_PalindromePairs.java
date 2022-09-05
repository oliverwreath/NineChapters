package com.ATemplatesDataStructures.Trie;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * damn! screwed up. Revisit is recommended.
 */
@Slf4j
public class No775_PalindromePairs {
  public static void main(String[] args) {
    No775_PalindromePairs No775_PalindromePairs = new No775_PalindromePairs();
    No775_PalindromePairs.testNo775_PalindromePairs();
  }

  private void testNo775_PalindromePairs() {
    Trie trie = new Trie(new String[]{});
//        log.info("result [[0, 1], [1, 0]] v.s. " + trie.isParlindrome("", -1));
    log.info("result true v.s. " + trie.isParlindrome("s", 0));
    log.info("result [[0, 1], [1, 0]] v.s. " + palindromePairs(new String[]{"bat", "tab", "cat"}));
    log.info("result [[0, 1], [1, 0], [3, 2], [2, 4]]  v.s. " + palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}));
  }

  class TrieNode {
    int index;
    TrieNode[] next;

    TrieNode() {
      this.index = -1;
      this.next = new TrieNode[26];
    }
  }

  class Trie {
    TrieNode root;

    Trie(String[] words) {
      root = new TrieNode();
      if (words == null || words.length == 0) {
        return;
      }

      for (int t = 0; t < words.length; t++) {
        TrieNode node = root;
        for (int i = 0; i < words[t].length(); i++) {
          int pos = words[t].charAt(i) - 'a';
          if (node.next[pos] == null) {
            node.next[pos] = new TrieNode();
          }
          node = node.next[pos];
        }
        node.index = t;
      }
    }

    public List<Integer> startsWithReverse(String word) {
      List<Integer> ans = new ArrayList<>();
      if (word == null || word.length() == 0) {
        return ans;
      }

      int k = word.length() - 1;
      TrieNode node = this.root;
      while (k >= 0) {
//                if (node.next[pos] == null) {
//                if (node.index != -1) {
//                    log.debug(word + "; k = " + k);
//                    log.debug("node.index = " + node.index);
//                }
        if (node.index != -1 && isParlindrome(word, k)) {
//                    int left = 0;
//                    int right = k;
//                    while (left + 1 < right) {
//                        if (word.charAt(left) != word.charAt(right)) {
//                            return -1;
//                        }
//                        left++;
//                        right--;
//                    }
//                    if (left != right && word.charAt(left) != word.charAt(right)) {
//                        return -1;
//                    }
//                    return node.index;
          ans.add(node.index);
        }
//                }
        int pos = word.charAt(k) - 'a';
        if (node.next[pos] == null) {
          return ans;
        }
        node = node.next[pos];
        k--;
      }
      if (node.index != -1) {
        ans.add(node.index);
      }
      return new ArrayList<>(ans);
    }

    public boolean isParlindrome(String word, int k) {
      int left = 0;
      int right = k;
      while (left + 1 < right) {
        if (word.charAt(left) != word.charAt(right)) {
          return false;
        }
        left++;
        right--;
      }
      if (left != right && word.charAt(left) != word.charAt(right)) {
        return false;
      }
      return true;
    }
  }

  List<List<Integer>> palindromePairs(String[] words) {
    // filter abnormal cases
    this.answer = new ArrayList<>();
    if (words == null || words.length == 0) {
      return answer;
    }

    int len = words.length;
    Trie trie = new Trie(words);
    for (int i = 0; i < len; i++) {
      List<Integer> js = trie.startsWithReverse(words[i]);
      for (int j : js) {
        if (j != -1 && j != i) {
          if (words[j].length() == 0) {
            answer.add(Arrays.asList(i, j));
          }
          answer.add(Arrays.asList(j, i));
        }
      }
    }

    // return the final result
    return answer;
  }

  List<List<Integer>> answer;

//    List<List<Integer>> palindromePairs(String[] words) {
//        // filter abnormal cases
//        this.answer = new ArrayList<>();
//        if (words == null || words.length == 0) {
//            return answer;
//        }
//
//        int len = words.length;
//        this.words = words;
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < len; j++) {
//                if (j == i) {
//                    continue;
//                }
//                searchAndAddPalidrome(i, j);
//            }
//        }
//
//        // return the final result
//        return answer;
//    }
//
//    List<List<Integer>> answer;
//    String[] words;
//
//    private void searchAndAddPalidrome(int i, int j) {
//        if (words[i].length() == words[j].length()) {
//            int left = 0;
//            int right = words[j].length() - 1;
//            while (0 <= right) {
//                if (words[i].charAt(left) != words[j].charAt(right)) {
//                    return;
//                }
//                left++;
//                right--;
//            }
//            this.answer.add(Arrays.asList(i, j));
//        } else if (words[i].length() < words[j].length()) {
//            int left = 0;
//            int right = words[j].length() - 1;
//            while (left < words[i].length()) {
//                if (words[i].charAt(left) != words[j].charAt(right)) {
//                    return;
//                }
//                left++;
//                right--;
//            }
//
//            left = 0;
//            while (left + 1 < right) {
//                if (words[j].charAt(left) != words[j].charAt(right)) {
//                    return;
//                }
//                left++;
//                right--;
//            }
//            if (left != right && words[j].charAt(left) != words[j].charAt(right)) {
//                return;
//            }
//            this.answer.add(Arrays.asList(i, j));
//        } else {
//            int left = 0;
//            int right = words[j].length() - 1;
//            while (right >= 0) {
//                if (words[i].charAt(left) != words[j].charAt(right)) {
//                    return;
//                }
//                left++;
//                right--;
//            }
//
//            right = words[i].length() - 1;
//            while (left + 1 < right) {
//                if (words[i].charAt(left) != words[i].charAt(right)) {
//                    return;
//                }
//                left++;
//                right--;
//            }
//            if (left != right && words[i].charAt(left) != words[i].charAt(right)) {
//                return;
//            }
//            this.answer.add(Arrays.asList(i, j));
//        }
//    }

}
