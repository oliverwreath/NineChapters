package com.ATemplates_DataStructures.Weekly;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PriorityQueue;

public class No791_MergeNumber {
    private final static Logger logger = LoggerFactory.getLogger(No791_MergeNumber.class);

    public static void main(String[] args) {
        testNo791_MergeNumber();
    }

    private static void testNo791_MergeNumber() {
        No791_MergeNumber No791_MergeNumber = new No791_MergeNumber();
        MyLogger.info("result 19 v.s. " + No791_MergeNumber.mergeNumber(new int[]{1, 2, 3, 4}));
        MyLogger.info("result 25 v.s. " + No791_MergeNumber.mergeNumber(new int[]{2, 8, 4, 1}));
    }

    /**
     * @param numbers
     * @return
     */
    public int mergeNumber(int[] numbers) {
        // Write your code here
        // filter abnormal cases
        if (numbers == null || numbers.length == 0) {
            return 0;
        }

//        TreeSet<Integer>

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int number : numbers) {
            heap.add(number);
        }
        int answer = 0;
        while (!heap.isEmpty()) {
            int poll = heap.poll();
            if (heap.isEmpty()) {
                return answer;
            }
            int poll2 = heap.poll();
            poll2 += poll;
            answer += poll2;
            heap.add(poll2);
        }

        // return the final result
        return answer;
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
