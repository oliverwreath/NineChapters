package com.leetcode.Weekly68;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class LC769MaxChunksToMakeSorted1 {
  public static void main(String[] args) {
    testNo769_MaxChunksToMakeSorted1();
  }

  private static void testNo769_MaxChunksToMakeSorted1() {
    LC769MaxChunksToMakeSorted1 LC769MaxChunksToMakeSorted1 = new LC769MaxChunksToMakeSorted1();
    log.info("result 1 v.s. " + LC769MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{4, 3, 2, 1, 0}));
    log.info("result 4 v.s. " + LC769MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{1, 0, 2, 3, 4}));
    log.info("result 2 v.s. " + LC769MaxChunksToMakeSorted1.maxChunksToSorted(new int[]{1, 2, 3, 0, 4}));
  }

  /**
   * @param arr an array of Integer
   * @return an integer
   */
  public int maxChunksToSorted(int[] arr) {
    // filter abnormal cases
    if (arr == null || arr.length == 0) {
      return 1;
    }

    // core logic
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i], i);
    }
    int minCut = 0;
    int cutCounter = 1;
    for (int i = 0; i < arr.length - 1; i++) {
      int tmpRquire = Math.max(map.get(arr[i]), arr[i]);
      minCut = Math.max(minCut, tmpRquire);
      if (minCut <= i) {
//                log.debug("Got a cut!! minCut = " + minCut);
//                log.debug("cutCounter = " + cutCounter);
//                log.debug("tmpRquire = " + tmpRquire);
//                log.debug("i = " + i);
        minCut = i + 1;
        cutCounter++;
      }
    }

    // return the final result
    return cutCounter;
  }

//    /**
//     * @param arr
//     * @return
//     */
//    public int maxChunksToSorted(int[] arr) {
//        // filter abnormal cases
//        if (arr == null || arr.length == 0) {
//            return 1;
//        }
//
//        // core logic
//        int[] map = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            map[arr[i]] = i;
//        }
//        int minCut = 0;
//        int cutCounter = 1;
//        for (int i = 0; i < arr.length - 1; i++) {
//            int tmpRquire = Math.max(map[arr[i]], arr[i]);
//            minCut = Math.max(minCut, tmpRquire);
//            if (minCut <= i) {
////                log.debug("Got a cut!! minCut = " + minCut);
////                log.debug("cutCounter = " + cutCounter);
////                log.debug("tmpRquire = " + tmpRquire);
////                log.debug("i = " + i);
//                minCut = i + 1;
//                cutCounter++;
//            }
//        }
//
//        // return the final result
//        return cutCounter;
//    }

}
