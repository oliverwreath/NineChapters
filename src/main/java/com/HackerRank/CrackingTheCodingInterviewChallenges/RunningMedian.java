package com.HackerRank.CrackingTheCodingInterviewChallenges;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {
    private static final Logger logger = LoggerFactory.getLogger(RunningMedian.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int len = a.length;
        if (len < 1) {
            return;
        }
        PriorityQueue<Integer> left = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<Integer> right = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < len; i++) {
            int newInt = a[i];
            if (left.size() == right.size()) {
                if (left.isEmpty() || left.peek() < newInt) {
                    right.add(newInt);
                } else {
                    right.add(left.poll());
                    left.add(newInt);
                }
                System.out.println(right.peek() * 1.0);
            } else {
                if (newInt < right.peek()) {
                    left.add(newInt);
                } else {
                    left.add(right.poll());
                    right.add(newInt);
                }
                System.out.println((left.peek() + right.peek()) / 2.0);
            }
        }
    }

//    private static void testRunningMedian() {
//        RunningMedian RunningMedian = new RunningMedian();
//        MyLogger.info("result 2 v.s. " + RunningMedian.longestIncreasingContinuousSubsequence("12"));
//        MyLogger.info("result 1 v.s. " + RunningMedian.longestIncreasingContinuousSubsequence("10"));
//    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    int longestIncreasingContinuousSubsequence(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        // return the final result
        return -1;
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
