package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class No12_MinStack {
    private final static Logger logger = LoggerFactory.getLogger(No12_MinStack.class);

    public static void main(String[] args) {
        No12_MinStack No12_MinStack = new No12_MinStack();
        No12_MinStack.testNo12_MinStack();
    }

    private void testNo12_MinStack() {
        MinStack minStack = new MinStack();
        minStack.push(1);
        MyLogger.info("result 1 v.s. " + minStack.pop());
        minStack.push(2);
        minStack.push(3);
        MyLogger.info("result 2 v.s. " + minStack.min());
        MyLogger.info("result 3 v.s. " + minStack.pop());
        minStack.push(1);
        MyLogger.info("result 1 v.s. " + minStack.min());
    }

//    int functionName(int[] A) {
//        // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
//
//        // return the final result
//        return -1;
//    }

    public class MinStack {
        private Stack<Integer> minStack;
        private Stack<Integer> stack;

        public MinStack() {
            // do intialization if necessary
            minStack = new Stack<>();
            stack = new Stack<>();
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            if (minStack.isEmpty() || minStack.peek() >= number) {
                minStack.push(number);
            }
            stack.push(number);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (!minStack.isEmpty() && minStack.peek().equals(stack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        }

        /*
         * @return: An integer
         */
        public int min() {
            // write your code here
            if (!minStack.isEmpty()) {
                return minStack.peek();
            }
            return -1;
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
