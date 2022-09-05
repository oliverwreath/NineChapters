package com.lintcode.Advanced.Trie;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class WordSearch {
  public static void main(String[] arg) {
    new WordSearch().testWordSearch();
  }

  private void testWordSearch() {
    log.info("{}", exist(new char[][]{
                    {'d', 'o', 'a', 'f'},
                    {'a', 'g', 'a', 'i'},
                    {'d', 'c', 'a', 'n'}}
            , "gaif"));

    log.info("{}", exist(new char[][]{
                    {'a', 'b', 'c', 'e'},
                    {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}}
            , "abf"));
    log.info("{}", exist(new char[][]{
                    {'a', 'b', 'c', 'e'},
                    {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}}
            , "abfb"));

    log.info("{}", exist(new char[][]{
                    {'a', 'b', 'c', 'e'},
                    {'s', 'f', 'c', 's'},
                    {'a', 'd', 'e', 'e'}}
            , "sfd"));
  }

  /**
   * @param board: A list of lists of character
   * @param word:  A string
   * @return: A boolean
   */
  public boolean exist(char[][] board, String word) {

    // handle extreme inputs
    if (word == null || word.length() == 0) {
      return true;
    }
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return false;
    }

    // build trie
    int n = board.length;
    int m = board[0].length;
    Trie trie = new Trie();
    trie.insert(word);

    // dfs
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (search(board, trie.root, i, j, n, m)) {
          return true;
        }
      }
    }

    // return false if Nothing found
    return false;
  }

  private boolean valide(int i, int j, int n, int m) {
    return i >= 0 && i < n && j >= 0 && j < m;
  }

  private boolean search(char[][] board, TrieNode root, int i, int j, int n, int m) {
    // got a result?
    if (root.isString) {
      return true;
    }
    // for the children
    if (!valide(i, j, n, m) || root == null) {
      return false;
    }
    if (root.subtree.containsKey(board[i][j])) {
      for (int t = 0; t < 4; t++) {
        int X = i + dx[t];
        int Y = j + dy[t];
        char current = board[i][j];
        board[i][j] = 0;
        boolean isFound = false;
        isFound = isFound || search(board, root.subtree.get(current), X, Y, n, m);
        if (isFound) {
          return true;
        }
        board[i][j] = current;
      }
    }

    return false;
  }

  static int[] dx = new int[]{0, 0, 1, -1};
  static int[] dy = new int[]{1, -1, 0, 0};
}
