package com.lintcode.DataStructures;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Author: Oliver
 */
@Slf4j
public class Topk {
  public static void main(String[] arg) {
    testTopk();
  }

  private static void testTopk() {
    log.info("{}", topk(new int[]{3, 10, 1000, -99, 4, 100}, 3));
  }

  static int[] topk(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return nums;
    }

    PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, Collections.<Integer>reverseOrder());
    for (int i = 0; i < nums.length; i++) {
      heap.add(nums[i]);
    }
    int[] ret = new int[k];
    for (int i = 0; i < k; i++) {
      ret[i] = heap.poll();
    }
//        Arrays.sort(nums);
//        int[] ret = new int[k];
//        for (int i = 0; i < k; i++) {
//            ret[i] = nums[nums.length - 1 - i];
//        }
    return ret;
  }
}
