package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import java.util.PriorityQueue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Lintcode81FindMedianFromDataStream {

  public int[] medianII(int[] nums) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int[] result = new int[nums.length];
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    int i = 0;
    for (int num : nums) {
      if (maxHeap.isEmpty()) {
        maxHeap.add(num);
      } else {
        if (maxHeap.size() <= minHeap.size()) {
          if (num <= minHeap.peek()) {
            maxHeap.add(num);
          } else {
            maxHeap.add(minHeap.poll());
            minHeap.add(num);
          }
        } else {
          if (num >= maxHeap.peek()) {
            minHeap.add(num);
          } else {
            minHeap.add(maxHeap.poll());
            maxHeap.add(num);
          }
        }
      }
      result[i++] = maxHeap.peek();
    }

    // return the final result
    return result;
  }
}
