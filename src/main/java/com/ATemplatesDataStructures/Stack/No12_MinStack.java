package com.ATemplatesDataStructures.Stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class No12_MinStack {
  public static void main(String[] args) {
    No12_MinStack No12_MinStack = new No12_MinStack();
    No12_MinStack.testNo12_MinStack();
  }

  private void testNo12_MinStack() {
    MinStack minStack = new MinStack();
    minStack.push(1);
    log.info("result 1 v.s. " + minStack.pop());
    minStack.push(2);
    minStack.push(3);
    log.info("result 2 v.s. " + minStack.min());
    log.info("result 3 v.s. " + minStack.pop());
    minStack.push(1);
    log.info("result 1 v.s. " + minStack.min());
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
    private Deque<Integer> minStack;
    private Deque<Integer> stack;

    public MinStack() {
      // do intialization if necessary
      minStack = new ArrayDeque<>();
      stack = new ArrayDeque<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
  
      if (minStack.isEmpty() || minStack.peek() >= number) {
        minStack.push(number);
      }
      stack.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
  
      if (!minStack.isEmpty() && minStack.peek().equals(stack.peek())) {
        minStack.pop();
      }
      return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
  
      if (!minStack.isEmpty()) {
        return minStack.peek();
      }
      return -1;
    }
  }

}
