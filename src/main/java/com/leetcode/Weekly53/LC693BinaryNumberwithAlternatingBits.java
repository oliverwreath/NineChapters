package com.leetcode.Weekly53;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC693BinaryNumberwithAlternatingBits {
  public static void main(String[] args) {
    testBinaryNumberwithAlternatingBits_693();
  }

  private static void testBinaryNumberwithAlternatingBits_693() {
    LC693BinaryNumberwithAlternatingBits LC_693BinaryNumberwithAlternatingBits = new LC693BinaryNumberwithAlternatingBits();
    log.info("result True v.s. " + LC_693BinaryNumberwithAlternatingBits.hasAlternatingBits(5));
    log.info("result False v.s. " + LC_693BinaryNumberwithAlternatingBits.hasAlternatingBits(7));
  }

  /**
   * @param n
   * @return
   */
  static public boolean hasAlternatingBits(int n) {
    if (n > 0) {
      int lastBit = n % 2;
      n = n / 2;
      while (n > 0) {
        int currentBit = n % 2;
        if (currentBit == lastBit) {
          return false;
        } else {
          lastBit = currentBit;
          n = n / 2;
        }
      }
    }
    return true;
  }

}
