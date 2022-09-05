package com.leetcode.Weekly38;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC629KInversePairsArray {
  public static void main(String[] args) {
    LC629KInversePairsArray LC_629KInversePairsArray = new LC629KInversePairsArray();
    log.debug("result = 1 = " + LC_629KInversePairsArray.kInversePairs(3, 0));
    log.debug("result = 1 = " + LC_629KInversePairsArray.kInversePairs(3, 1));
  }

  public int kInversePairs(int n, int k) {
    if (n == 1) {
      if (k == 0) {
        return 1;
      } else {
        return 0;
      }
    }
    if (n == 2) {
      if (k == 0) {
        return 1;
      } else if (k == 1) {
        return 1;
      } else {
        return 0;
      }
    }
//        3
//        0 1
//        1 2
//        2 2
//        3 1

//        4 4 * 3 * 2
//        0 1
//        1 3
//        2
//        3
//        4
//        5 3
//        6 1

    return -1;
  }

}
//109 + 7
