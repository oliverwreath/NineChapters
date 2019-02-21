package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class NO423_ValidParentheses {
    private static final Logger logger = LoggerFactory.getLogger(NO423_ValidParentheses.class);

    public static void main(String[] args) {
        NO423_ValidParentheses NO423_ValidParentheses = new NO423_ValidParentheses();
        NO423_ValidParentheses.testNO423_ValidParentheses();
    }

    private void testNO423_ValidParentheses() {
        MyLogger.info("result false v.s. " + isValidParentheses("["));
        MyLogger.info("result true v.s. " + isValidParentheses("()"));
        MyLogger.info("result true v.s. " + isValidParentheses("()[]{}"));
        MyLogger.info("result false v.s. " + isValidParentheses("(]"));
        MyLogger.info("result false v.s. " + isValidParentheses("([)]"));
    }

    public boolean isValidParentheses(String s) {
        // filter abnormal cases
        if (s == null || s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (isOpening(c)) {
                stack.push(c);
            } else if (isClosing(c)) {
                if (stack.isEmpty() || !isMatching(stack.peek(), c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // return the final result
        return stack.isEmpty();
    }

    private boolean isMatching(Character opening, Character closing) {
        return (opening.equals('(') && closing.equals(')')) ||
                (opening.equals('{') && closing.equals('}')) ||
                (opening.equals('[') && closing.equals(']'));
    }

    boolean isOpening(Character c) {
        if (c.equals('(') || c.equals('{') || c.equals('[')) {
            return true;
        } else {
            return false;
        }
    }

    boolean isClosing(Character c) {
        if (c.equals(')') || c.equals('}') || c.equals(']')) {
            return true;
        } else {
            return false;
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
