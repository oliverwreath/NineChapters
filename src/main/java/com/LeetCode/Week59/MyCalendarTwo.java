package com.LeetCode.Week59;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyCalendarTwo {
    private final static Logger logger = LoggerFactory.getLogger(MyCalendarTwo.class);

    public static void main(String[] args) {
        testMyCalendarTwo();
    }

    private static void testMyCalendarTwo() {
//        MyCalendarTwo myCalendar = new MyCalendarTwo();
//        System.out.println(myCalendar.book(10, 20)); // returns true
//        System.out.println(myCalendar.book(50, 60)); // returns true
//        System.out.println(myCalendar.book(10, 40)); // returns true
//        System.out.println(myCalendar.book(5, 15)); // returns false
//        System.out.println(myCalendar.book(5, 10)); // returns true
//        System.out.println(myCalendar.book(25, 55)); // returns true

        MyCalendarTwo myCalendar = new MyCalendarTwo();
        System.out.println(myCalendar.book(12, 26)); // returns true
        System.out.println(myCalendar.book(37, 47)); // returns true
        System.out.println(myCalendar.book(90, 100)); // returns true
        System.out.println(myCalendar.book(21, 34)); // returns true
        System.out.println(myCalendar.book(99, 100)); // returns true
        System.out.println(myCalendar.book(95, 100)); // returns false

        System.out.println(myCalendar.book(4, 16)); // returns true
        System.out.println(myCalendar.book(67, 86)); // returns true
        System.out.println(myCalendar.book(55, 69)); // returns true
        System.out.println(myCalendar.book(63, 81)); // returns false
        System.out.println(myCalendar.book(51, 66)); // returns true

        System.out.println(myCalendar.book(18, 35)); // returns false
        System.out.println(myCalendar.book(51, 64)); // returns false
        System.out.println(myCalendar.book(40, 56)); // returns false
        System.out.println(myCalendar.book(11, 28)); // returns false
        System.out.println(myCalendar.book(13, 27)); // returns false

        System.out.println(myCalendar.book(38, 51)); // returns true
    }

    Node root = null;

    public MyCalendarTwo() {
        root = null;
    }


    public boolean book(int start, int end) {
        MyLogger.debug("root = " + root + "; start = " + start + "; end = " + end);
        if (root == null) {
            root = new Node(start, end, 1);
            return true;
        } else {
            return book(root, start, end);
        }
    }

    private boolean book(Node currentNode, int start, int end) {
        // impossible to be null
        MyLogger.debug("currentNode = " + currentNode);
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

    private static class MyLogger {
        static boolean isDebugging = true;
        static boolean isInfoing = false;

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
