package com.GM.Sorting;

import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class InsertionSort2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        insertionSortPart2(a);
    }

    public static void insertionSortPart2(int[] a) {
        // Fill up this function
        int len = a.length;
        if (len <= 1) {
            return;
        }

        for (int i = 1; i < len; i++) {
            int tmp = a[i];
            for (int j = 0; j < i; j++) {
                if (tmp < a[j]) {
                    for (int k = i - 1; k >= j; k--) {
                        a[k + 1] = a[k];
                    }
                    a[j] = tmp;
                    break;
                }
            }

            myPrintArray(a);
        }

        return;
    }

    static void myPrintArray(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            System.out.format("%d ", a[i]);
        }
        System.out.format("%d\n", a[len - 1]);
    }
}
