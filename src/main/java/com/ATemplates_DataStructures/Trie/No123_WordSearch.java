package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No123_WordSearch {
    private final static Logger logger = LoggerFactory.getLogger(No123_WordSearch.class);

    public static void main(String[] args) {
        No123_WordSearch No123_WordSearch = new No123_WordSearch();
        No123_WordSearch.testNo123_WordSearch();
    }

    private void testNo123_WordSearch() {
//        MyLogger.info("result true v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCCED"));
//        MyLogger.info("result true v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "SEE"));
//        MyLogger.info("result false v.s. " + exist(new char[][]{
//                {'A', 'B', 'C', 'E'},
//                {'S', 'F', 'C', 'S'},
//                {'A', 'D', 'E', 'E'}
//        }, "ABCB"));
        MyLogger.info("result true v.s. " + exist(new char[][]{
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
//                        System.out.println("isMatch: " + i + ", " + j);
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

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
