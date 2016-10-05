package com.CodeForce;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yanli on 2016-10-05.
 */
public class D_Queue {
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
            System.out.println(0);
            return;
        }
        if (n == 1) {
            System.out.println(1);
            return;
        }

        Arrays.sort(a);
        int sum = a[0];
        int counter = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] >= sum) {
                counter++;
                sum += a[i];
            }
        }

        System.out.println(counter);

        return;
    }
}
