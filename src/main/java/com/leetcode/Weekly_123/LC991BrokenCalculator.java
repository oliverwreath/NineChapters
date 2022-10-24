package com.leetcode.Weekly_123;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working. TIME: O(MN) SPACE: O(MN)
 * <p>
 * Version 2: TBD. TIME: O(?) SPACE: O(?)
 */
@Slf4j
public class LC991BrokenCalculator {

  public int brokenCalc(int startValue, int target) {
    // dp logic
    int step = 0;
    while (target > startValue) {
      if (target % 2 == 1) {
        target++;
      } else {
        target /= 2;
      }
      step++;
    }
    if (startValue == target) {
      return step;
    } else {
      return step + (startValue - target);
    }
  }

//    private int helper(int X, int Y, int step) {
//        log.info(hashMap);
//        log.info("X = " + X + "; Y = " + Y);
//        if (visited.contains(getKey(X, Y))) {
//            return ;
//        }
//        long key = getKey(X, Y);
//        if (hashMap.containsKey(key)) {
//            return hashMap.get(key);
//        }
//
//        if (X == Y) {
//            hashMap.put(key, step);
//            return hashMap.get(key);
//        }
//
//        if (X > Y) {
//            hashMap.put(key, X - Y);
//            return hashMap.get(key);
//        } else if (2 * X <= Y) {
//            hashMap.put(key, helper(2 * X, Y, step + 1));
//            return hashMap.get(key);
//        } else {
//            int d = helper(2 * X, Y, step + 1);
//            int m = helper(X - 1, Y, step + 1);
//            hashMap.put(key, Math.min(d, m));
//            return hashMap.get(key);
//        }
//    }

//    private long getKey(int X, int Y) {
//        return X;
//        return X * 10000000000L + Y;
//    }
}
