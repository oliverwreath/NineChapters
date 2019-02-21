package com.LeetCode.Weekly73;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No789_EscapeTheGhosts {
    private static final Logger logger = LoggerFactory.getLogger(No789_EscapeTheGhosts.class);

    public static void main(String[] args) {
        No789_EscapeTheGhosts No789_EscapeTheGhosts = new No789_EscapeTheGhosts();
        No789_EscapeTheGhosts.testNo789_EscapeTheGhosts();
    }

    private void testNo789_EscapeTheGhosts() {
        MyLogger.info("result true v.s. " + escapeGhosts(new int[][]{
                {1, 0},
                {0, 3}
        }, new int[]{0, 1}));
        MyLogger.info("result false v.s. " + escapeGhosts(new int[][]{
                {1, 0}
        }, new int[]{2, 0}));
        MyLogger.info("result false v.s. " + escapeGhosts(new int[][]{
                {2, 0}
        }, new int[]{1, 0}));
    }

    boolean escapeGhosts(int[][] ghosts, int[] target) {
        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
        if (ghosts == null || ghosts.length == 0) {
            return true;
        }
        int myDistance = getDistance(new int[]{0, 0}, target);
        int m = ghosts.length;
        for (int i = 0; i < m; i++) {
            int tmpDistance = getDistance(ghosts[i], target);
            if (tmpDistance <= myDistance) {
                return false;
            }
        }

        // return the final result
        return true;
    }

    int getDistance(int[] source, int[] target) {
        return Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
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
