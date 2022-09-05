package com.lintcode.Book_Coding_Interviews;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class CountOnes {
  public static void main(String[] arg) {
    testCountOnes();
  }

  private static void testCountOnes() {
    log.info("{}", countOnes(1023));
    log.info("{}", countOnes(32));
    log.info("{}", countOnes(5));
  }

  static int countOnes(int num) {
    int count = 0;
    while (num != 0) {
      num = num & (num - 1);
      count++;
    }
    return count;
  }
}
