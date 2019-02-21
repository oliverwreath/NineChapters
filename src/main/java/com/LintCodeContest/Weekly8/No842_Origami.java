package com.LintCodeContest.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No842_Origami {
    private static final Logger logger = LoggerFactory.getLogger(No842_Origami.class);

    public static void main(String[] args) {
        No842_Origami No842_Origami = new No842_Origami();
        No842_Origami.testNo842_Origami();
    }

    private void testNo842_Origami() {
        MyLogger.info("result 0 v.s. " + getString(1));
        MyLogger.info("result 001 v.s. " + getString(2));
        MyLogger.info("result 0010011 v.s. " + getString(3));
    }

    String getString(int n) {
        // filter abnormal cases
        if (n <= 0) {
            return "";
        }

        this.answer = new StringBuilder();
        this.n = n;
        dfs(1, 0);

        // return the final result
        return answer.toString();
    }

    StringBuilder answer;
    int n;

    void dfs(int height, int index) {
        if (height + 1 <= n) {
            dfs(height + 1, index * 2);
        }
        this.answer.append((index % 2 == 0) ? '0' : '1');
        if (height + 1 <= n) {
            dfs(height + 1, index * 2 + 1);
        }
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
