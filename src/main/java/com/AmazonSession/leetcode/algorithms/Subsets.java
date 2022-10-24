package com.AmazonSession.leetcode.algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;

@Slf4j
public class Subsets {

  public static void main(String[] args) {
    testSubsets();
  }

  private static void testSubsets() {
    Subsets Subsets = new Subsets();
    log.info("result 2 v.s. " + Subsets.subsets(new int[]{1, 2, 3}));
  }

  /**
   * @param nums
   * @return
   */
  public List<List<Integer>> subsets(int[] nums) {
    if (nums == null || nums.length < 1) {
      return new LinkedList<>();
    }

    // main logic
    int len = nums.length;
    List<List<Integer>> result = new LinkedList<>();
    result.add(new LinkedList<>());
    result.add(Arrays.asList(ArrayUtils.toObject(nums)));
    for (int num : nums) {
      LinkedList<Integer> tmp = new LinkedList<>();
      tmp.add(num);
      result.add(tmp);
    }
    for (int count = 2; count < len; count++) {
      int currentCount = 0;
      while (currentCount < count) {

      }
    }

    return result;
  }

}
