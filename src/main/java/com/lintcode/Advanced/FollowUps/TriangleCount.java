package com.lintcode.Advanced.FollowUps;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Author: Oliver
 */
@Slf4j
public class TriangleCount {
  public static void main(String[] arg) {
    new TriangleCount().testKthLargestInNArrays();
  }

  private void testKthLargestInNArrays() {
    log.info("{}", triangleCount(new int[]{3, 4, 6, 7}));
    log.info("{}", triangleCount(new int[]{4, 4, 4, 4}));
    log.info("{}", triangleCount(new int[]{8990, 3146, 9568, 3889, 7253, 7395, 10032, 6179, 1299, 8738, 1315, 1280, 830, 6593}));
  }

  /**
   * @param S: A list of integers
   * @return: An integer
   */
  public int triangleCount(int S[]) {

    if (S == null || S.length < 3) {
      return 0;
    }

    int n = S.length;
    int counter = 0;
    Arrays.sort(S);
    for (int i = n - 1; i > 1; i--) {
      int z = i;
      int x = 0;
      int y = i - 1;
      while (x < y) {
        if (S[x] + S[y] > S[z]) {
          counter += y - x;
//                    log.debug("x = " + x + "; y = " + y + "; z = " + z);
          y--;
        } else {
          x++;
        }
      }
    }

    return counter;
  }
}
