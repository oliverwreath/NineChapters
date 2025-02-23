package com.ATemplatesDataStructures.Array;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No479_SecondMaxOfArray {

  public static void main(String[] args) {
    No479_SecondMaxOfArray No479_SecondMaxOfArray = new No479_SecondMaxOfArray();
    No479_SecondMaxOfArray.testNo479_SecondMaxOfArray();
  }

  private void testNo479_SecondMaxOfArray() {
//        log.info("result 2 v.s. " + secondMax(null));
//        log.info("result 2 v.s. " + secondMax(new int[]{3}));
    log.info("result 5 v.s. " + secondMax(new int[]{3, 5, 7}));
  }

  int secondMax(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int max = Integer.MIN_VALUE;
    int secondMax = Integer.MIN_VALUE;
    for (int a : A) {
      if (max < a) {
        secondMax = max;
        max = a;
      } else if (secondMax < a) {
        secondMax = a;
      }
    }

    // return the final result
    return secondMax;
  }

}
