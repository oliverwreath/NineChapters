package com.applications;

import static com.applications.SudokuSolver.charBoardToIntBoard;
import static com.applications.SudokuSolver.printBoard;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class ApplicationsTest {

  @Test @Disabled("disabled for not spamming emails!")
  void testGmailSender() {
    final String toRecipient = "skywalkerhunter@gmail.com";
    String USER_NAME = "skywalkerhunter@gmail.com";
    String PASSWORD = "blabla";
    GmailSender gmailSender = new GmailSender(USER_NAME, PASSWORD);
    gmailSender.sendMail(toRecipient);

    USER_NAME = "crmtransformed@gmail.com";
    PASSWORD = "blabla";
    gmailSender = new GmailSender(USER_NAME, PASSWORD);
    gmailSender.sendMail(toRecipient);
    Assertions.assertTrue(true);
  }

  @Test @Disabled("disabled for not spamming emails!")
  void testFoxmailSender() {
    final String toRecipient = "skywalkerhunter@gmail.com";
    final String USER_NAME = "skyoliver@foxmail.com";
    final String PASSWORD = "blabla";
    FoxmailSender foxmailSender = new FoxmailSender(USER_NAME, PASSWORD);
    foxmailSender.sendMail(toRecipient);
    Assertions.assertTrue(true);
  }

  @Test void test_SudokuSolver1() {
    // initializations
    int[][] board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      board[i][i] = i + 1;
    }
    log.debug("initialization1: ");
    printBoard(board);

    // solve
    SudokuSolver sudokuSolver = new SudokuSolver();
    Assertions.assertTrue(sudokuSolver.solve(board));
    Assertions.assertTrue(sudokuSolver.isValidSudoku(board));
    log.debug("result: ");
    printBoard(board);
  }

  @Test void test_SudokuSolver2() {
    // initializations
    int[][] board = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        board[i][j] = 0;
      }
    }
    for (int i = 0; i < 9; i++) {
      board[i][i] = i + 1;
    }
    board[0][1] = 4;
    log.debug("");
    log.debug("initialization2: ");
    printBoard(board);
    SudokuSolver sudokuSolver = new SudokuSolver();
    Assertions.assertTrue(sudokuSolver.solve(board));
    Assertions.assertTrue(sudokuSolver.isValidSudoku(board));
    log.debug("result: ");
    printBoard(board);
  }

  @Test void test_SudokuSolver3() {
    char[][] charBoard = new char[][]{
        {'.', '.', '.', '.', '5', '.', '.', '1', '.'},
        {'.', '4', '.', '3', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
        {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
        {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
        {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
        {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
        {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
        {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
    };
    log.debug("");
    log.debug("initialization3: ");
    int[][] intBoard = charBoardToIntBoard(charBoard);
    printBoard(intBoard);
    SudokuSolver sudokuSolver = new SudokuSolver();
    log.debug("isSolved = " + sudokuSolver.solve(intBoard));
    log.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(intBoard));
    log.debug("result: ");
    printBoard(intBoard);
  }

  @Test void test_SudokuSolver4() {
    int[][] board = new int[][]{
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };
    log.debug("initialization4: ");
    printBoard(board);
    SudokuSolver sudokuSolver = new SudokuSolver();
    Assertions.assertTrue(sudokuSolver.solve(board));
    Assertions.assertTrue(sudokuSolver.isValidSudoku(board));
    log.debug("result: ");
    printBoard(board);
  }

  @Test void test_SudokuSolver5() {
    int[][] board = new int[][]{
        {5, 0, 0, 0, 0, 7, 0, 0, 0},
        {0, 0, 0, 1, 0, 4, 8, 0, 0},
        {0, 3, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 6, 5, 0},
        {0, 8, 0, 0, 0, 0, 0, 3, 0},
        {0, 5, 7, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 4, 0},
        {0, 0, 5, 4, 0, 1, 0, 0, 0},
        {0, 0, 0, 6, 0, 0, 0, 0, 3}
    };
    log.debug("initialization5: ");
    printBoard(board);
    SudokuSolver sudokuSolver = new SudokuSolver();
    Assertions.assertTrue(sudokuSolver.solve(board));
    Assertions.assertTrue(sudokuSolver.isValidSudoku(board));
    log.debug("result: ");
    printBoard(board);
  }
}
