package com.NineChapters.CombinationBasedDFSAndMemoizationSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CombinationSum_135 {

  public static void main(String[] args) {
    testCombinationSum_135();
  }

  private static void testCombinationSum_135() {
    log.info("result [[7],[2,2,3]] v.s. {}", combinationSum(new int[]{2, 3, 6, 7}, 7));
  }

  public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    // filter abnormal cases
    if (candidates == null || candidates.length == 0) {
      return new LinkedList<>();
    }

    Arrays.sort(candidates);
    List<List<Integer>> results = new ArrayList<>();
    dfs(candidates, target, 0, new ArrayList<>(), results);

    // return the final result
    return results;
  }

  private static void dfs(int[] candidates, int target, int index, List<Integer> combination,
      List<List<Integer>> results) {
    if (index == candidates.length) {
      if (target == 0) {
        results.add(new ArrayList<>(combination));
      }
      return;
    }

    if (target < 0) {
      return;
    }

    // skip the candidate
    dfs(candidates, target, index + 1, combination, results);

    if (index > 0 && candidates[index] == candidates[index - 1]) {
      return;
    }

    // recruit the candidate
    combination.add(candidates[index]);
    dfs(candidates, target - candidates[index], index, combination, results);
    combination.remove(combination.size() - 1);
  }

}
