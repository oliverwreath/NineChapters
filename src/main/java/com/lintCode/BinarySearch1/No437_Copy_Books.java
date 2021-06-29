package com.lintCode.BinarySearch1;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: Oliver
 */
@Slf4j
public class No437_Copy_Books {
  private static final Logger logger = LoggerFactory.getLogger(No460_KClosestNumbers.class);

  public static void main(String[] arg) {
    testKClosestNumbers();
  }

  private static void testKClosestNumbers() {
    No437_Copy_Books no437_Copy_Books = new No437_Copy_Books();
    logger.info("5 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 2));
    logger.info("4 = {}", no437_Copy_Books.copyBooks(new int[]{3, 2, 4}, 3));
  }

  /**
   * @param pages: an array of integers
   * @param k:     An integer
   * @return: an integer
   */
  public int copyBooks(int[] pages, int k) {
    // write your code here
    return -1;
  }
}
