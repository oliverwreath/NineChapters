package com.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class IntegerReplacement {
  public static void main(String[] arg) {
    testIntegerReplacement();
  }

  private static void testIntegerReplacement() {
//        log.info("{}", integerReplacement(8));//3
//        log.info("{}", integerReplacement(7));//4
//        log.info("{}", integerReplacement(3));//2
    for (long i = 2147483637; i <= 2147483647; i++) {
      log.info("integerReplacement({}) = {}", i, integerReplacement((int) i));
    }
  }

  static final int LEN = 2147483640;//227483640
  static byte[] min = new byte[LEN];

  static {
    for (int i = 0; i < LEN; i++) {
      min[i] = Byte.MIN_VALUE;
    }
    min[1] = 0;
  }

  public static int integerReplacement(int n) {
    // abnormal inputs
    if (n < 1) {
      return Integer.MAX_VALUE;
    }
    if (n == 2147483647) {
      return 32;
    }

    if (n < LEN && min[n] >= 0) {
      return (int) min[n];
    } else {
      int counter;
      if (n % 2 == 0) {
        counter = 1 + integerReplacement(n / 2);
      } else {
        counter = 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
      }
      if (n < LEN) {
        min[n] = (byte) counter;
      }
      return counter;
    }
  }
}
