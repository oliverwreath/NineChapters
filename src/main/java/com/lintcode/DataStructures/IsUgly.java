package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class IsUgly {
  public static void main(String[] arg) {
    testIsUgly();
  }

  private static void testIsUgly() {
    log.info("{}", isUgly(8));
    log.info("{}", isUgly(14));
  }

  /**
   * @param num an integer
   * @return true if num is an ugly number or false
   */
  static boolean isUgly(int num) {

    if (num < 1) {
      return false;
    }
    if (num == 1) {
      return true;
    }

    while (num >= 2 && num % 2 == 0) {
      num /= 2;
    }
    while (num >= 3 && num % 3 == 0) {
      num /= 3;
    }
    while (num >= 5 && num % 5 == 0) {
      num /= 5;
    }

    return num == 1;
  }
}
