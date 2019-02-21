package com.HackerRank.Greedy;

import java.util.Arrays;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-17.
 */
public class PriyankaAndToys {
    private static final Logger logger = LoggerFactory.getLogger(PriyankaAndToys.class);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        Arrays.sort(a);

        int begin = -1;
        int end = -1;
        int costCounter = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] >= begin && a[i] <= end) {
                continue;
            } else {
                costCounter++;
                begin = a[i];
                end = a[i] + 4;
            }
        }

        System.out.println(costCounter);
    }
}
