package com.leetcode.Weekly42;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC645SetMismatch {

  public static void main(String[] args) {
    testSetMismatch_645();
  }

  private static void testSetMismatch_645() {
    LC645SetMismatch LC645SetMismatch = new LC645SetMismatch();
    log.info("result [2,3] = " + Arrays.toString(LC645SetMismatch.findErrorNums(new int[]{1, 2, 2, 4})));
//        log.info("result 1 = " + SetMismatch_645.findErrorNums("10"));
  }

  /**
   * @param nums
   * @return
   */
  public int[] findErrorNums(int[] nums) {
    if (nums == null || nums.length < 1) {
      return new int[2];
    }

    int len = nums.length;
    int[] counter = new int[len + 1];
    for (int num : nums) {
      counter[num]++;
    }

    int duplica = Integer.MIN_VALUE;
    int missing = Integer.MIN_VALUE;
    for (int i = 1; i <= len; i++) {
      if (counter[i] == 2) {
        duplica = i;
      } else if (counter[i] == 0) {
        missing = i;
      }
    }

    return new int[]{duplica, missing};
  }

}
