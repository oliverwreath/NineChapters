package com.AdvancedAlgorithms.BinarySearchSweepLineHard.Deque;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * deque and space compression. Nicely done!
 */
@Slf4j
public class Lintcode362SlidingWindowMaximum {
  private Deque<Integer> deque = new ArrayDeque<>();

  private void inQueue(int number) {
    while (!deque.isEmpty() && deque.peekLast() < number) {
      deque.pollLast();
    }
    deque.offer(number);
  }

  private void outQueue(int number) {
    if (!deque.isEmpty() && deque.peekFirst() == number) {
      deque.pollFirst();
    }
  }

  public List<Integer> maxSlidingWindow(int[] nums, int k) {
    // filter abnormal cases
    List<Integer> result = new LinkedList<>();
    if (nums == null || nums.length == 0 || k < 1) {
      return result;
    }
    if (k == 1) {
      for (int num : nums) {
        result.add(num);
      }
      return result;
    }

    // Deque with trick
    deque = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      if (i < k - 1) {
        inQueue(nums[i]);
        continue;
      }

      if (i >= k) {
        outQueue(nums[i - k]);
      }
      inQueue(nums[i]);
      result.add(deque.peekFirst());
    }

    // return the final result
    return result;
  }

}
