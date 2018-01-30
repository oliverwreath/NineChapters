package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class ExpressionExpand {
    private final static Logger logger = LoggerFactory.getLogger(ExpressionExpand.class);

    public static void main(String[] args) {
        testExpressionExpand();
    }

    private static void testExpressionExpand() {
        ExpressionExpand ExpressionExpand = new ExpressionExpand();
        MyLogger.info("result dabbbcabbbc v.s. " + ExpressionExpand.expressionExpand("d2[a3[b]c]"));
        MyLogger.info("result abcaaa v.s. " + ExpressionExpand.expressionExpand("abc3[a]"));
    }

    /*
     * @param s: an expression includes numbers, letters and brackets
     * @return: a string
     */
    public String expressionExpand(String s) {
        // write your code here
        if (s == null || s.length() < 2) {
            return s;
        }

        Stack<StringBuilder> stack = new Stack<>();
        Stack<Integer> factorStack = new Stack<>();
        stack.add(new StringBuilder());
        factorStack.add(1);
        int number = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                factorStack.add(number);
                number = 0;
                stack.add(new StringBuilder());
            } else if (c == ']') {
                StringBuilder tmp = stack.pop();
                int factor = factorStack.pop();
                for (int i = 0; i < factor; i++) {
                    stack.peek().append(tmp);
                }
            } else if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else {
                stack.peek().append(c);
            }
        }

        return stack.peek().toString();
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
