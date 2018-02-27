package com.ATemplates_DataStructures.Trie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No635_BoggleGame {
    private final static Logger logger = LoggerFactory.getLogger(No635_BoggleGame.class);

    public static void main(String[] args) {
        No635_BoggleGame No635_BoggleGame = new No635_BoggleGame();
        No635_BoggleGame.testNo635_BoggleGame();
    }

    private void testNo635_BoggleGame() {
//        MyLogger.info("result 2 v.s. " + boggleGame("12"));
    }

//    int boggleGame(char[][] board, String[] words) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // return the final result
//        return -1;
//    }

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
