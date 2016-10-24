package com.AHacker;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-24.
 */
public class QuickSortInt {
    private final static Logger logger = LoggerFactory.getLogger(QuickSortInt.class);

    public static void main(String[] arg) {
        new QuickSortInt().testQuickSort();
    }

    private void testQuickSort() {
//        logger.info("{}", QuickSelectTopK());
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


        QuickSort(numbers);
        System.out.println(Arrays.toString(numbers));
        Arrays.sort(numbers2);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != numbers2[i]) {
                System.out.println(false);
            }
        }

//        for (int i = 0; i < numbers.length; i++) {
//            System.out.println(Arrays.toString(QuickSelectTopK(numbers, i)));
//        }
    }

    public static void QuickSort(int[] numbers) {
        // handle extreme cases
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        Random random = new Random();
        QuickSortHelper(numbers, start, end, random);
        return;
    }

    private static void QuickSortHelper(int[] numbers, int start, int end, Random random) {
        // handle extreme cases
        if (numbers == null || start >= end) {
            return;
        }

        // partition
        int pivotIndex = start + random.nextInt(end - start + 1);
        int pivot = numbers[pivotIndex];
        swap(numbers, start, pivotIndex);
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (left <= right && numbers[left] < pivot) {
                left++;
            }
            while (left <= right && numbers[right] >= pivot) {
                right--;
            }
            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }
        swap(numbers, start, right);

        // recursive
        QuickSortHelper(numbers, start, right - 1, random);
        QuickSortHelper(numbers, right + 1, end, random);
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
