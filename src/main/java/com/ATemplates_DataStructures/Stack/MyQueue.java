package com.ATemplates_DataStructures.Stack;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Stack;

public class MyQueue {
    private static final Logger logger = LoggerFactory.getLogger(MyQueue.class);

    public static void main(String[] args) {
        testMyQueue();
    }

    private static void testMyQueue() {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        MyLogger.info("result 1 v.s. " + myQueue.pop());
        myQueue.push(2);
        myQueue.push(3);
        MyLogger.info("result 2 v.s. " + myQueue.top());
        MyLogger.info("result 2 v.s. " + myQueue.pop());
    }

    public MyQueue() {
        // do intialization if necessary
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    private Stack<Integer> stackIn;
    private Stack<Integer> stackOut;

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stackIn.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (!stackOut.isEmpty() || !stackIn.isEmpty()) {
            if (stackOut.isEmpty()) {
                this.pour();
            }
            return stackOut.pop();
        } else {
            return -1;
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (!stackOut.isEmpty() || !stackIn.isEmpty()) {
            if (stackOut.isEmpty()) {
                this.pour();
            }
            return stackOut.peek();
        } else {
            return -1;
        }
    }

    private void pour() {
        while (!stackIn.isEmpty()) {
            stackOut.push(stackIn.pop());
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
