package com.HackerRank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/16/2016.
 */
public class BinaryNumbers {
    private static final Logger logger = LoggerFactory.getLogger(BinaryNumbers.class);

    public static void main(String[] arg) {
        testBinaryNumbers();
    }

    private static void testBinaryNumbers() {
        binaryNumbers();
    }

    static void binaryNumbers() {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
        int n = 439;
        int counter = 0;
        int maxCounter = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                counter++;
                maxCounter = Math.max(maxCounter, counter);
            } else {
                counter = 0;
            }
            n /= 2;
        }
        System.out.println(maxCounter);
    }
}
