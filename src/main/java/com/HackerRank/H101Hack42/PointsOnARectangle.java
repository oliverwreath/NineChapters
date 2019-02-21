package com.HackerRank.H101Hack42;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-18.
 */
public class PointsOnARectangle {
    private static final Logger logger = LoggerFactory.getLogger(PointsOnARectangle.class);

    public static void main(String[] arg) {
        new PointsOnARectangle().testCuttingPaperSquares();
    }

    private void testCuttingPaperSquares() {
        Scanner scan = new Scanner(System.in);
        long T = scan.nextLong();
        for (long t = 0; t < T; t++) {
            System.out.println(CuttingPaperSquares(scan));
        }
    }

    private String CuttingPaperSquares(Scanner scan) {
        // write your code here
        // handle extreme cases
        int n = scan.nextInt();
        if (n == 1) {
            scan.nextLong();
            scan.nextLong();
            return "YES";
        }
        long x = scan.nextLong();
        long y = scan.nextLong();
        long minX = x;
        long maxX = x;
        long minY = y;
        long maxY = y;
        Point[] a = new Point[n];
        a[0] = new Point(x, y);
        for (int i = 1; i < n; i++) {
            x = scan.nextLong();
            y = scan.nextLong();
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
            a[i] = new Point(x, y);
        }
        System.out.println(Arrays.toString(a));
        for (int i = 0; i < n; i++) {
            if (a[i].x == minX || a[i].x == maxX) {
                if (!(a[i].y <= maxY) || !(a[i].y >= minY)) {
                    return "NO";
                }
            } else if (a[i].y == minY || a[i].y == maxY) {
                if (!(a[i].x <= maxX) && !(a[i].x >= minX)) {
                    return "NO";
                }
            } else {
                return "NO";
            }
        }

        return "YES";
    }

    private class Point {
        long x;
        long y;

        public Point() {

        }

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
//2
//        3
//        0 0
//        0 1
//        1 0
//        4
//        0 0
//        0 2
//        2 0
//        1 1