package com.lintcode.Advanced.Heap;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class DataStreamMedian {

  public static void main(String[] arg) {
    new DataStreamMedian().testTrappingRainWater();
  }

  private void testTrappingRainWater() {
    log.info("1, 1, 2, 2, 3 = {}", medianII(new int[]{1, 2, 3, 4, 5}));
    log.info("4, 4, 4, 3, 3, 3, 3 = {}", medianII(new int[]{4, 5, 1, 3, 2, 6, 0}));
    log.info("2, 2, 20 = {}", medianII(new int[]{2, 20, 100}));
  }

  /**
   * @param nums: A list of integers.
   * @return: the median of numbers
   */
  public int[] medianII(int[] nums) {

    // handle extreme inputs
    if (nums == null || nums.length < 1) {
      return new int[0];
    }

    int len = nums.length;
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len, (o1, o2) -> o2 - o1);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(len);

    int[] answer = new int[len];
    for (int i = 0; i < len; i++) {
      if (maxHeap.size() <= minHeap.size()) {
        if (minHeap.isEmpty() || minHeap.peek() > nums[i]) {
          maxHeap.add(nums[i]);
        } else {
          maxHeap.add(minHeap.poll());
          minHeap.add(nums[i]);
        }
      } else {
        if (maxHeap.peek() < nums[i]) {
          minHeap.add(nums[i]);
        } else {
          minHeap.add(maxHeap.poll());
          maxHeap.add(nums[i]);
        }
      }

      answer[i] = maxHeap.peek();
    }

    return answer;
  }
}
