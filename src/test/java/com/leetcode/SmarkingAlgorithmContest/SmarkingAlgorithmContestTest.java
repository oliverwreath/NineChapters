package com.leetcode.SmarkingAlgorithmContest;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
class SmarkingAlgorithmContestTest {
  @SneakyThrows
  @Test void testKthSmallestInLexicographicalOrder_440() {
    LC440KthSmallestInLexicographicalOrder LC440KthSmallestInLexicographicalOrder = new LC440KthSmallestInLexicographicalOrder();
    Assertions.assertEquals(17, LC440KthSmallestInLexicographicalOrder.findKthNumber(100, 10));
    Assertions.assertEquals(10, LC440KthSmallestInLexicographicalOrder.findKthNumber(13, 2));
    Assertions.assertEquals(1, LC440KthSmallestInLexicographicalOrder.findKthNumber(1, 1));
    log.info("{}", testKthNumber(999, 2));
    log.info("{}", LC440KthSmallestInLexicographicalOrder.findKthNumber(203, 203));
    log.info("10 = {}", LC440KthSmallestInLexicographicalOrder.findKthNumber(13, 13));
//    Assertions.assertEquals(10, kthSmallestInLexicographicalOrder440.findKthNumber(13, 13));
    log.info("{}", LC440KthSmallestInLexicographicalOrder.findKthNumber(99, 99));
    log.info("{}", LC440KthSmallestInLexicographicalOrder.findKthNumber(999, 999));
    log.info("{}", LC440KthSmallestInLexicographicalOrder.findKthNumber(965, 965));
    log.info("{}", LC440KthSmallestInLexicographicalOrder.findKthNumber(99999965, 99999965));

    for (int k = 1; k < 100; k++) {
      int a = (k - 1) / 11 + 1;
      int b = (k + 9) % 11;
//            log.info(a + " " + b);
      if (b == 10) {
        log.debug("{}", a);
      } else {
        log.debug("{}", a * 10 + b);
      }
    }

    for (int k = 2; k < 3; k++) {
      int a = (k - 1) / 11 + 1;
      int b = (k + 9) % 11;
//            log.info(a + " " + b);
      if (b == 10) {
        log.debug("{}", a);
      } else {
        log.debug("{}", a * 10 + b);
      }
    }
  }

  private int testKthNumber(int n, int k) {

    String[] a = new String[n];
    for (int i = 1; i <= n; i++) {
      a[i - 1] = String.valueOf(i);
    }
    Arrays.sort(a);
    log.info("a = " + Arrays.toString(a));

    return 0;
  }
}
