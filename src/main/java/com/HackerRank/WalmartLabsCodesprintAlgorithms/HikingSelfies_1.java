package com.HackerRank.WalmartLabsCodesprintAlgorithms;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-29.
 */
public class HikingSelfies_1 {
    private static final Logger logger = LoggerFactory.getLogger(HikingSelfies_1.class);

    public static void main(String[] arg) {
        new HikingSelfies_1().testHikingSelfies_1();
    }

    private void testHikingSelfies_1() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        HikingSelfies_1(a, b);
//        logger.info("{}", HikingSelfies_1(a, b));
    }

    void HikingSelfies_1(int a, int b) {
        // handle extreme cases
        long A = (long) Math.pow(2, a) - 1;

        // dp, bfs, binarySearch, divide conquer?

        // return the answer
        System.out.println((int) Math.abs(A - b));
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
