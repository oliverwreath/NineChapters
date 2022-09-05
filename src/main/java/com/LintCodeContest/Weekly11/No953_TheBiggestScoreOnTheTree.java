package com.LintCodeContest.Weekly11;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No953_TheBiggestScoreOnTheTree {
  public static void main(String[] args) {
    No953_TheBiggestScoreOnTheTree No953_TheBiggestScoreOnTheTree = new No953_TheBiggestScoreOnTheTree();
//        No953_TheBiggestScoreOnTheTree.testNo953_TheBiggestScoreOnTheTree();
  }

//    private void testNo953_TheBiggestScoreOnTheTree() {
//        log.info("result 3 v.s. " + getMaxScore(new int[]{0, 0, 0}, new int[]{1, 2, 3}, new int[]{1, 1, 1}, new int[]{1, 1, 2, 3}));
//        log.info("result 4 v.s. " + getMaxScore(new int[]{0, 0}, new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2, 5}));
//        log.info("result 3 v.s. " + getMaxScore(new int[]{0, 0, 0, 0}, new int[]{1, 2, 3, 4}, new int[]{2, 2, 1, 1}, new int[]{1, 4, 4, 3, 3}));
//        log.info("result 104 v.s. " + getMaxScore(new int[]{0, 1, 2, 3, 3, 3, 1, 7, 1}, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{47, 48, 44, 95, 84, 61, 51, 86, 43}, new int[]{77, 41, 27, 19, 71, 17, 35, 84, 61, 2}));
//    }


//    int getMaxScore(int[] x, int[] y, int[] cost, int[] profit) {
////         filter abnormal cases
//        if (x == null || x.length == 0) {
//            return 0;
//        }
//
//        int max = profit[1] - cost[0];
//        for (int i = 1; i < y.length; i++) {
//            max = Math.max(max, profit[i + 1] - cost[i]);
//        }
//        max += profit[0];
//
//        // return the final result
//        return max;
//    }

}
