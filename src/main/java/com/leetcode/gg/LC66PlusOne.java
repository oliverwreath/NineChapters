package com.leetcode.gg;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC66PlusOne {

  public static void main(String[] arg) {
    new LC66PlusOne().testLongestAbsoluteFilePath_388();
  }

  private void testLongestAbsoluteFilePath_388() {
//        log.info("{}", plusOne(new int[]{}));
//        log.info("{}", plusOne(new int[]{0}));
//        log.debug("");
//        log.info("{}", plusOne(new int[]{-1}));
//        log.info("{}", plusOne(new int[]{-6}));
    log.info("{}", plusOne(new int[]{1, 9, 9}));
  }

  public int[] plusOne(int[] digits) {

    if (digits == null || digits.length == 0) {
      return new int[]{1};
    }

    // add one
    boolean hasCarry = true;
    for (int i = digits.length - 1; i >= 0; i--) {
      if (hasCarry) {
        if (digits[i] == 9) {
          hasCarry = true;
          digits[i] = 0;
        } else {
          digits[i] += 1;
          hasCarry = false;
        }
      }
    }

    // final hasCarry?
    if (hasCarry) {
      int[] ret = new int[digits.length + 1];
      ret[0] = 1;
      for (int i = 0; i < digits.length; i++) {
        ret[i + 1] = digits[i];
      }
      return ret;
    } else {
      return digits;
    }
  }
}
