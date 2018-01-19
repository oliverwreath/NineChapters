package com.aTemplates_DataStructures.Basic_Sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class BubbleSort {
    private final static Logger logger = LoggerFactory.getLogger(BubbleSort.class);

    public static void main(String[] args) {
        testBubbleSort();
    }

    private static final int RANGE = 999;

    private static void testBubbleSort() {
        BubbleSort BubbleSort = new BubbleSort();
        BubbleSort.bubbleSort(new int[]{3, 2, 1});
        BubbleSort.bubbleSort(new int[]{5, 4, 3, 2, 1});
        int[] list = new int[30];
        for (int i = 0; i < list.length; i++) {
            int n = (int) (Math.random() * RANGE - RANGE / 2);
            list[i] = n;
        }
        BubbleSort.bubbleSort(list);
    }

    /**
     * @param A an array of Integer
     * @return an integer
     */
    public void bubbleSort(int[] A) {
        // filter abnormal cases
        if (A == null || A.length == 0) {
            return;
        }

        int n = A.length;
        for (int t = 0; t < n - 1; t++) {
            int swapCounter = 0;
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > A[i + 1]) {
                    int tmp = A[i];
                    A[i] = A[i + 1];
                    A[i + 1] = tmp;
                    swapCounter++;
                }
            }
            if (swapCounter == 0) {
                break;
            }
        }

        System.out.println("Result = " + Arrays.toString(A));
        Arrays.sort(A);
        System.out.println("Answer = " + Arrays.toString(A));
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
