package com.LeetCode.Weekly71;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class No780_ReachingPoints {
    private final static Logger logger = LoggerFactory.getLogger(No780_ReachingPoints.class);

    public static void main(String[] args) {
        No780_ReachingPoints No780_ReachingPoints = new No780_ReachingPoints();
        No780_ReachingPoints.testNo780_ReachingPoints();
    }

    private void testNo780_ReachingPoints() {
        MyLogger.info("result True v.s. " + reachingPoints(2, 7, 9, 16));
        MyLogger.info("result True v.s. " + reachingPoints(1, 1, 3, 5));
        MyLogger.info("result False v.s. " + reachingPoints(1, 1, 2, 2));
        MyLogger.info("result True v.s. " + reachingPoints(1, 1, 1, 1));
    }

//    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
//        // filter abnormal cases
//        if (sx > tx || sy > ty) {
//            return false;
//        }
//        if (sx == tx) {
//            return (ty - sy) % sx == 0;
//        }
//        if (sy == ty) {
//            return (tx - sx) % sy == 0;
//        }
//
//
//        if ((tx - sx) % sx % sy == 0 && ((ty - sy) % sx % sy == 0)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // filter abnormal cases
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        if (Math.min(sx, sy) > Math.min(tx, ty)) {
            System.out.println(1);
            return reachingPoints1(sx, sy, tx, ty);
        } else {
            System.out.println(2);
            return reachingPoints2(sx, sy, tx, ty);
        }
    }

    private int sx;
    private int sy;
    HashSet<Entry> isVisited2 = new HashSet<>();

    public boolean reachingPoints2(int sx, int sy, int tx, int ty) {
        // filter abnormal cases
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        isVisited2.clear();
        this.sx = sx;
        this.sy = sy;
        return helper2(tx, ty);
    }

    public boolean helper2(int tx, int ty) {
        if (isVisited2.contains(new Entry(tx, ty))) {
            return false;
        }
        if (this.sx == tx && this.sy == ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        isVisited2.add(new Entry(tx, ty));
        return helper2(tx - ty, ty) || helper2(tx, ty - tx);
    }

    private int tx;
    private int ty;
    HashSet<Entry> isVisited = new HashSet<>();

    public boolean reachingPoints1(int sx, int sy, int tx, int ty) {
        // filter abnormal cases
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        isVisited.clear();
        this.tx = tx;
        this.ty = ty;
        return helper(sx, sy);
    }

    public boolean helper(int sx, int sy) {
        if (isVisited.contains(new Entry(sx, sy))) {
            return false;
        }
        if (sx == this.tx && sy == this.ty) {
            return true;
        }
        if (sx > tx || sy > ty) {
            return false;
        }
        if (sx == tx) {
            return (ty - sy) % sx == 0;
        }
        if (sy == ty) {
            return (tx - sx) % sy == 0;
        }

        isVisited.add(new Entry(sx, sy));
        return helper(sx + sy, sy) || helper(sx, sx + sy);
    }

    class Entry {
        int x;
        int y;

        public Entry(int x, int y) {
            this.x = x;
            this.y = y;
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
