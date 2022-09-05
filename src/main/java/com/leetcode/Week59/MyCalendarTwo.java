package com.leetcode.Week59;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyCalendarTwo {
  public static void main(String[] args) {
    testMyCalendarTwo();
  }

  private static void testMyCalendarTwo() {
//        MyCalendarTwo myCalendar = new MyCalendarTwo();
//        log.debug("{}", myCalendar.book(10, 20)); // returns true
//        log.debug("{}", myCalendar.book(50, 60)); // returns true
//        log.debug("{}", myCalendar.book(10, 40)); // returns true
//        log.debug("{}", myCalendar.book(5, 15)); // returns false
//        log.debug("{}", myCalendar.book(5, 10)); // returns true
//        log.debug("{}", myCalendar.book(25, 55)); // returns true

    MyCalendarTwo myCalendar = new MyCalendarTwo();
    log.debug("{}", myCalendar.book(12, 26)); // returns true
    log.debug("{}", myCalendar.book(37, 47)); // returns true
    log.debug("{}", myCalendar.book(90, 100)); // returns true
    log.debug("{}", myCalendar.book(21, 34)); // returns true
    log.debug("{}", myCalendar.book(99, 100)); // returns true
    log.debug("{}", myCalendar.book(95, 100)); // returns false

    log.debug("{}", myCalendar.book(4, 16)); // returns true
    log.debug("{}", myCalendar.book(67, 86)); // returns true
    log.debug("{}", myCalendar.book(55, 69)); // returns true
    log.debug("{}", myCalendar.book(63, 81)); // returns false
    log.debug("{}", myCalendar.book(51, 66)); // returns true

    log.debug("{}", myCalendar.book(18, 35)); // returns false
    log.debug("{}", myCalendar.book(51, 64)); // returns false
    log.debug("{}", myCalendar.book(40, 56)); // returns false
    log.debug("{}", myCalendar.book(11, 28)); // returns false
    log.debug("{}", myCalendar.book(13, 27)); // returns false

    log.debug("{}", myCalendar.book(38, 51)); // returns true
  }

  Node root = null;

  public MyCalendarTwo() {
    root = null;
  }


  public boolean book(int start, int end) {
    log.debug("root = " + root + "; start = " + start + "; end = " + end);
    if (root == null) {
      root = new Node(start, end, 1);
      return true;
    } else {
      return book(root, start, end);
    }
  }

  private boolean book(Node currentNode, int start, int end) {
    // impossible to be null
    log.debug("currentNode = " + currentNode);
    if (end <= currentNode.start) {
      if (currentNode.left == null) {
        if (end == currentNode.start) {
          if (currentNode.count == 1) {
            currentNode.start = start;
          } else {
            currentNode.left = new Node(start, end, 1);
          }
        } else {
          currentNode.left = new Node(start, end, 1);
        }
        return true;
      } else {
        return book(currentNode.left, start, end);
      }
    } else if (start >= currentNode.end) {
      if (currentNode.right == null) {
        if (start == currentNode.end) {
          if (currentNode.count == 1) {
            currentNode.end = end;
          } else {
            currentNode.right = new Node(start, end, 1);
          }
        } else {
          currentNode.right = new Node(start, end, 1);
        }
        return true;
      } else {
        return book(currentNode.right, start, end);
      }
    } else {
      if (currentNode.count == 2) {
        return false;
      } else {
        int smallerStart = Math.min(start, currentNode.start);
        int largerStart = Math.max(start, currentNode.start);
        int smallerEnd = Math.min(end, currentNode.end);
        int largerEnd = Math.max(end, currentNode.end);
        currentNode.start = largerStart;
        currentNode.end = smallerEnd;
        currentNode.count = 2;
        if (currentNode.left == null) {
          currentNode.left = new Node(smallerStart, largerStart, 1);
        } else {
          boolean isLeftOk = book(currentNode.left, smallerStart, largerStart);
          if (!isLeftOk) {
            return false;
          }
        }
//                boolean isLeftOk = book(currentNode.left, smallerStart, largerStart);
        if (currentNode.right == null) {
          currentNode.right = new Node(smallerEnd, largerEnd, 1);
        } else {
          boolean isRightOk = book(currentNode.right, smallerEnd, largerEnd);
          if (!isRightOk) {
            return false;
          }
        }
//                boolean isRightOk = book(currentNode.right, smallerEnd, largerEnd);
//                return isLeftOk && isRightOk;
        return true;
      }
    }
  }

  private class Node {
    Node left;
    Node right;
    int start;
    int end;
    int count;

    public Node(int start, int end, int count) {
      this.start = start;
      this.end = end;
      this.count = count;
      left = null;
      right = null;
    }

    @Override
    public String toString() {
      return "Node{" +
//                    "left=" + left +
//                    ", right=" + right +
              "start=" + start +
              ", end=" + end +
              ", count=" + count +
              '}';
    }
  }

}
