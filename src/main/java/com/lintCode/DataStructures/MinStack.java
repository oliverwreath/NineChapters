package com.lintCode.DataStructures;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Created by yanli on 9/18/2016.
 */
public class MinStack {
    private Stack<Integer> stack;
    PriorityQueue<Integer> priorityQueue;

    public MinStack() {
        // do initialize if necessary
        stack = new Stack<Integer>();
        priorityQueue = new PriorityQueue<Integer>();
    }

    public void push(int number) {
        // write your code here
        priorityQueue.add(number);
        stack.push(number);
    }

    public int pop() {
        // write your code here
        priorityQueue.remove(stack.peek());
        return stack.pop();
    }

    public int min() {
        // write your code here
        return priorityQueue.peek();
    }
}

