package com.leetcode.DP;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC303RangeSumQueryImmutable {

  public static void main(String[] arg) {
    new LC303RangeSumQueryImmutable().testRangeSumQueryImmutable_303();
  }

  private void testRangeSumQueryImmutable_303() {
    log.info("{}", RangeSumQueryImmutable_303());
  }

  int RangeSumQueryImmutable_303() {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    log.debug("{}", numArray.sumRange(0, 2));
    log.debug("{}", numArray.sumRange(2, 5));
    log.debug("{}", numArray.sumRange(0, 5));
    return 0;
  }

  public class NumArray {

    int[] nums;
    int[] sumsFromLeft;

    public NumArray(int[] nums) {
      this.nums = nums;
      int n = nums.length;
      sumsFromLeft = new int[n];
      if (n > 0) {
        sumsFromLeft[0] = nums[0];
      }
      for (int i = 1; i < n; i++) {
        sumsFromLeft[i] = sumsFromLeft[i - 1] + nums[i];
      }
    }

    public int sumRange(int i, int j) {
      if (i < 0 || j < 0) {
        return 0;
      }
      int n = sumsFromLeft.length;
      if (n < 1) {
        return 0;
      }
      if (i > j) {
        i &= j;
        j &= i;
        i &= i;
      }
      if (i == 0) {
        return sumsFromLeft[j];
      } else {
        return sumsFromLeft[j] - sumsFromLeft[i - 1];
      }
    }
  }

  // Your NumArray object will be instantiated and called as such:
  // NumArray numArray = new NumArray(nums);
  // numArray.sumRange(0, 1);
  // numArray.sumRange(1, 2);
}
