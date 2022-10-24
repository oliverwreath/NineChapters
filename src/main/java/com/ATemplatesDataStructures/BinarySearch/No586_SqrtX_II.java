package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No586_SqrtX_II {

  public static void main(String[] args) {
    testNo141_SqrtX();
  }

  private static void testNo141_SqrtX() {
    No586_SqrtX_II No141_SqrtX = new No586_SqrtX_II();
//        log.info("result 0 v.s. " + No141_SqrtX.sqrt(0));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
    log.info("result 1.41421356 v.s. " + No141_SqrtX.sqrt(2));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        log.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
  }

  public double sqrt(double x) {
    // filter abnormal cases
    if (x < 0) {
      return 0;
    }

    double start = 0;
    double end = (x < 1) ? 1 : x;
    double eps = 1e-12;
    while (start + eps < end) {
      double mid = (end - start) / 2 + start;
      if (mid * mid > x) {
        end = mid;
      } else {
        start = mid;
      }
    }

    return start;
  }

}
