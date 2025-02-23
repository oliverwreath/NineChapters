package com.HackerRank;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BinaryNumbers {

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
    log.debug(String.valueOf(maxCounter));
  }
}
