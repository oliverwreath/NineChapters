package com.leetcode.Weekly74;

import java.util.HashMap;
import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC792NumberOfMatchingSubsequences {

  public static void main(String[] args) {
    LC792NumberOfMatchingSubsequences LC792NumberOfMatchingSubsequences = new LC792NumberOfMatchingSubsequences();
    LC792NumberOfMatchingSubsequences.testNo792_NumberOfMatchingSubsequences();
  }

  private void testNo792_NumberOfMatchingSubsequences() {
    log.info("result 1 v.s. " + numMatchingSubseq("abcde", new String[]{"acd"}));
    log.info("result 3 v.s. " + numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    log.info(
        "result 2 v.s. " + numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"}));
    log.info("result 1 v.s. " + numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau"}));
    log.info("result 1 v.s. " + numMatchingSubseq("dsahjpjauf", new String[]{"ja"}));
    log.info("result 2 v.s. " + numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja"}));
    log.info("result 2 v.s. " + numMatchingSubseq("qlhxagxdqh",
        new String[]{"qlhxagxdq", "qlhxagxdq", "lhyiftwtut", "yfzwraahab"}));
  }

  class TrieNode {

    TrieNode[] next;
    boolean isWord;
    String s;

    public TrieNode() {
      this.next = new TrieNode[26];
      this.isWord = false;
      this.s = "";
    }

    @Override
    public String toString() {
      return "TrieNode{" +
          "isWord=" + isWord +
          ", s='" + s + '\'' +
          '}';
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
      node.s = word;
    }

    public TrieNode find(String word) {
      if (word == null || word.length() == 0) {
        return root;
      }

      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        int pos = word.charAt(i) - 'a';
        if (node.next[pos] == null) {
          return null;
        } else {
          node = node.next[pos];
        }
      }
      return node;
    }

    public boolean startsWith(String prefix) {
      TrieNode node = find(prefix);
      return node != null;
    }

    public boolean startsWith(char ch) {
      return startsWith(String.valueOf(ch));
    }

//        public boolean search(String word) {
//            TrieNode node = find(word);
//            return node != null && node.isWord;
//        }

    @Override
    public String toString() {
      return "Trie{" +
          "root=" + root +
          '}';
    }
  }

  int numMatchingSubseq(String S, String[] words) {
    if (words == null || words.length == 0) {
      return 0;
    }

    countMap = new HashMap<>();
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
      if (!countMap.containsKey(word)) {
        countMap.put(word, 1);
      } else {
        countMap.put(word, countMap.get(word) + 1);
      }
    }

    this.answerCount = 0;
//        StringBuilder stringBuilder = new StringBuilder();
    this.S = S;
    this.answer = new HashSet<>();
    dfs(0, trie.root);
    for (String key : answer) {
      answerCount += countMap.get(key);
    }

    return answerCount;
  }

  HashMap<String, Integer> countMap;
  int answerCount;
  String S;
  HashSet<String> answer;

  public void dfs(int index, TrieNode node) {
    if (index == S.length()) {
      if (node.isWord) {
//            answerCount++;
        answer.add(node.s);
      }
      return;
    }

    int pos = S.charAt(index) - 'a';
    if (node.next[pos] != null) {
      dfs(index + 1, node.next[pos]);
    }
    dfs(index + 1, node);
  }

//    int numMatchingSubseq(String S, String[] words) {
//        // filter abnormal cases
//        if (words == null || words.length == 0) {
//            return 0;
//        }
//
//        HashMap<Character, List<Integer>> map = new HashMap<>();
//        for (int i = 0; i < S.length(); i++) {
//            char key = S.charAt(i);
//            if (!map.containsKey(key)) {
//                map.put(key, new ArrayList<>());
//            }
//            map.get(key).add(i);
//        }
////        log.debug(map);
//
//        int answerCount = 0;
//        HashMap<Character, List<Integer>> tmpMap = null;
//        for (String word : words) {
//            boolean isMatch = true;
////            HashMap<Character, List<Integer>> tmpMap  = map.entrySet().stream()
////                    .collect(Collectors.toMap(e -> e.getKey(), e -> new ArrayList(e.getValue()));
//            if (tmpMap == null) {
//                tmpMap = new HashMap<>();
//            } else {
//                for (Character key : tmpMap.keySet()) {
//                    map.get(key).addAll(tmpMap.get(key));
//                }
//                tmpMap.clear();
//            }
////            log.debug("\nmap = " + map);
//
//            int beginning = -1;
//            for (int i = 0; i < word.length(); i++) {
//                int min = Integer.MAX_VALUE;
//                if (map.containsKey(word.charAt(i))) {
//                    for (Integer index : map.get(word.charAt(i))) {
//                        if (index > beginning && index < min) {
//                            min = index;
//                        }
//                    }
//                    if (min != Integer.MAX_VALUE && min > beginning) {
////                        log.debug("word.charAt(i) = " + word.charAt(i) + "; min = " + min);
//                        beginning = min;
//                        if (!tmpMap.containsKey(word.charAt(i))) {
//                            tmpMap.put(word.charAt(i), new ArrayList<>());
//                        }
//                        tmpMap.get(word.charAt(i)).add(min);
//                        map.get(word.charAt(i)).remove(new Integer(min));
//                    } else {
//                        isMatch = false;
//                        break;
//                    }
//                } else {
//                    isMatch = false;
//                    break;
//                }
//            }
////            log.debug(word + "; isMatch = " + isMatch);
//            if (isMatch) {
//                answerCount++;
//            }
//        }
//
//        // return the final result
//        return answerCount;
//    }

}
