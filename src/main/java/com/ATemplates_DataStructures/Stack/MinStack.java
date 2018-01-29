package com.ATemplates_DataStructures.Stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
//        minStack.push(1);
//        System.out.println(minStack.pop());
//        minStack.push(2);
//        minStack.push(3);
//        System.out.println(minStack.min());
//        minStack.push(1);
//        System.out.println(minStack.min());
        minStack.push(3);
        minStack.push(2);
        minStack.push(2);
        minStack.push(4);
        minStack.push(5);
        minStack.push(1);
        minStack.check();
    }

    public MinStack() {
        // do intialization if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    Stack<Integer> stack;
    Stack<Integer> minStack;

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty() || number <= minStack.peek()) {
            minStack.push(number);
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (!stack.isEmpty()) {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        } else {
            return -1;
        }
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return -1;
        }
    }

    public void check() {
        System.out.println("stack = " + stack);
        System.out.println("minStack = " + minStack);
    }
}

//public class MinStack {
//    public MinStack() {
//        // do intialization if necessary
//        stack = new Stack<>();
//        minStack = new Stack<>();
//    }
//
//    Stack<Integer> stack;
//    Stack<Integer> minStack;
//
//    /*
//     * @param number: An integer
//     * @return: nothing
//     */
//    public void push(int number) {
//        // write your code here
//        stack.push(number);
//        if (minStack.isEmpty()) {
//            minStack.push(number);
//        } else {
//            minStack.push(Math.min(minStack.peek(), number));
//        }
//    }
//
//    /*
//     * @return: An integer
//     */
//    public int pop() {
//        // write your code here
//        if (!stack.isEmpty()) {
//            minStack.pop();
//            return stack.pop();
//        }
//        return -1;
//    }
//
//    /*
//     * @return: An integer
//     */
//    public int min() {
//        // write your code here
//        if (!minStack.isEmpty()) {
//            return minStack.peek();
//        }
//        return -1;
//    }
//}