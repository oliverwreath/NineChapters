package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC128LongestConsecutiveSequence {

  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0)
      return 0;

    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, 1);
    }
    int max = 0;
    for (int num : nums) {
      if (!map.containsKey(num - 1)) {
        int counter = 1, next = num + 1;
        while (map.containsKey(next)) {
          counter++;
          next++;
        }
        max = Math.max(max, counter);
      }
    }
    return max;
  }
}
