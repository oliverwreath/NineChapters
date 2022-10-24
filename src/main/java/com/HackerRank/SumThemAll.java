package com.HackerRank;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SumThemAll {

  public static void main(String[] args) {
    testSum(new int[]{1, 2, 3, 4, 5});
    testSum(new int[]{12, 12});
    testSum(null);
  }

  static void testSum(int[] numbers) {
    log.debug("{}", sum(numbers));
  }

  static int sum(int[] numbers) {
    if (numbers == null) {
      return 0;
    }

    int sum = 0;
    for (int number : numbers) {
      sum += number;
    }

    return sum;
  }
}
