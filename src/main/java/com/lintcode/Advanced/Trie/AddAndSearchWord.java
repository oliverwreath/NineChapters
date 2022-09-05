package com.lintcode.Advanced.Trie;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author: Oliver
 */
@Slf4j
public class AddAndSearchWord {
  public static void main(String[] arg) {
    new AddAndSearchWord().testWordSearchII();
  }

  private void testWordSearchII() {
    ArrayList<String> dict = new ArrayList<String>();
    dict.add("dog");
    dict.add("dad");
    dict.add("dgdg");
    dict.add("can");
    dict.add("again");
    log.info("{}", wordSearchII(new char[][]{
                    {'d', 'o', 'a', 'f'},
                    {'a', 'g', 'a', 'i'},
                    {'d', 'c', 'a', 'n'}}
            , dict));

    dict.clear();
    dict.add("see");
    dict.add("se");
    log.info("{}", wordSearchII(new char[][]{
                    {'a', 'b', 'c', 'e'},
                    {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}}
            , dict));

    dict.clear();
    dict.add("abcb");
    dict.add("ninechapter");
    dict.add("lintcode");
    log.info("{}", wordSearchII(new char[][]{
                    {'a', 'b', 'c', 'e'},
                    {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}}
            , dict));
  }

  /**
   * @param board: A list of lists of character
   * @param words: A list of string
   * @return: A list of string
   */
  public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {

    // handle extreme inputs
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return new ArrayList<String>();
    }

    // build trie
    int n = board.length;
    int m = board[0].length;
    Trie trie = new Trie();
    for (String word : words) {
      trie.insert(word);
    }

    // dfs
    HashSet<String> ans = new HashSet<String>();
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        search(board, trie.root, ans, i, j, n, m);
      }
    }

    // return ans
    return new ArrayList<String>(ans);
  }

  private boolean valide(int i, int j, int n, int m) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private void search(char[][] board, TrieNode root, HashSet<String> ans, int i, int j, int n, int m) {
    // got a result?
    if (root.isString) {
      ans.add(root.s);
    }
    // for the children
    if (!valide(i, j, n, m) || root == null) {
      return;
    }
    if (root.subtree.containsKey(board[i][j])) {
      for (int t = 0; t < 4; t++) {
        int X = i + dx[t];
        int Y = j + dy[t];
        char current = board[i][j];
        board[i][j] = 0;
        search(board, root.subtree.get(current), ans, X, Y, n, m);
        board[i][j] = current;
      }
    }
  }

  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};
}
