package com.LeetCode.Weekly74;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No794_ValidTicTacToeState {
    private final static Logger logger = LoggerFactory.getLogger(No794_ValidTicTacToeState.class);

    public static void main(String[] args) {
        No794_ValidTicTacToeState No794_ValidTicTacToeState = new No794_ValidTicTacToeState();
        No794_ValidTicTacToeState.testNo794_ValidTicTacToeState();
    }

    private void testNo794_ValidTicTacToeState() {
        MyLogger.info("result false v.s. " + validTicTacToe(new String[]{"O  ", "   ", "   "}));
        MyLogger.info("result false v.s. " + validTicTacToe(new String[]{"XOX", " X ", "   "}));
        MyLogger.info("result false v.s. " + validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        MyLogger.info("result true v.s. " + validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        MyLogger.info("result false v.s. " + validTicTacToe(new String[]{"XXX", "XOO", "OO "}));
    }

    boolean validTicTacToe(String[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return false;
        }

        int XCount = 0;
        int OCount = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (A[i].charAt(j) == 'X') {
                    XCount++;
                } else if (A[i].charAt(j) == 'O') {
                    OCount++;
                }
            }
        }
        int XWinCount = 0;
        int OWinCount = 0;
        if (A[1].charAt(1) != ' ') {
            if (A[1].charAt(1) == 'X') {
                // * / \
                if (A[2].charAt(0) == 'X' && A[0].charAt(2) == 'X') {
                    XWinCount++;
                }
                if (A[2].charAt(2) == 'X' && A[0].charAt(0) == 'X') {
                    XWinCount++;
                }
                // + - |
                if (A[1].charAt(0) == 'X' && A[1].charAt(2) == 'X') {
                    XWinCount++;
                }
                if (A[2].charAt(1) == 'X' && A[0].charAt(1) == 'X') {
                    XWinCount++;
                }
            } else {
                // * / \
                if (A[2].charAt(0) == 'O' && A[0].charAt(2) == 'O') {
                    OWinCount++;
                }
                if (A[2].charAt(2) == 'O' && A[0].charAt(0) == 'O') {
                    OWinCount++;
                }
                // + - |
                if (A[1].charAt(0) == 'O' && A[1].charAt(2) == 'O') {
                    OWinCount++;
                }
                if (A[2].charAt(1) == 'O' && A[0].charAt(1) == 'O') {
                    OWinCount++;
                }
            }
        }
        if (A[0].charAt(0) != ' ') {
            if (A[0].charAt(0) == 'X') {
                // | -
                if (A[2].charAt(0) == 'X' && A[1].charAt(0) == 'X') {
                    XWinCount++;
                }
                if (A[0].charAt(1) == 'X' && A[0].charAt(2) == 'X') {
                    XWinCount++;
                }
            } else {
                // | -
                if (A[2].charAt(0) == 'O' && A[1].charAt(0) == 'O') {
                    OWinCount++;
                }
                if (A[0].charAt(1) == 'O' && A[0].charAt(2) == 'O') {
                    OWinCount++;
                }
            }
        }
        if (A[2].charAt(2) != ' ') {
            if (A[2].charAt(2) == 'X') {
                // | -
                if (A[0].charAt(2) == 'X' && A[1].charAt(2) == 'X') {
                    XWinCount++;
                }
                if (A[2].charAt(0) == 'X' && A[2].charAt(1) == 'X') {
                    XWinCount++;
                }
            } else {
                // | -
                if (A[0].charAt(2) == 'O' && A[1].charAt(2) == 'O') {
                    OWinCount++;
                }
                if (A[2].charAt(0) == 'O' && A[2].charAt(1) == 'O') {
                    OWinCount++;
                }
            }
        }
//        System.out.println(XCount);
//        System.out.println(OCount);
        if (XCount != OCount && XCount != (OCount + 1)) {
            return false;
        }
        if (XWinCount + OWinCount > 1) {
            return false;
        }
        if (XWinCount == 1) {
            return XCount == OCount + 1;
        } else if (OWinCount == 1) {
            return XCount == OCount;
        }
        return true;
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
