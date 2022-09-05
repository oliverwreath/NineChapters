package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class MinStack {
  private Deque<Integer> stack;
  PriorityQueue<Integer> priorityQueue;

  public MinStack() {
    // do initialize if necessary
    stack = new ArrayDeque<>();
    priorityQueue = new PriorityQueue<>();
  }

  public void push(int number) {

    priorityQueue.add(number);
    stack.push(number);
  }

  public int pop() {

    priorityQueue.remove(stack.peek());
    return stack.pop();
  }

  public int min() {

    return priorityQueue.peek();
  }
}

