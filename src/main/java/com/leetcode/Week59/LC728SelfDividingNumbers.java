package com.leetcode.Week59;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class LC728SelfDividingNumbers {
  public static void main(String[] args) {
    testSelfDividingNumbers_728();
  }

  private static void testSelfDividingNumbers_728() {
    LC728SelfDividingNumbers LC728SelfDividingNumbers = new LC728SelfDividingNumbers();
    log.info("result [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22] v.s. " + LC728SelfDividingNumbers.selfDividingNumbers(1, 22));
  }

  /**
   * @param left
   * @param right
   * @return
   */
  public List<Integer> selfDividingNumbers(int left, int right) {
    if (left > right) {
      return new LinkedList<>();
    }

    // core logic
    List<Integer> result = new LinkedList<>();
    for (int i = left; i <= right; i++) {
      if (isSelfDividingNumber(i)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean isSelfDividingNumber(int number) {
    int originalNumber = number;
    while (number > 0) {
      int digit = number % 10;
      if (digit == 0 || originalNumber % digit != 0) {
        return false;
      }
      number /= 10;
    }

    return true;
  }

}
