package com.ATemplatesDataStructures.FollowUp7.DFS;

import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * plain old dfs, nice practice
 */
@Slf4j
public class No551_NestedListWeightSum {

  public static void main(String[] args) {
    No551_NestedListWeightSum No551_NestedListWeightSum = new No551_NestedListWeightSum();
    No551_NestedListWeightSum.testNo551_NestedListWeightSum();
  }

  private void testNo551_NestedListWeightSum() {
    log.info("result 2 v.s. " + depthSum(null));
  }

  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer,
    // rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds,
    // if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds,
    // if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public int depthSum(List<NestedInteger> nestedList) {
    // filter abnormal cases
    if (nestedList == null || nestedList.size() == 0) {
      return 0;
    }

    this.sum = 0;
    dfs(1, nestedList);

    // return the final result
    return sum;
  }

  int sum;

  void dfs(int depth, List<NestedInteger> nestedList) {
    for (NestedInteger nestedInteger : nestedList) {
      if (nestedInteger.isInteger()) {
        sum += depth * nestedInteger.getInteger();
      } else {
        dfs(depth + 1, nestedInteger.getList());
      }
    }
  }

}
