package com.ATemplatesDataStructures.Trie;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No123_WordSearch {

  public static void main(String[] args) {
    No123_WordSearch No123_WordSearch = new No123_WordSearch();
    No123_WordSearch.testNo123_WordSearch();
  }

  private void testNo123_WordSearch() {
//        log.info("result true v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCCED"));
//        log.info("result true v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "SEE"));
//        log.info("result false v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCB"));
    log.info("result true v.s. " + exist(new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'E', 'S'},
        {'A', 'D', 'E', 'E'}
    }, "ABCESEEEFS"));
  }

  boolean exist(char[][] board, String word) {
    // filter abnormal cases
    if (word == null || word.length() == 0) {
      return true;
    }
    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return false;
    }

    this.word = word;
    this.board = board;
    this.m = board.length;
    this.n = board[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] == word.charAt(0)) {
          boolean isMatch = dfs(i, j, 0);
          if (isMatch) {
//                        log.debug("isMatch: " + i + ", " + j);
            return true;
          }
        }
      }
    }

    // return the final result
    return false;
  }

  String word;
  char[][] board;
  int m;
  int n;

  private boolean dfs(int i, int j, int start) {
    if (start > word.length() - 1) {
      return true;
    }
    if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != word.charAt(start)) {
      return false;
    }

    board[i][j] = '#';
    boolean answer = dfs(i - 1, j, start + 1)
        || dfs(i + 1, j, start + 1)
        || dfs(i, j - 1, start + 1)
        || dfs(i, j + 1, start + 1);
    board[i][j] = word.charAt(start);
    return answer;
  }

}
