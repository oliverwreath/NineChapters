package com.leetcode.Weekly49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC675CutOffTree {

  public static void main(String[] args) {
    testCutOffTree_675();
  }

  private static void testCutOffTree_675() {
    LC675CutOffTree LC675CutOffTree = new LC675CutOffTree();
    List<List<Integer>> list = new ArrayList<>();
    list.add(Arrays.asList(1, 2, 3));
    list.add(Arrays.asList(0, 0, 4));
    list.add(Arrays.asList(7, 6, 5));
    log.info("result 6 = " + LC675CutOffTree.cutOffTree(list));
    list.clear();
    list.add(Arrays.asList(1, 2, 3));
    list.add(Arrays.asList(0, 0, 0));
    list.add(Arrays.asList(7, 6, 5));
    log.info("result -1 = " + LC675CutOffTree.cutOffTree(list));
    list.clear();
    list.add(Arrays.asList(2, 3, 4));
    list.add(Arrays.asList(0, 0, 5));
    list.add(Arrays.asList(8, 7, 6));
    log.info("result 6 = " + LC675CutOffTree.cutOffTree(list));
  }

  /**
   * @param forest
   * @return
   */
  public int cutOffTree(List<List<Integer>> forest) {
    // filter abnormal inputs
    if (forest == null || forest.size() < 1 || forest.get(0) == null || forest.get(0).size() < 1) {
      return 0;
    }

    int length = forest.size();
    return -1;
  }

}
