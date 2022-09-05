package com.leetcode.Weekly68;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Author: Oliver
 */
@Slf4j
class TestLC767ReorganizeString {
  @Test void testNo767ReorganizeString() {
    LC767ReorganizeString LC767ReorganizeString = new LC767ReorganizeString();
    Assertions.assertEquals("aba", LC767ReorganizeString.reorganizeString("aab"));
    Assertions.assertEquals("", LC767ReorganizeString.reorganizeString("aaab"));
  }
}
