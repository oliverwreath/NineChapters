package com.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class LC46Permutations {
  public List<List<Integer>> permute(int[] nums) {
    if (nums == null || nums.length == 0)
      return Collections.emptyList();

    List<List<Integer>> finalResult = new ArrayList<>();
    permuteDfs(nums, finalResult, new ArrayList<>(), new boolean[nums.length]);
    return finalResult;
  }

  private void permuteDfs(int[] nums, List<List<Integer>> finalResult, List<Integer> currResult, boolean[] used) {
    if (currResult.size() == nums.length) {
      finalResult.add(new ArrayList<>(currResult));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i])
        continue;

      currResult.add(nums[i]);
      used[i] = true;
      permuteDfs(nums, finalResult, currResult, used);
      used[i] = false;
      currResult.remove(currResult.size() - 1);
    }
  }
}
