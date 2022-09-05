package com.leetcode.Weekly74;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC795NumberOfSubarraysWithBoundedMaximum {
  public static void main(String[] args) {
    LC795NumberOfSubarraysWithBoundedMaximum LC795NumberOfSubarraysWithBoundedMaximum = new LC795NumberOfSubarraysWithBoundedMaximum();
    LC795NumberOfSubarraysWithBoundedMaximum.testNo795_NumberOfSubarraysWithBoundedMaximum();
  }

  private void testNo795_NumberOfSubarraysWithBoundedMaximum() {
    log.info("result 3 v.s. " + numSubarrayBoundedMax(new int[]{2, 1, 4, 3}, 2, 3));
  }

  int numSubarrayBoundedMax(int[] A, int L, int R) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    // return the final result
    return -1;
  }

}
