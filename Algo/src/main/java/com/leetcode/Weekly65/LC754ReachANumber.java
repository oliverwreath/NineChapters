package com.leetcode.Weekly65;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC754ReachANumber {

  public static void main(String[] args) {
    testNo754_ReachANumber();
  }

  private static void testNo754_ReachANumber() {
    LC754ReachANumber LC754ReachANumber = new LC754ReachANumber();
    log.info("result 2 v.s. " + LC754ReachANumber.reachNumber(3));
    log.info("result 3 v.s. " + LC754ReachANumber.reachNumber(2));
    for (int i = 0; i < 13; i++) {
      log.info(i + ": result ? v.s. " + LC754ReachANumber.reachNumber(i));
    }
  }

  /**
   * @param target
   * @return
   */
  public int reachNumber(int target) {
    // filter abnormal inputs
    if (target == 0) {
      return 0;
    }
    if (target < 0) {
      target = -target;
    }

    // core logic
    int i = 0;
    int sum = 0;
    while (true) {
      i++;
      sum += i;
      if (sum < target) {
        continue;
      } else if (sum > target) {
        if ((sum - target) % 2 == 0) {
          return i;
        } else {
          continue;
        }
      } else {
        return i;
      }
    }
  }

}
