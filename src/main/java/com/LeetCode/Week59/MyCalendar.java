package com.LeetCode.Week59;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCalendar {
    private static final Logger logger = LoggerFactory.getLogger(MyCalendar.class);

    public static void main(String[] args) {
        testMyCalendar();
    }

    private static void testMyCalendar() {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true
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

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
