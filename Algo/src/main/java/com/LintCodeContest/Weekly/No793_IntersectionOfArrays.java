package com.LintCodeContest.Weekly;

import java.util.HashSet;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No793_IntersectionOfArrays {

  public static void main(String[] args) {
    testNo793_IntersectionOfArrays();
  }

  private static void testNo793_IntersectionOfArrays() {
    No793_IntersectionOfArrays No793_IntersectionOfArrays = new No793_IntersectionOfArrays();
    log.info("result 1 v.s. " + No793_IntersectionOfArrays.intersectionOfArrays(new int[][]{
        {1, 2, 3},
        {3, 4, 5},
        {3, 9, 10}
    }));
    log.info("result 2 v.s. " + No793_IntersectionOfArrays.intersectionOfArrays(new int[][]{
        {1, 2, 3, 4},
        {1, 2, 5, 6, 7},
        {9, 10, 1, 5, 2, 3}
    }));
  }

  /**
   * @param arrs
   * @return
   */
  public int intersectionOfArrays(int[][] arrs) {

    // filter abnormal cases
    if (arrs == null || arrs.length == 0 || arrs[0].length == 0) {
      return 0;
    }

    int m = arrs.length;
    HashSet<Integer> set = new HashSet<>();
    for (int i : arrs[0]) {
      set.add(i);
    }
    HashSet<Integer> set2 = new HashSet<>();
    for (int i = 1; i < m; i++) {
      if (i % 2 == 1) {
        set2.clear();
        for (int num : arrs[i]) {
          if (set.contains(num)) {
            set2.add(num);
          }
        }
      } else {
        set.clear();
        for (int num : arrs[i]) {
          if (set2.contains(num)) {
            set.add(num);
          }
        }
      }
    }

    // return the final result
    log.debug("set = " + set);
    log.debug("set2 = " + set2);
    if ((m - 1) % 2 == 1) {
      log.debug("set2 = ");
      return set2.size();
    } else {
      log.debug("set1 = ");
      return set.size();
    }
  }

}
