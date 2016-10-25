package com.AHacker;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-24.
 */
public class QuickTopK {
    private final static Logger logger = LoggerFactory.getLogger(QuickTopK.class);

    public static void main(String[] arg) {
        new QuickTopK().testQuickSelectTopK();
    }

    private void testQuickSelectTopK() {
//        logger.info("{}", QuickTopK());
        int n = 300;
        int[] numbers = new int[n];
        int[] numbers2 = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(99);
            numbers2[i] = numbers[i];
        }
//        int goodCounter = 0;
//        int badCounter = 0;
//        for (int i = 0; i < 999999999; i++) {
//            int num = random.nextInt(n);
//            if (0 <= num && num < n) {
//                goodCounter++;
//            } else {
//                badCounter++;
//            }
//        }
//        System.out.println("goodCounter = " + goodCounter + "; badCounter = " + badCounter);

        int k = 99;
        QuickSort(numbers, k);
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers2);
        for (int i = 0; i < numbers.length; i++) {
            if (k > 0) {
                if (numbers[i] != numbers2[i]) {
                    System.out.println(false);
                }
                k--;
            } else {
//                System.out.println("after k false");
                break;
            }
        }
        System.out.println(Arrays.toString(numbers2));

//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(Arrays.toString(QuickTopK(numbers, i)));
//        }
    }

    public static void QuickSort(int[] numbers, int k) {
        // handle extreme cases
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        Random random = new Random();
        QuickSortHelper(numbers, start, end, random, k);
        return;
    }

    private static void QuickSortHelper(int[] numbers, int start, int end, Random random, int k) {
        // handle extreme cases
        if (numbers == null || start >= end || start >= k) {
            return;
        }

        // partition
        int pivot = numbers[start + random.nextInt(end - start + 1)];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && numbers[left] < pivot) {
                left++;
            }
            while (left <= right && numbers[right] > pivot) {
                right--;
            }
            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }

        // recursive
        QuickSortHelper(numbers, start, right, random, k);
        QuickSortHelper(numbers, left, end, random, k);
    }

    private static void swap(int[] numbers, int i, int j) {
        if (i != j) {
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;
        }
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
