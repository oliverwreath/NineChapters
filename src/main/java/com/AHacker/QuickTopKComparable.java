package com.AHacker;

import java.util.Arrays;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-24.
 */
public class QuickTopKComparable {
    private static final Logger logger = LoggerFactory.getLogger(QuickTopKComparable.class);

    public static void main(String[] arg) {
        new QuickTopKComparable().testQuickSelectTopK();
    }

    /**
     * caller
     */
    private void testQuickSelectTopK() {
        int n = 300;
        Integer[] numbers = new Integer[n];
        int[] numbers2 = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            numbers[i] = random.nextInt(99);
            numbers2[i] = numbers[i];
        }

        int k = 99;
        QuickTopK(numbers, k);
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
    }

    /**
     * QuickTopK
     *
     * @param numbers
     * @param k
     */
    public static void QuickTopK(Comparable[] numbers, int k) {
        // handle extreme cases
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int n = numbers.length;
        int start = 0;
        int end = n - 1;
        Random random = new Random();
        QuickTopKHelper(numbers, start, end, random, k);
        return;
    }

    /**
     * helper of QuickTopK
     *
     * @param numbers
     * @param start
     * @param end
     * @param random
     * @param k
     */
    private static void QuickTopKHelper(Comparable[] numbers, int start, int end, Random random, int k) {
        // handle extreme cases
        if (numbers == null || start >= end || start >= k) {
            return;
        }

        // partition
        Comparable pivot = numbers[start + random.nextInt(end - start + 1)];
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && numbers[left].compareTo(pivot) < 0) {
                left++;
            }
            while (left <= right && numbers[right].compareTo(pivot) > 0) {
                right--;
            }
            if (left <= right) {
                swap(numbers, left, right);
                left++;
                right--;
            }
        }

        // recursive
        QuickTopKHelper(numbers, start, right, random, k);
        QuickTopKHelper(numbers, left, end, random, k);
    }

    private static void swap(Comparable[] numbers, int i, int j) {
        if (i != j) {
            Comparable tmp = numbers[i];
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
