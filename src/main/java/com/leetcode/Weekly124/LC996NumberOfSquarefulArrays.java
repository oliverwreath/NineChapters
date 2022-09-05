package com.leetcode.Weekly124;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
@Slf4j
public class LC996NumberOfSquarefulArrays {
  public int numSquarefulPerms(int[] nums) {
    // filter abnormal cases
    if (nums == null || nums.length == 0) {
      return 0;
    }

    // dp logic
    HashSet<List<Integer>> set = new HashSet<>();
    List<List<Integer>> permutes = permute(nums);
    for (List<Integer> permute : permutes) {
      if (isSquareful(permute)) {
        set.add(permute);
      }
    }
//        if (isSquareful(getNextPerm(nums))) {
//            count++;
//        }

    // return the final result
    return set.size();
  }

  private boolean isSquareful(List<Integer> nums) {
    for (int i = 1; i < nums.size(); i++) {
      if (!isSquareful(nums.get(i - 1), nums.get(i))) {
        return false;
      }
    }
    return true;
  }

  private boolean isSquareful(int i, int i2) {
    int root = (int) Math.sqrt(i + i2);
    return root * root == i + i2;
  }

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

//    private int[] getNextPerm(int[] nums) {
//        return nums;
//    }
}
