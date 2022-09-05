package com.LintCodeContest.Weekly;

import lombok.extern.slf4j.Slf4j;

import java.util.PriorityQueue;

@Slf4j
public class No791_MergeNumber {
  public static void main(String[] args) {
    testNo791_MergeNumber();
  }

  private static void testNo791_MergeNumber() {
    No791_MergeNumber No791_MergeNumber = new No791_MergeNumber();
    log.info("result 19 v.s. " + No791_MergeNumber.mergeNumber(new int[]{1, 2, 3, 4}));
    log.info("result 25 v.s. " + No791_MergeNumber.mergeNumber(new int[]{2, 8, 4, 1}));
  }

  /**
   * @param numbers
   * @return
   */
  public int mergeNumber(int[] numbers) {

    // filter abnormal cases
    if (numbers == null || numbers.length == 0) {
      return 0;
    }

//        TreeSet<Integer>

    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int number : numbers) {
      heap.add(number);
    }
    int answer = 0;
    while (!heap.isEmpty()) {
      int poll = heap.poll();
      if (heap.isEmpty()) {
        return answer;
      }
      int poll2 = heap.poll();
      poll2 += poll;
      answer += poll2;
      heap.add(poll2);
    }

    // return the final result
    return answer;
  }

}
