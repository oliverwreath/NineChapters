package com.AdvancedAlgorithms.HeapStack.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class Min_stack_12 {
    private final static Logger logger = LoggerFactory.getLogger(Min_stack_12.class);

    public static void main(String[] args) {
        Min_stack_12 thisClass = new Min_stack_12();
        thisClass.testMin_stack_12();
    }

    private void testMin_stack_12() {
        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
        logger.info("result {} v.s. {}", "[1, 1, 2, 2, 3]", functionName(new int[]{1, 2, 3, 4, 5}));
    }

    public int functionName(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
    }

//    public class MinStack {
//        Stack<Integer> stack;
//        Stack<Integer> minStack;
//        public MinStack() {
//            // do intialization if necessary
//            stack = new Stack<>();
//            minStack = new Stack<>();
//        }
//
//        /*
//         * @param number: An integer
//         * @return: nothing
//         */
//        public void push(int number) {
//            // write your code here
//            stack.push(number);
//            if (minStack.isEmpty()) {
//                minStack.push(number);
//            } else {
//                minStack.push(Math.min(minStack.peek(), number));
//            }
//        }
//
//        /*
//         * @return: An integer
//         */
//        public int pop() {
//            // write your code here
//            minStack.pop();
//            return stack.pop();
//        }
//
//        /*
//         * @return: An integer
//         */
//        public int min() {
//            // write your code here
//            return minStack.peek();
//        }
//    }

    public class MinStack {
        Stack<Integer> stack;
        Stack<Integer> minStack;
        public MinStack() {
            // do intialization if necessary
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            stack.push(number);
            if (minStack.isEmpty()) {
                minStack.push(number);
            } else {
                if (number <= minStack.peek()) {
                    minStack.push(number);
                }
            }
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        }

        /*
         * @return: An integer
         */
        public int min() {
            // write your code here
            return minStack.peek();
        }
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
