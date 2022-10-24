package com.lintcode.Naive;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SortIntegers {

  public static void main(String[] arg) {
    new SortIntegers().testSortIntegers();
  }

  private void testSortIntegers() {
    int[] ints = {3, 2, 1, 4, 5};
    sortIntegers(ints);
    log.info("{}", Arrays.toString(ints));
  }

  /**
   * @param A an integer array
   * @return void
   */
  public void sortIntegers(int[] A) {

    if (A == null || A.length == 0) {
      return;
    }

    Arrays.sort(A);

    return;
  }
}
