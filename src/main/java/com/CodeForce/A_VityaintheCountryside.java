package com.CodeForce;

import java.util.Scanner;

/**
 * Created by yanli on 2016-10-05.
 */
public class A_VityaintheCountryside {
    public static void main(String[] arg) {
        // write your code here
        // handle extreme cases
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        if (n <= 0) {
            System.out.println(-1);
            return;
        }
        if (n == 1) {
            if (a[0] == 0) {
                System.out.println("UP");
            } else if (a[0] == 15) {
                System.out.println("DOWN");
            } else {
                System.out.println(-1);
            }
            return;
        }

        if (a[n - 1] == 0) {
            System.out.println("UP");
        } else if (a[n - 1] == 15) {
            System.out.println("DOWN");
        } else {
            if (a[n - 2] < a[n - 1]) {
                System.out.println("UP");
            } else {
                System.out.println("DOWN");
            }
        }
        return;
    }
}
