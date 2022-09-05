package com.HackerRank.H101Hack42;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * Author: Oliver
 */
@Slf4j
public class CuttingPaperSquares {
  public static void main(String[] arg) {
    new CuttingPaperSquares().testCuttingPaperSquares();
  }

  private void testCuttingPaperSquares() {
    log.info("{}", CuttingPaperSquares());
  }

  int CuttingPaperSquares() {

    Scanner scan = new Scanner(System.in);
    long n = scan.nextLong();
    long m = scan.nextLong();

    log.debug(String.valueOf(n * m - 1));

    return 0;
  }
}
