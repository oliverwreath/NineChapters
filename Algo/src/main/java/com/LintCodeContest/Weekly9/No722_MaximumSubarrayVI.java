package com.LintCodeContest.Weekly9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No722_MaximumSubarrayVI {

  public static void main(String[] args) {
    No722_MaximumSubarrayVI No722_MaximumSubarrayVI = new No722_MaximumSubarrayVI();
    No722_MaximumSubarrayVI.testNo722_MaximumSubarrayVI();
  }

  private void testNo722_MaximumSubarrayVI() {
    log.info("result 7 v.s. " + maxXorSubarray(new int[]{1, 2, 3, 4}));
    log.info("result 15 v.s. " + maxXorSubarray(new int[]{8, 1, 2, 12, 7, 6}));
    log.info("result 6 v.s. " + maxXorSubarray(new int[]{4, 6}));
  }

  int maxXorSubarray(int[] A) {
    // filter abnormal cases
    if (A == null || A.length == 0) {
      return 0;
    }

    int n = A.length;
    int[] global = new int[n];
    global[0] = A[0];
    int max = global[0];
    for (int i = 1; i < n; i++) {
      global[i] = global[i - 1] | A[i];
      max = Math.max(max, global[i]);
    }

    for (int i = 1; i < n; i++) {
      for (int j = i; j < n; j++) {
//                if (i == 0) {
//                    max = Math.max(max, global[j]);
//                } else {
        max = Math.max(max, global[j] | global[i - 1]);
//                }
      }
    }

    // return the final result
    return max;
  }

}
