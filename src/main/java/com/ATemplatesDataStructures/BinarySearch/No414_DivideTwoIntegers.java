package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No414_DivideTwoIntegers {
  public static void main(String[] args) {
    testNo141_SqrtX();
  }

  private static void testNo141_SqrtX() {
    No414_DivideTwoIntegers No141_SqrtX = new No414_DivideTwoIntegers();
    log.info("result 11 v.s. " + No141_SqrtX.divide(100, 9));
    log.info("result 20 v.s. " + No141_SqrtX.divide(100, 5));
    log.info("result 5 v.s. " + No141_SqrtX.divide(100, 20));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(2));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        log.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
  }

  public int divide(int dividend, int divisor) {
    // filter abnormal cases
    if (dividend == 0) {
      return 0;
    }
    if (divisor == 0) {
      return Integer.MAX_VALUE;
    }
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    boolean isNegative = (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0);
    long a = Math.abs((long) dividend);
    long b = Math.abs((long) divisor);
    int cnt = 0;
    while (a >= b) {
      int shift = 0;
      while (a >= b << shift) {
        shift++;
      }
      a -= b << (shift - 1);
      cnt += 1 << (shift - 1);
    }

    return isNegative ? -cnt : cnt;
  }

}
