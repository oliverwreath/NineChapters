package com.AdvancedAlgorithms.HeapStack.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class DecodeString_575 {
    private final static Logger logger = LoggerFactory.getLogger(DecodeString_575.class);

    public static void main(String[] args) {
        DecodeString_575 thisClass = new DecodeString_575();
        thisClass.testDecodeString_575();
    }

    private void testDecodeString_575() {
        logger.info("result {} v.s. {}", "adadpfpfpfadadpfpfpfadadpfpfpfxyz", expressionExpand("3[2[ad]3[pf]]xyz"));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
//        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    public String expressionExpand(String s) {
        // filter abnormal cases
        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Object> stack = new Stack<>();
        int number = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (c == '[') {
                stack.push(number);
                number = 0;
            } else if (c == ']') {
                String newString = popStack(stack);
                Integer count = (Integer) stack.pop();
                for (int t = 0; t < count; t++) {
                    stack.push(newString);
                }
            } else {
                stack.push(String.valueOf(c));
            }
        }

        // return the final result
        return popStack(stack);
    }

    private String popStack(Stack<Object> stack) {
        Stack<String> buffer = new Stack<>();
        while (!stack.isEmpty() && (stack.peek() instanceof String)) {
            buffer.push((String) stack.pop());
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!buffer.isEmpty()) {
            stringBuilder.append(buffer.pop());
        }
        return stringBuilder.toString();
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
