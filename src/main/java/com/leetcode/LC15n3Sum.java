package com.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Author: Oliver
 */
@Slf4j
public class LC15n3Sum {
  public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new LinkedList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i - 1] == nums[i])
        continue;
      int ii = nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        if (nums[left] + nums[right] == 0 - ii) {
          res.add(List.of(ii, nums[left], nums[right]));
          left++;
          right--;
          while (left < right && nums[left - 1] == nums[left]) {
            left++;
          }
        } else if (nums[left] + nums[right] < 0 - ii) {
          left++;
        } else {
          right--;
        }
      }
    }
    return res;
  }
}
