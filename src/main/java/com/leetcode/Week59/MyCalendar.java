package com.leetcode.Week59;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCalendar {
  public static void main(String[] args) {
    testMyCalendar();
  }

  private static void testMyCalendar() {
    MyCalendar myCalendar = new MyCalendar();
    log.debug("{}", myCalendar.book(10, 20)); // returns true
    log.debug("{}", myCalendar.book(15, 25)); // returns false
    log.debug("{}", myCalendar.book(20, 30)); // returns true
  }

  Node root = null;

  public MyCalendar() {
    root = null;
  }

  public boolean book(int start, int end) {
    if (root == null) {
      root = new Node(start, end);
      return true;
    } else {
      return book(root, start, end);
    }
  }

  private boolean book(Node currentNode, int start, int end) {
    // impossible to be null
    if (end <= currentNode.start) {
      if (currentNode.left == null) {
        if (end == currentNode.start) {
          currentNode.start = start;
        } else {
          currentNode.left = new Node(start, end);
        }
        return true;
      }
      return book(currentNode.left, start, end);
    } else if (start >= currentNode.end) {
      if (currentNode.right == null) {
        if (start == currentNode.end) {
          currentNode.end = end;
        } else {
          currentNode.right = new Node(start, end);
        }
        return true;
      }
      return book(currentNode.right, start, end);
    } else {
      return false;
    }
  }

  private class Node {
    Node left;
    Node right;
    int start;
    int end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
      left = null;
      right = null;
    }
  }

}
