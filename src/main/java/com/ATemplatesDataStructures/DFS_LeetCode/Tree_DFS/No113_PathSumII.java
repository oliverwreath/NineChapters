package com.ATemplatesDataStructures.DFS_LeetCode.Tree_DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

@Slf4j
public class No113_PathSumII {
  public static void main(String[] args) {
    testNo113_PathSumII();
  }

  private static void testNo113_PathSumII() {
    No113_PathSumII No113_PathSumII = new No113_PathSumII();
//        log.info("result 2 v.s. " + No113_PathSumII.pathSum("12"));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum("10"));
  }

  /**
   * @param root
   * @param sum
   * @return
   */
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    if (root == null) {
      return new LinkedList<>();
    }

    // DFS
    this.target = sum;
    globalResult = new LinkedList<>();
    pathSumHelper(root, 0, new LinkedList<>());
    return globalResult;
  }

  private int target;
  private List<List<Integer>> globalResult;

  private void pathSumHelper(TreeNode node, int sum, List<Integer> resultSoFar) {
    if (node.left == null && node.right == null) {
      if (sum + node.val == target) {
        resultSoFar.add(node.val);
        globalResult.add(resultSoFar);
        return;
      }
    }
    sum += node.val;
    resultSoFar.add(node.val);
    List<Integer> resultForRight = new LinkedList<>(resultSoFar);
    if (node.left != null) {
      pathSumHelper(node.left, sum, resultSoFar);
    }
    if (node.right != null) {
      pathSumHelper(node.right, sum, resultForRight);
    }
  }

}
