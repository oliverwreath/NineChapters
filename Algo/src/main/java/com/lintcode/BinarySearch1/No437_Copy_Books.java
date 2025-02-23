package com.lintcode.BinarySearch1;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class No437_Copy_Books {

  public static void main(String[] arg) {
    test();
  }

  private static void test() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    log.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    log.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param pages: an array of integers
   * @param k:     An integer
   * @return: an integer
   */
  public int copyBooks(int[] pages, int k) {

    return -1;
  }
}
