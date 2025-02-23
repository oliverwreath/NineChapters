package com.LintCodeContest.Weekly6;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No824_SingleNumberIV {

  public static void main(String[] args) {
    No824_SingleNumberIV No824_SingleNumberIV = new No824_SingleNumberIV();
    No824_SingleNumberIV.testNo824_SingleNumberIV();
  }

  private void testNo824_SingleNumberIV() {
    log.info("result 4 v.s. " + getSingleNumber(new int[]{3, 3, 2, 2, 4, 5, 5}));
    log.info("result 2 v.s. " + getSingleNumber(new int[]{2, 1, 1, 3, 3}));
    log.info("result 2 v.s. " + getSingleNumber(new int[]{1, 1, 3, 3, 2}));
    log.info("result 3 v.s. " + getSingleNumber(new int[]{3}));
  }

  int getSingleNumber(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    for (int i = 0; i < A.length; i += 2) {
      if (i + 1 >= A.length) {
        return A[A.length - 1];
      }
      if (A[i] != A[i + 1]) {
        return A[i];
      }
    }

    // return the final result
    return -1;
  }

}
