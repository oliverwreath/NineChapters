package com.ATemplatesDataStructures.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinStack {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
//        minStack.push(1);
//        log.debug(minStack.pop());
//        minStack.push(2);
//        minStack.push(3);
//        log.debug(minStack.min());
//        minStack.push(1);
//        log.debug(minStack.min());
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
    stack = new ArrayDeque<>();
    minStack = new ArrayDeque<>();
  }

  Deque<Integer> stack;
  Deque<Integer> minStack;

  /*
   * @param number: An integer
   * @return: nothing
   */
  public void push(int number) {

    stack.push(number);
    if (minStack.isEmpty() || number <= minStack.peek()) {
      minStack.push(number);
    }
  }

  /*
   * @return: An integer
   */
  public int pop() {

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

    if (!minStack.isEmpty()) {
      return minStack.peek();
    } else {
      return -1;
    }
  }

  public void check() {
    log.debug("stack = " + stack);
    log.debug("minStack = " + minStack);
  }
}

//public class MinStack {
//    public MinStack() {
//        // do intialization if necessary
//        stack = new ArrayDeque<>();
//        minStack = new ArrayDeque<>();
//    }
//
//    Deque<Integer> stack;
//    Deque<Integer> minStack;
//
//    /*
//     * @param number: An integer
//     * @return: nothing
//     */
//    public void push(int number) {
//    
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
//    
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
//    
//        if (!minStack.isEmpty()) {
//            return minStack.peek();
//        }
//        return -1;
//    }
//}
