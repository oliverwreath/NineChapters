package com.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver LC295FindMedianFromDataStream
 */
@Slf4j
public class MedianFinder {

  private Queue<Integer> minHeap;
  private Queue<Integer> maxHeap;

  public MedianFinder() {
    minHeap = new PriorityQueue<>();
    maxHeap = new PriorityQueue<>(Collections.reverseOrder());
  }

  public void addNum(int num) {
    maxHeap.add(num);
    minHeap.add(maxHeap.remove());
    if (minHeap.size() > maxHeap.size() + 1) {
      maxHeap.add(minHeap.remove());
    }
  }

  public double findMedian() {
    if (maxHeap.size() < minHeap.size())
      return minHeap.peek();
    else
      return (minHeap.peek() + maxHeap.peek()) / 2.0D;
  }
}
