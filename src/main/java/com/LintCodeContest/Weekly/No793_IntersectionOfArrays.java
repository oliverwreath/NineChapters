package com.LintCodeContest.Weekly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;

public class No793_IntersectionOfArrays {
    private final static Logger logger = LoggerFactory.getLogger(No793_IntersectionOfArrays.class);

    public static void main(String[] args) {
        testNo793_IntersectionOfArrays();
    }

    private static void testNo793_IntersectionOfArrays() {
        No793_IntersectionOfArrays No793_IntersectionOfArrays = new No793_IntersectionOfArrays();
        MyLogger.info("result 1 v.s. " + No793_IntersectionOfArrays.intersectionOfArrays(new int[][]{
                {1, 2, 3},
                {3, 4, 5},
                {3, 9, 10}
        }));
        MyLogger.info("result 2 v.s. " + No793_IntersectionOfArrays.intersectionOfArrays(new int[][]{
                {1, 2, 3, 4},
                {1, 2, 5, 6, 7},
                {9, 10, 1, 5, 2, 3}
        }));
    }

    /**
     * @param arrs
     * @return
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        // filter abnormal cases
        if (arrs == null || arrs.length == 0 || arrs[0].length == 0) {
            return 0;
        }

        int m = arrs.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i : arrs[0]) {
            set.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i = 1; i < m; i++) {
            if (i % 2 == 1) {
                set2.clear();
                for (int num : arrs[i]) {
                    if (set.contains(num)) {
                        set2.add(num);
                    }
                }
            } else {
                set.clear();
                for (int num : arrs[i]) {
                    if (set2.contains(num)) {
                        set.add(num);
                    }
                }
            }
        }

        // return the final result
        System.out.println("set = " + set);
        System.out.println("set2 = " + set2);
        if ((m - 1) % 2 == 1) {
            System.out.println("set2 = ");
            return set2.size();
        } else {
            System.out.println("set1 = ");
            return set.size();
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
