package com.GM.Sorting;

import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class IntroSorting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int target = scan.nextInt();
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            if (a[i] == target) {
                System.out.println(i);
                return;
            }
        }
    }
}
