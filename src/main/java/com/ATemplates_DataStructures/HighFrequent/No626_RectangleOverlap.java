package com.ATemplates_DataStructures.HighFrequent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class No626_RectangleOverlap {
    private static final Logger logger = LoggerFactory.getLogger(No626_RectangleOverlap.class);

    public static void main(String[] args) {
        No626_RectangleOverlap No626_RectangleOverlap = new No626_RectangleOverlap();
        No626_RectangleOverlap.testNo626_RectangleOverlap();
    }

    private void testNo626_RectangleOverlap() {
        MyLogger.info("result true v.s. " + doOverlap(new Point(0, 8), new Point(8, 0), new Point(6, 6), new Point(10, 0)));
        MyLogger.info("result false v.s. " + doOverlap(new Point(0, 8), new Point(8, 0), new Point(9, 6), new Point(10, 0)));
    }

    class Point {
        public int x, y;

        public Point() {
            x = 0;
            y = 0;
        }

        public Point(int a, int b) {
            x = a;
            y = b;
        }
    }

    boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // return the final result
        return l1.y >= r2.y && r1.y <= l2.y && l1.x <= r2.x && r1.x >= l2.x;
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
