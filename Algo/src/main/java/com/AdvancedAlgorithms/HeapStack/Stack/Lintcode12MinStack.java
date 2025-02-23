package com.AdvancedAlgorithms.HeapStack.Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode12MinStack {

  public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minDeque;

    public MinStack() {
      // do intialization if necessary
      stack = new ArrayDeque<>();
      minDeque = new ArrayDeque<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {

      stack.push(number);
      if (minDeque.isEmpty()) {
        minDeque.push(number);
      } else {
        if (number <= minDeque.peek()) {
          minDeque.push(number);
        }
      }
    }

    /*
     * @return: An integer
     */
    public int pop() {

      if (stack.peek().equals(minDeque.peek())) {
        minDeque.pop();
      }
      return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {

      return minDeque.peek();
    }
  }
}
