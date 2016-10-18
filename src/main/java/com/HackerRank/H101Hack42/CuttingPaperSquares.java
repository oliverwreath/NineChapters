package com.HackerRank.H101Hack42;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-18.
 */
public class CuttingPaperSquares {
    private final static Logger logger = LoggerFactory.getLogger(CuttingPaperSquares.class);

    public static void main(String[] arg) {
        new CuttingPaperSquares().testCuttingPaperSquares();
    }

    private void testCuttingPaperSquares() {
        logger.info("{}", CuttingPaperSquares());
    }

    int CuttingPaperSquares() {
        // write your code here
        // handle extreme cases
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long m = scan.nextLong();

        System.out.println(n * m - 1);

        return 0;
    }
}
