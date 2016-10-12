package com.HackerRank.WeekOfCode24;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-10.
 */
public class AppleAndOrange {
    private final static Logger logger = LoggerFactory.getLogger(AppleAndOrange.class);

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int t = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();
        int m = in.nextInt();
        int n = in.nextInt();
        int appleCounter = 0;
        for (int apple_i = 0; apple_i < m; apple_i++) {
            int tmp = a + in.nextInt();
            if (tmp >= s && tmp <= t) {
                appleCounter++;
            }
        }
        int orangeCounter = 0;
        for (int orange_i = 0; orange_i < n; orange_i++) {
            int tmp = b + in.nextInt();
            if (tmp >= s && tmp <= t) {
                orangeCounter++;
            }
        }

        System.out.println(appleCounter);
        System.out.println(orangeCounter);

        return;
    }
}
