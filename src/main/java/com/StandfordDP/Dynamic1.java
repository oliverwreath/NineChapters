package com.StandfordDP;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class Dynamic1 {
  public static void main(String[] arg) {
    testDynamic1();
  }

  private static void testDynamic1() {
    log.info("{}", backPackVariation(new int[]{1, 3, 4}, 10));
  }

  static int backPackVariation(int[] numbers, int n) {
    // filter abnormal inputs
    if (numbers == null || numbers.length == 0) {
      return 1;
    }

    // populate the subproblem result array
    int len = numbers.length;
    int[] ret = new int[n + 1];
    ret[0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j < len; j++) {
        if (i - numbers[j] >= 0) {
          ret[i] += ret[i - numbers[j]];
        }
      }
    }

    // print to verify before commiting
    log.debug(Arrays.toString(ret));

    // return result
    return ret[n];
  }
}
