package com.leetcode.Weekly73;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC788RotatedDigits {
  public static void main(String[] args) {
    LC788RotatedDigits LC788RotatedDigits = new LC788RotatedDigits();
    LC788RotatedDigits.testNo788_RotatedDigits();
  }

  private void testNo788_RotatedDigits() {
    log.info("result 4 v.s. " + rotatedDigits(10));
    log.info("result 247 v.s. " + rotatedDigits(857));
  }

  public int rotatedDigits(int N) {
    // filter abnormal cases
    int count = 0;
    this.N = N;
    for (int i = 1; i <= N; i++) {
      if (isGood(i)) {
        count++;
      }
    }

    // return the final result
    return count;
  }

  int N;
  int[] change = new int[]{0, 0, 5, -1, -1, 2, 9, -1, 0, 6};

  private boolean isGood(int i) {
    boolean isChange = false;
    while (i > 0) {
      int digit = i % 10;
      i /= 10;
      if (change[digit] == -1) {
        return false;
      } else if (change[digit] != 0) {
        isChange = true;
      }
    }
    return isChange;
  }

}
