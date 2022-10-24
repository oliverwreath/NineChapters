package com.applications;

import java.util.Arrays;
import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SudokuSolver {

  static void printBoard(int[][] board) {
    for (int i = 0; i < 9; i++) {
      log.debug(Arrays.toString(board[i]));
    }
  }

  static void printBoard(char[][] charBoard) {
    for (int i = 0; i < 9; i++) {
      log.debug(Arrays.toString(charBoard[i]));
    }
  }

  // return false for NO solution. return true for solved.
  boolean solve(int[][] board) {
    // backtracking
    LinkedList<Entry> trackingEntries = new LinkedList<>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == 0) {
          trackingEntries.add(new Entry(i, j));
        }
      }
    }

//        log.debug(String.valueOf(trackingEntries));
//        log.debug(String.valueOf(trackingEntries.size()));

    int currentIndex = 0;
    while (currentIndex < trackingEntries.size()) {
      Entry entry = trackingEntries.get(currentIndex);
//            log.debug("entry = " + entry);
      while (true) {
        if (board[entry.x][entry.y] > 8) {
          if (currentIndex == 0) {
            return false;
          } else {
            currentIndex--;
            board[entry.x][entry.y] = 0;
            break;
          }
        }
        board[entry.x][entry.y]++;
        if (isValidSudoku(board)) {
          currentIndex++;
          break;
        }
      }
    }

    return true;
  }

  class Entry {

    int x = 0;
    int y = 0;

    Entry(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "Entry{" +
          x +
          ", " + y +
          '}';
    }
  }

  private boolean isValidSudoku(char[][] charBoard) {
    return isValidSudoku(charBoardToIntBoard(charBoard));
  }

  static int[][] charBoardToIntBoard(char[][] board) {
    int[][] newBoard = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          newBoard[i][j] = 0;
        } else {
          newBoard[i][j] = board[i][j] - '0';
        }
      }
    }
    return newBoard;
  }

  boolean isValidSudoku(int[][] board) {
    boolean[] validator = new boolean[10];
    // rows
    for (int i = 0; i < 9; i++) {
      validator = new boolean[10];
      for (int j = 0; j < 9; j++) {
        if (board[i][j] != 0) {
          if (validator[board[i][j]]) {
            return false;
          } else {
            validator[board[i][j]] = true;
          }
        }
      }
    }

    // columns
    for (int j = 0; j < 9; j++) {
      validator = new boolean[10];
      for (int i = 0; i < 9; i++) {
        if (board[i][j] != 0) {
          if (validator[board[i][j]]) {
            return false;
          } else {
            validator[board[i][j]] = true;
          }
        }
      }
    }

    // blocks
    for (int xBegin = 0; xBegin < 3; xBegin++) {
      for (int yBegin = 0; yBegin < 3; yBegin++) {
        boolean blockValid = isBlockValid(board, xBegin, yBegin);
        if (!blockValid) {
          return false;
        }
      }
    }

    return true;
  }

  private boolean isBlockValid(int[][] board, int xBegin, int yBegin) {
    boolean[] validator = new boolean[10];
    xBegin *= 3;
    yBegin *= 3;
    for (int i = xBegin; i < xBegin + 3; i++) {
      for (int j = yBegin; j < yBegin + 3; j++) {
        if (board[i][j] != 0) {
          if (validator[board[i][j]]) {
            return false;
          } else {
            validator[board[i][j]] = true;
          }
        }
      }
    }

    return true;
  }
}
