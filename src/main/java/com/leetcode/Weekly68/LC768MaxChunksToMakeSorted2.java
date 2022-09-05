package com.leetcode.Weekly68;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;

@Slf4j
public class LC768MaxChunksToMakeSorted2 {
  public static void main(String[] args) {
    testNo768_MaxChunksToMakeSorted2();
  }

  private static void testNo768_MaxChunksToMakeSorted2() {
    LC768MaxChunksToMakeSorted2 LC768MaxChunksToMakeSorted2 = new LC768MaxChunksToMakeSorted2();
    log.info("result 1 v.s. " + LC768MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{5, 4, 3, 2, 1}));
    log.info("result 4 v.s. " + LC768MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
    log.info("result 3 v.s. " + LC768MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{1, 0, 1, 3, 2}));
    log.info("result 2 v.s. " + LC768MaxChunksToMakeSorted2.maxChunksToSorted(new int[]{1, 1, 0, 0, 1}));
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
    int max = arr[0];
    int cutCounter = 1;
    int[] copy = Arrays.copyOf(arr, arr.length);
    Arrays.sort(copy);
//        log.debug(Arrays.toString(copy));
//        log.debug(Arrays.toString(arr));
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length - 1; i++) {
//            log.debug("i = " + i);
//            log.debug("map = " + map);
      if (stepAndIsEmpty(copy[i], arr[i], map)) {
//                log.debug("Got a cut! i = " + i);
//                log.debug("copy[i] = " + copy[i]);
//                log.debug("arr[i] = " + arr[i]);
        cutCounter++;
      }
    }

    // return the final result
    return cutCounter;
  }

  private boolean stepAndIsEmpty(int keyToAdd, int keyToKill, HashMap<Integer, Integer> map) {
    if (keyToAdd != keyToKill) {
      if (map.containsKey(keyToAdd)) {
        if (map.get(keyToAdd) + 1 == 0) {
          map.remove(keyToAdd);
        } else {
          map.put(keyToAdd, map.get(keyToAdd) + 1);
        }
      } else {
        map.put(keyToAdd, 1);
      }
      if (map.containsKey(keyToKill)) {
        if (map.get(keyToKill) - 1 == 0) {
          map.remove(keyToKill);
        } else {
          map.put(keyToKill, map.get(keyToKill) - 1);
        }
      } else {
        map.put(keyToKill, -1);
      }
    }
    return map.isEmpty();
  }

}
