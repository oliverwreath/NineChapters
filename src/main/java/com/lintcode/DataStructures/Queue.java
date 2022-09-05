package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author: Oliver
 */
@Slf4j
public class Queue {
  private Deque<Integer> stack1;
  private Deque<Integer> stack2;

  public Queue() {
    // do initialization if necessary
    stack1 = new ArrayDeque<Integer>();
    stack2 = new ArrayDeque<Integer>();
  }

  public void push(int element) {

    stack1.push(element);
  }

  public int pop() {

    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      return -1;
    } else {
      return stack2.pop();
    }
  }

  public int top() {

    if (stack2.isEmpty()) {
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    if (stack2.isEmpty()) {
      return -1;
    } else {
      return stack2.peek();
    }
  }
}
