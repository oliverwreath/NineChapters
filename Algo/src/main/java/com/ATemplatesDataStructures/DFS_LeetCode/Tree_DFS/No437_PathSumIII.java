package com.ATemplatesDataStructures.DFS_LeetCode.Tree_DFS;

import com.util.TreeNode;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No437_PathSumIII {

  public static void main(String[] args) {
    testNo437_PathSumIII();
  }

  private static void testNo437_PathSumIII() {
    No437_PathSumIII No113_PathSumII = new No437_PathSumIII();
    TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(-3);
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum(root, 7));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum(root, 10));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum(root, 5));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum(root, -3));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum(root, 15));
//        log.info("result 0 v.s. " + No113_PathSumII.pathSum(root, 0));
//        log.info("result 0 v.s. " + No113_PathSumII.pathSum(root, 1));
//        log.info("result 0 v.s. " + No113_PathSumII.pathSum(root, 2));

    root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.right = new TreeNode(1);
    log.info("result 4 v.s. " + No113_PathSumII.pathSum(root, 1));
//        log.info("result 1 v.s. " + No113_PathSumII.pathSum("10"));
  }

  /**
   * @param root
   * @param sum
   * @return
   */
  public int pathSum(TreeNode root, int sum) {
    // filter abnormal inputs
    if (root == null) {
      return 0;
    }

    // DFS
    this.target = sum;
    resultCounter = 0;
    pathSumHelper(root, new HashMap<>());

    // wrap up
    return resultCounter;
  }

  private int target;
  private int resultCounter;

  private void pathSumHelper(TreeNode node, HashMap<Integer, Integer> sumsSoFar) {
    if (node == null) {
      return;
    }
    if (!sumsSoFar.containsKey(0)) {
      sumsSoFar.put(0, 1);
    } else {
      sumsSoFar.put(0, sumsSoFar.get(0) + 1);
    }
    HashMap<Integer, Integer> sumForLeft = new HashMap<>();
    for (Integer key : sumsSoFar.keySet()) {
      int newKey = key + node.val;
      sumForLeft.put(newKey, sumsSoFar.get(key));
      if (newKey == target) {
        resultCounter += sumForLeft.get(newKey);
      }
    }
//        log.debug("node.val = " + node.val);
//        log.debug("sumsSoFar = " + sumsSoFar);
//        log.debug("sumForLeft = " + sumForLeft);
    HashMap<Integer, Integer> sumsForRight = new HashMap<>(sumForLeft);
    if (node.left != null) {
      pathSumHelper(node.left, sumForLeft);
    }
    if (node.right != null) {
      pathSumHelper(node.right, sumsForRight);
    }
  }

}
