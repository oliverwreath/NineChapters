package com.LintCodeContest.Weekly13;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class No970_BigBusiness {
    private final static Logger logger = LoggerFactory.getLogger(No970_BigBusiness.class);

    public static void main(String[] args) {
        No970_BigBusiness No970_BigBusiness = new No970_BigBusiness();
        No970_BigBusiness.testNo970_BigBusiness();
    }

    private void testNo970_BigBusiness() {
        MyLogger.info("result 4 v.s. " + bigBusiness(new int[]{3, 1, 5}, new int[]{4, 3, 100}, 1));
        MyLogger.info("result 108 v.s. " + bigBusiness(new int[]{3, 1, 5}, new int[]{4, 3, 100}, 10));
    }

    int bigBusiness(int[] A, int[] B, int k) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        PriorityQueue<Entry> minHeap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        for (int i = 0; i < len; i++) {
            if (A[i] >= B[i]) {
                continue;
            }
//            System.out.println("i = " + i + "; A[i] = " + A[i]);
            if (k > A[i]) {
                k += B[i] - A[i];
            } else {
                minHeap.add(new Entry(A[i], B[i] - A[i]));
            }
        }

        while (!minHeap.isEmpty()) {
            if (minHeap.peek().cost > k) {
                break;
            }
            Entry entry = minHeap.poll();
            k += entry.profit;
        }

        // return the final result
        return k;
    }

    private class Entry {
        int cost;
        int profit;

        public Entry(int cost, int profit) {
            this.cost = cost;
            this.profit = profit;
        }


        @Override
        public String toString() {
            return "Entry{" +
                    "cost=" + cost +
                    ", profit=" + profit +
                    '}';
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
