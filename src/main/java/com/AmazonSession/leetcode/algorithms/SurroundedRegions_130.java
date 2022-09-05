package com.AmazonSession.leetcode.algorithms;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: Oliver
 */
@Slf4j
public class SurroundedRegions_130 {
  public static void main(String[] arg) {
    new SurroundedRegions_130().testSurroundedRegions_130();
  }

  private void testSurroundedRegions_130() {
    char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
    };
    solve(board);
    for (int i = 0; i < 4; i++) {
      log.debug(Arrays.toString(board[i]));
    }
  }

  public void solve(char[][] board) {

    if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) {
      return;
    }

    // BFS, set O-> B
    bfs(board);

    // set O-> X, B-> O
    recover(board);

    return;
  }

  private void recover(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O') {
          board[i][j] = 'X';
        } else if (board[i][j] == 'B') {
          board[i][j] = 'O';
        }
      }
    }
  }

  private void bfs(char[][] board) {
    int n = board.length;
    int m = board[0].length;
    visited = new boolean[n][m];

    // init
    for (int i = 0; i < n; i++) {
      if (board[i][0] == 'O') {
        queue.add(new Index(i, 0));
      }
      if (board[i][m - 1] == 'O') {
        queue.add(new Index(i, m - 1));
      }
    }

    for (int j = 1; j < m - 1; j++) {
      if (board[0][j] == 'O') {
        queue.add(new Index(0, j));
      }
      if (board[n - 1][j] == 'O') {
        queue.add(new Index(n - 1, j));
      }
    }

    while (!queue.isEmpty()) {
      visit(queue.poll(), board, n, m);
    }
  }

  void visit(Index index, char[][] board, int n, int m) {
    board[index.x][index.y] = 'B';
    visited[index.x][index.y] = true;
    for (int t = 0; t < 4; t++) {
      int X = index.x + dx[t];
      int Y = index.y + dy[t];
      if (valid(X, Y, n, m) && !visited[X][Y] && board[X][Y] == 'O') {
        queue.add(new Index(X, Y));
      }
    }
  }

  private boolean valid(int i, int j, int n, int m) {
    return i >= 0 && j >= 0 && i < n && j < m;
  }

  int[] dx = {0, 0, 1, -1};
  int[] dy = {1, -1, 0, 0};

  private boolean[][] visited;
  private static Queue<Index> queue = new LinkedList<>();

  private static class Index {
    int x;
    int y;

    public Index(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public Index() {

    }

    @Override
    public String toString() {
      return "Index{" +
              "x=" + x +
              ", y=" + y +
              '}';
    }
  }
}
