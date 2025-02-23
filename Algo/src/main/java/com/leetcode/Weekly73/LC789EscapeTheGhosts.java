package com.leetcode.Weekly73;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC789EscapeTheGhosts {

  public static void main(String[] args) {
    LC789EscapeTheGhosts LC789EscapeTheGhosts = new LC789EscapeTheGhosts();
    LC789EscapeTheGhosts.testNo789_EscapeTheGhosts();
  }

  private void testNo789_EscapeTheGhosts() {
    log.info("result true v.s. " + escapeGhosts(new int[][]{
        {1, 0},
        {0, 3}
    }, new int[]{0, 1}));
    log.info("result false v.s. " + escapeGhosts(new int[][]{
        {1, 0}
    }, new int[]{2, 0}));
    log.info("result false v.s. " + escapeGhosts(new int[][]{
        {2, 0}
    }, new int[]{1, 0}));
  }

  boolean escapeGhosts(int[][] ghosts, int[] target) {
    // filter abnormal cases
//        if (A == null || A.length == 0) {
//            return 0;
//        }
    if (ghosts == null || ghosts.length == 0) {
      return true;
    }
    int myDistance = getDistance(new int[]{0, 0}, target);
    int m = ghosts.length;
    for (int i = 0; i < m; i++) {
      int tmpDistance = getDistance(ghosts[i], target);
      if (tmpDistance <= myDistance) {
        return false;
      }
    }

    // return the final result
    return true;
  }

  int getDistance(int[] source, int[] target) {
    return Math.abs(source[0] - target[0]) + Math.abs(source[1] - target[1]);
  }

}
