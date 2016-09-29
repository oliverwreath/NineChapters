package com.HackerRank.AnalyzeTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yanli on 2016-09-29.
 */
public class LearningFromthePast {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long globalMax = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long[] profits = new long[3];
            profits[0] = scan.nextLong();
            profits[1] = scan.nextLong();
            profits[2] = scan.nextLong();
            Arrays.sort(profits);
//            System.out.println(Arrays.toString(profits));
            long dayMax = profits[1] + profits[2];
            globalMax = Math.max(globalMax, dayMax);
        }
        System.out.println(globalMax);
    }

//    private final static Logger logger = LoggerFactory.getLogger(LearningFromthePast.class);
//
//    public static void main(String[] arg) {
//        testLearningFromthePast();
//    }
//
//    private static void testLearningFromthePast() {
//        logger.info("{}", LearningFromthePast());
//    }
//
//    static int LearningFromthePast() {
//
//    }
}
