package com.util;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class ArraysUtil {

  private ArraysUtil() {
    throw new IllegalStateException("Utility class");
  }

  public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      System.out.println(Arrays.toString(row));
    }
    System.out.println();
  }
}
