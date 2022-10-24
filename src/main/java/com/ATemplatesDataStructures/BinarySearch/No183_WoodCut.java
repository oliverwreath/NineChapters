package com.ATemplatesDataStructures.BinarySearch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No183_WoodCut {

  public static void main(String[] args) {
    testNo141_SqrtX();
  }

  private static void testNo141_SqrtX() {
    No183_WoodCut No141_SqrtX = new No183_WoodCut();
    log.info("result 114 v.s. " + No141_SqrtX.woodCut(new int[]{232, 124, 456}, 7));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(1));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(2));
//        log.info("result 1 v.s. " + No141_SqrtX.sqrt(3));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(4));
//        log.info("result 2 v.s. " + No141_SqrtX.sqrt(5));
//        log.info("result 3 v.s. " + No141_SqrtX.sqrt(10));
  }

  public int woodCut(int[] L, int k) {
    if (L == null || L.length == 0) {
      return 0;
    }

    int start = 1;
    int end = L[0];
    for (int i = 1; i < L.length; i++) {
      end = Math.max(end, L[i]);
    }
    while (start + 1 < end) {
      int mid = ((end - start) >> 1) + start;
      if (isValid(mid, k, L)) {
        start = mid;
      } else {
        end = mid;
      }
    }

    if (isValid(end, k, L)) {
      return end;
    } else if (isValid(start, k, L)) {
      return start;
    }
    return 0;
  }

  boolean isValid(int len, int k, int[] L) {
    for (int l : L) {
      k -= l / len;
    }
    return k <= 0;
  }

}
