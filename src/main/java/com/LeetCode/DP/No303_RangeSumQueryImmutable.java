package com.LeetCode.DP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-04.
 */
public class No303_RangeSumQueryImmutable {
    private final static Logger logger = LoggerFactory.getLogger(No303_RangeSumQueryImmutable.class);

    public static void main(String[] arg) {
        new No303_RangeSumQueryImmutable().testRangeSumQueryImmutable_303();
    }

    private void testRangeSumQueryImmutable_303() {
        logger.info("{}", RangeSumQueryImmutable_303());
    }

    int RangeSumQueryImmutable_303() {
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
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
