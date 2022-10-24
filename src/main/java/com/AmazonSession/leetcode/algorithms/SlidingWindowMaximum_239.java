package com.AmazonSession.leetcode.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SlidingWindowMaximum_239 {

  public static void main(String[] arg) {
    new SlidingWindowMaximum_239().testSearchA2DMatrix_74();
  }

  private void testSearchA2DMatrix_74() {
    int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
    log.info("{} ? = {}", Arrays.toString(nums), maxSlidingWindow(nums, 3));
  }

  /**
   * @param nums
   * @param k
   * @return
   */
  public int[] maxSlidingWindow(int[] nums, int k) {

    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    if (k == 1) {
      return nums;
    }
    int n = nums.length;
    int[] ans = new int[n + 1 - k];
    MyDeque myDeque = new MyDeque();
    for (int i = 0; i < nums.length; i++) {
      log.info(String.valueOf(nums[i]));
      // add
      myDeque.add(nums[i]);
      log.info(String.valueOf(myDeque));
      // del
      if (i >= k) {
        myDeque.del(nums[i - k]);
      }
      log.info(String.valueOf(myDeque));

      // get
      if (i >= k - 1) {
        ans[i - k + 1] = myDeque.get();
      }
    }

    return ans;
  }

  private class MyDeque {

    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

    public MyDeque() {
    }

    public void add(int num) {
      // add
      while (!deque.isEmpty() && deque.peekLast() < num) {
        deque.pollLast();
      }
      deque.addLast(num);
    }

    public int get() {
      return deque.getFirst();
    }

    public void del(int num) {
      if (deque.peekFirst() == num) {
        deque.pollFirst();
      }
    }

    @Override
    public String toString() {
      return "MyDeque{" +
          "deque=" + deque +
          '}';
    }
  }
}
