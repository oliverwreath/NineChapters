package com.ATemplatesDataStructures.DP.memoization;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class MemoizationTest {

  @Test void test_no395CoinsInALineII() {
    No395CoinsInALineII no395CoinsInALineII = new No395CoinsInALineII();
    Assertions.assertFalse(no395CoinsInALineII.firstWillWin(new int[]{}));
    Assertions.assertTrue(no395CoinsInALineII.firstWillWin(new int[]{1, 2, 2}));
    Assertions.assertFalse(no395CoinsInALineII.firstWillWin(new int[]{1, 2, 4}));
    Assertions.assertFalse(no395CoinsInALineII.firstWillWin(new int[]{100, 200, 400, 300, 400, 800, 500, 600, 1200}));
  }
}
