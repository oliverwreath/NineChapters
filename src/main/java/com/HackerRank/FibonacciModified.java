package com.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yanli on 8/30/2016.
 */
public class FibonacciModified {
    public static void main(String[] args) {
        testMaxLength();
    }

    static void testMaxLength() {
        maxLength();
    }

    static void maxLength() {
        Scanner scan = new Scanner(System.in);
        BigInteger t1 = scan.nextBigInteger();
        BigInteger t2 = scan.nextBigInteger();
        long n = scan.nextLong();

        if (n == 1) {
            System.out.println(t1);
        } else if (n == 2) {
            System.out.println(t2);
        }

        while (n-- > 2) {
            BigInteger tmp = t1.add(t2.pow(2));
            t1 = t2;
            t2 = tmp;
        }

        System.out.println(t2);
    }
}
