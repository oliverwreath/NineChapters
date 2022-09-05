package com.HackerRank.AnalyzeTest;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
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
//            log.debug(Arrays.toString(profits));
      long dayMax = profits[1] + profits[2];
      globalMax = Math.max(globalMax, dayMax);
    }
    log.info(String.valueOf(globalMax));
  }


//    public static void main(String[] arg) {
//        testLearningFromthePast();
//    }
//
//    private static void testLearningFromthePast() {
//        log.info("{}", LearningFromthePast());
//    }
//
//    static int LearningFromthePast() {
//
//    }
}
