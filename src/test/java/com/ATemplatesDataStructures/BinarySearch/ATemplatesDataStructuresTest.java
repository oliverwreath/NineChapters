package com.ATemplatesDataStructures.BinarySearch;

import com.ATemplatesDataStructures.DP.memoization.No394CoinsInALine;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class ATemplatesDataStructuresTest {
  @Test void testNo141SqrtX() {
    No141SqrtX no141SqrtX = new No141SqrtX();
    Assertions.assertEquals(0, no141SqrtX.sqrt(0));
    Assertions.assertEquals(1, no141SqrtX.sqrt(1));
    Assertions.assertEquals(1, no141SqrtX.sqrt(2));
    Assertions.assertEquals(1, no141SqrtX.sqrt(3));
    Assertions.assertEquals(2, no141SqrtX.sqrt(4));
    Assertions.assertEquals(2, no141SqrtX.sqrt(5));
    Assertions.assertEquals(3, no141SqrtX.sqrt(10));
  }

  @Test void testNo394CoinsInALine() {
    No394CoinsInALine no394CoinsInALine = new No394CoinsInALine();
    Assertions.assertFalse(no394CoinsInALine.firstWillWin(0));
    Assertions.assertTrue(no394CoinsInALine.firstWillWin(1));
    Assertions.assertTrue(no394CoinsInALine.firstWillWin(2));
    Assertions.assertFalse(no394CoinsInALine.firstWillWin(3));
    Assertions.assertTrue(no394CoinsInALine.firstWillWin(4));
    Assertions.assertTrue(no394CoinsInALine.firstWillWin(5));
//    Assertions.assertTrue(no394CoinsInALine.firstWillWin(9999));
  }
}
