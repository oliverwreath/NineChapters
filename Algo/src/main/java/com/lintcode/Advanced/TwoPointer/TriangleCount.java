package com.lintcode.Advanced.TwoPointer;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class TriangleCount {

  public static void main(String[] arg) {
    new TriangleCount().testTwoSumII();
  }

  private void testTwoSumII() {
    log.info("{}", triangleCount(new int[]{3, 4, 6, 7}));
    log.info("{}", triangleCount(new int[]{4, 4, 4, 4}));
  }

  /**
   * @param S: A list of integers
   * @return: An integer
   */
  public int triangleCount(int S[]) {

    if (S == null || S.length < 3) {
      return 0;
    }

    // sort
    Arrays.sort(S);
    // two pointer
    int n = S.length;
    int counter = 0;
    for (int k = 2; k < n; k++) {
      int i = 0;
      int j = k - 1;
      while (i < j) {
        if (S[i] + S[j] > S[k]) {
          counter += j - i;
          j--;
        } else {
          i++;
        }
      }
    }

    return counter;
  }
}
