package com.AdvancedAlgorithms.HeapStack.HeapPriorityQueue;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

@Slf4j
public class Lintcode360SlidingWindowMedian {
  private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
  private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

  public List<Integer> medianSlidingWindow(int[] nums, int k) {
    // filter abnormal cases
    if (nums == null || nums.length == 0 || k < 1) {
      return new LinkedList<>();
    }
    if (k == 1) {
      List<Integer> list = new LinkedList<>();
      for (int num : nums) {
        list.add(num);
      }
      return list;
    }

    List<Integer> result = new LinkedList<>();
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    for (int i = 0; i < k; i++) {
      addAndBalance(nums[i]);
    }
    result.add(maxHeap.peek());

    for (int i = k; i < nums.length; i++) {
      addRemoveAndbalance(nums[i], nums[i - k]);
      result.add(maxHeap.peek());
    }

    // return the final result
    return result;
  }

  private void addRemoveAndbalance(int num, int toBeDeleted) {
    removeAndBalance(toBeDeleted);
    addAndBalance(num);
  }

  private void removeAndBalance(int toBeDeleted) {
    if (!minHeap.isEmpty()) {
      if (maxHeap.isEmpty()) {
        minHeap.remove(toBeDeleted);
      } else {
        if (minHeap.peek() > toBeDeleted) {
          maxHeap.remove(toBeDeleted);
        } else {
          minHeap.remove(toBeDeleted);
        }
      }
    }
    balance();
  }

  private void addAndBalance(int num) {
    if (maxHeap.isEmpty()) {
      maxHeap.add(num);
    } else {
      if (maxHeap.peek() < num) {
        minHeap.add(num);
      } else {
        maxHeap.add(num);
      }
    }
    balance();
  }

  private void balance() {
    while (!minHeap.isEmpty() && maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }

    while (!maxHeap.isEmpty() && maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    }
  }
}
