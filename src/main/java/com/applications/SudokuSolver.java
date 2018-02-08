package com.applications;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by yanli on 2017-07-11.
 */
public class SudokuSolver {
    private static final Logger logger = LoggerFactory.getLogger(SudokuSolver.class);

    public static void main(String[] args) {
        // new GenerateMetaData().ReadAndPrint();
        testSudokuSolver();
    }

    private static void testSudokuSolver() {
        int[][] board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            board[i][i] = i + 1;
        }
        MyLogger.debug("initialization1: ");
        printBoard(board);
        SudokuSolver sudokuSolver = new SudokuSolver();
        MyLogger.debug("isSolved = " + sudokuSolver.sudokuSolver(board));
        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(board));
        MyLogger.debug("result: ");
        printBoard(board);

//        board[0][1] = 1;
//        MyLogger.debug();
//        MyLogger.debug("initialization: ");
//        printBoard(board);
//        sudokuSolver.sudokuSolver(board);
//        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(board));
//        MyLogger.debug("result: ");
//        printBoard(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = 0;
            }
        }
        for (int i = 0; i < 9; i++) {
            board[i][i] = i + 1;
        }
        board[0][1] = 4;
        MyLogger.debug();
        MyLogger.debug("initialization2: ");
        printBoard(board);
        MyLogger.debug("isSolved = " + sudokuSolver.sudokuSolver(board));
        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(board));
        MyLogger.debug("result: ");
        printBoard(board);

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
        MyLogger.debug();
        MyLogger.debug("initialization3: ");
        int[][] intBoard = charBoardToIntBoard(charBoard);
        printBoard(intBoard);
        MyLogger.debug("isSolved = " + sudokuSolver.sudokuSolver(intBoard));
        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(intBoard));
        MyLogger.debug("result: ");
        printBoard(intBoard);

        board = new int[][]{
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
        MyLogger.debug("initialization1: ");
        printBoard(board);
        sudokuSolver = new SudokuSolver();
        MyLogger.debug("isSolved = " + sudokuSolver.sudokuSolver(board));
        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(board));
        MyLogger.debug("result: ");
        printBoard(board);

        board = new int[][]{
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
        MyLogger.debug("initialization1: ");
        printBoard(board);
        sudokuSolver = new SudokuSolver();
        MyLogger.debug("isSolved = " + sudokuSolver.sudokuSolver(board));
        MyLogger.debug("isValidSudoku = " + sudokuSolver.isValidSudoku(board));
        MyLogger.debug("result: ");
        printBoard(board);
    }

    static private void printBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            MyLogger.debug(Arrays.toString(board[i]));
        }
    }

    static private void printBoard(char[][] charBoard) {
        for (int i = 0; i < 9; i++) {
            MyLogger.debug(Arrays.toString(charBoard[i]));
        }
    }

    // return false for NO solution. return true for solved.
    private boolean sudokuSolver(int[][] board) {
        // backtracking
        LinkedList<Entry> trackingEntries = new LinkedList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    trackingEntries.add(new Entry(i, j));
                }
            }
        }

        System.out.println(trackingEntries);
        System.out.println(trackingEntries.size());

        int currentIndex = 0;
        while (currentIndex < trackingEntries.size()) {
            Entry entry = trackingEntries.get(currentIndex);
//            System.out.println("entry = " + entry);
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

    static private int[][] charBoardToIntBoard(char[][] board) {
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

    private boolean isValidSudoku(int[][] board) {
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

    private static class MyLogger {
        static boolean isDebugging = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println();
            }
        }
    }
}
