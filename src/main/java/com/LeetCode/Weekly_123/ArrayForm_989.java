package com.LeetCode.Weekly_123;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
public class ArrayForm_989 {
    private static final Logger logger = LoggerFactory.getLogger(ArrayForm_989.class);

    public static void main(String[] args) {
        ArrayForm_989 thisClass = new ArrayForm_989();
        thisClass.testArrayForm_989();
    }

    private void testArrayForm_989() {
        logger.info("result {} v.s. {}", "[1,2,3,4]", addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        logger.info("result {} v.s. {}", "4,5,5", addToArrayForm(new int[]{2, 7, 4}, 181));
        logger.info("result {} v.s. {}", "1,0,2,1", addToArrayForm(new int[]{2, 1, 5}, 806));
        logger.info("result {} v.s. {}", "[1,0,0,0,0,0,0,0,0,0,0]", addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }

    public List<Integer> addToArrayForm(int[] A, int K) {
        // filter abnormal cases
        LinkedList<Integer> list = new LinkedList<>();
        if (A == null || A.length == 0) {
            while (K > 0) {
                list.addFirst(K % 10);
                K /= 10;
            }
            return list;
        }

        // dp logic
        int m = A.length - 1;
        int carry = 0;
        while (K > 0) {
            int sum = K % 10 + (m >= 0 ? A[m] : 0) + carry;
            carry = sum / 10;
            list.addFirst(sum % 10);
            K /= 10;
            m--;
        }
        for (int i = m; i >= 0; i--) {
            int sum = A[i] + carry;
            carry = sum / 10;
            list.addFirst(sum % 10);
        }
        if (carry > 0) {
            list.addFirst(1);
        }

        // return the final result
        return list;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
