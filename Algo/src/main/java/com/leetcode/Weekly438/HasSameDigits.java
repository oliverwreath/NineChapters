package com.leetcode.Weekly438;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j public class HasSameDigits {

  public static void main(String[] arg) {
    HasSameDigits caller = new HasSameDigits();
    log.info("hasSameDigits({}) = {} | Should be true", "3902", caller.hasSameDigits("3902"));
    log.info("hasSameDigits({}) = {} | Should be false", "34789", caller.hasSameDigits("34789"));
  }

  public boolean hasSameDigits(String s) {
    return true;
  }
}
