package com.Logistics;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. TIME: O(?) SPACE: O(?)
 */
@Slf4j
public class NeedNumberOfTrucks {

  public static void main(String[] args) {
    NeedNumberOfTrucks thisClass = new NeedNumberOfTrucks();
    thisClass.testNeedNumberOfTrucks();
  }

  private void testNeedNumberOfTrucks() {
//        log.info("result {} v.s. {}", "", longestContinuousIncreasingSubsequence2(new int[][]{
//                {1, 2, 3, 4, 5}
//        }));
  }

  public int functionName(int[][] grid) {
    // filter abnormal cases
    if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
      return 0;
    }

    // dp logic
    int m = grid.length, n = grid[0].length;
    int[][] dp = new int[2][n];

    // return the final result
    return -1;
  }

}
