package com.HackerRank;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LogestSubarray {
  public static void main(String[] args) {
    testMaxLength();
  }

  static void testMaxLength() {
    log.debug("{}", maxLength(new int[]{1, 2, 3}, 4));
    log.debug("{}", maxLength(new int[]{3, 1, 2, 1}, 4));
  }

  static int maxLength(int[] a, int k) {
    int len = a.length;

    int maxLen = 0;
    for (int i = 0; i < len; i++) {
      long sum = 0;
      for (int j = i; j < len; j++) {
        sum += a[j];
        if (sum <= k) {
          maxLen = Math.max(maxLen, j - i + 1);
        } else {
          break;
        }
      }
    }

    return maxLen;
  }
}
