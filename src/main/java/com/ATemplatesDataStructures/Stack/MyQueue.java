package com.ATemplatesDataStructures.Stack;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;

@Slf4j
public class MyQueue {
  public static void main(String[] args) {
    testMyQueue();
  }

  private static void testMyQueue() {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1);
    log.info("result 1 v.s. " + myQueue.pop());
    myQueue.push(2);
    myQueue.push(3);
    log.info("result 2 v.s. " + myQueue.top());
    log.info("result 2 v.s. " + myQueue.pop());
  }

  public MyQueue() {
    // do intialization if necessary
    stackIn = new ArrayDeque<>();
    stackOut = new ArrayDeque<>();
  }

  private Deque<Integer> stackIn;
  private Deque<Integer> stackOut;

  /*
   * @param element: An integer
   * @return: nothing
   */
  public void push(int element) {

    stackIn.push(element);
  }

  /*
   * @return: An integer
   */
  public int pop() {

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

}
