package com.GM.Sorting;

import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class InsertionSort {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }

        insertIntoSorted(a);
    }

    public static void insertIntoSorted(int[] a) {
        // Fill up this function
        int len = a.length;
        if (len <= 1) {
            return;
        }

        int e = a[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (e < a[i]) {
                a[i + 1] = a[i];
                myPrintArray(a);
            } else if (e >= a[i]) {
                a[i + 1] = e;
                myPrintArray(a);
                return;
            }
        }

        a[0] = e;
        myPrintArray(a);

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
