package com.HackerRank.WalmartLabsCodesprintAlgorithms;

import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class HikingSelfies_1 {

  public static void main(String[] arg) {
    new HikingSelfies_1().testHikingSelfies_1();
  }

  private void testHikingSelfies_1() {
    Scanner scan = new Scanner(System.in);
    int a = scan.nextInt();
    int b = scan.nextInt();
    HikingSelfies_1(a, b);
//        log.info("{}", HikingSelfies_1(a, b));
  }

  void HikingSelfies_1(int a, int b) {

    long A = (long) Math.pow(2, a) - 1;

    // dp, bfs, binarySearch, divide conquer?

    // return the answer
    log.debug("{}", (int) Math.abs(A - b));
  }

}
