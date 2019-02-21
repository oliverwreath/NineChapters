package com.HackerRank;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/16/2016.
 */
public class TreasureHunting {
    private static final Logger logger = LoggerFactory.getLogger(TreasureHunting.class);

    public static void main(String[] arg) {
        testTreasureHunting();
    }

    private static void testTreasureHunting() {
        treasureHunting();
    }

    static void treasureHunting() {
        Scanner scan = new Scanner(System.in);
        long x = scan.nextLong();
        long y = scan.nextLong();
        long a = scan.nextLong();
        long b = scan.nextLong();
        long numerator = a * x + y * b;
        long denominator = a * a + b * b;
        double k = numerator * 1.0 / denominator;
        numerator = a * y - x * b;
        double n = numerator * 1.0 / denominator;
//        double k = (a * x + y * b) / (a * a + b * b);
//        double n = (a * y - x * b) / (a * a + b * b);
        System.out.println(k);
        System.out.println(n);
    }
}
