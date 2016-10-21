package com.AJia.HackerRank;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-20.
 */
public class StockMaximize {
    private final static Logger logger = LoggerFactory.getLogger(StockMaximize.class);

    public static void main(String[] arg) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        // handle extreme cases
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scan.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scan.nextInt();
            }

            int[] maxSelling = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = n - 1; i > 0; i--) {
                max = Math.max(max, a[i]);
                maxSelling[i] = max;
            }
            long profit = 0;
            for (int i = 0; i < n - 1; i++) {
                if (maxSelling[i + 1] > a[i]) {
                    profit += maxSelling[i + 1] - a[i];
                }
            }
            System.out.println(profit);
        }
    }

    private static MyTmpLogger myLogger = new MyTmpLogger();

    private static class MyTmpLogger {
        public boolean isLogging = false;

        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }
}
