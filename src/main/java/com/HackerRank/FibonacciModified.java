package com.HackerRank;

import java.math.BigInteger;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
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
      log.debug("t1={}", t1);
    } else if (n == 2) {
      log.debug("t2={}", t2);
    }

    while (n-- > 2) {
      BigInteger tmp = t1.add(t2.pow(2));
      t1 = t2;
      t2 = tmp;
    }

    log.debug("t2={}", t2);
  }
}
