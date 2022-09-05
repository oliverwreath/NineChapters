package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: Oliver
 */
@Slf4j
public class HappyNumber {
  public static void main(String[] arg) {
    testHappyNumber();
  }

  private static void testHappyNumber() {
    log.info("{}", isHappy(19));
  }

  /**
   * @param n an integer
   * @return true if this is a happy number or false
   */
  static boolean isHappy(int n) {

    Set<Integer> set = new HashSet<Integer>();

    while (!set.contains(n)) {
      set.add(n);
      long sum = 0;
      while (n > 0) {
        int digit = n % 10;
        sum += digit * digit;
        n /= 10;
      }
      if (sum == 1) {
        return true;
      }
      n = (int) sum;
//            log.debug(n);
    }

    return false;
  }
}
