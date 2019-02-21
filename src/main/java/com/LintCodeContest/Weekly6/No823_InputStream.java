package com.LintCodeContest.Weekly6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class No823_InputStream {
    private static final Logger logger = LoggerFactory.getLogger(No823_InputStream.class);

    public static void main(String[] args) {
        No823_InputStream No823_InputStream = new No823_InputStream();
        No823_InputStream.testNo823_InputStream();
    }

    private void testNo823_InputStream() {
        MyLogger.info("result YES v.s. " + inputStream("abcde<<", "abcd<e<"));
        MyLogger.info("result NO v.s. " + inputStream("a<<bc", "abc<"));
    }

    String inputStream(String inputA, String inputB) {
        // filter abnormal cases
        boolean answer = false;
        String answerA;
        String answerB;
        if (inputA == null || inputA.length() == 0) {
            if (inputB == null || inputB.length() == 0) {
                return getResult(true);
            } else {
                answerB = getResult(inputB);
                if (answerB == null || answerB.length() == 0) {
                    return getResult(true);
                } else {
                    return getResult(false);
                }
            }
        }
        if (inputB == null || inputB.length() == 0) {
            answerA = getResult(inputA);
            if (answerA == null || answerA.length() == 0) {
                return getResult(true);
            } else {
                return getResult(false);
            }
        }

        answer = getResult(inputA).equals(getResult(inputB));

        // return the final result
        return getResult(answer);
    }

    String getResult(String inputA) {
        if (inputA == null || inputA.length() == 0) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < inputA.length(); i++) {
            if (inputA.charAt(i) == '<') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(inputA.charAt(i));
            }
        }
        if (stack.isEmpty()) {
            return "";
        } else {
            StringBuilder answerBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                answerBuilder.append(stack.pop());
            }
            return answerBuilder.reverse().toString();
        }
    }

    String getResult(boolean answer) {
        if (answer) {
            return "YES";
        } else {
            return "NO";
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
