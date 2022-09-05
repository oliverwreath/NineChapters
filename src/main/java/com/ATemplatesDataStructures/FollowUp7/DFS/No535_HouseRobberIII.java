package com.ATemplatesDataStructures.FollowUp7.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;

@Slf4j
public class No535_HouseRobberIII {
  public static void main(String[] args) {
    No535_HouseRobberIII No535_HouseRobberIII = new No535_HouseRobberIII();
    No535_HouseRobberIII.testNo535_HouseRobberIII();
  }

  private void testNo535_HouseRobberIII() {
    TreeNode treeNode = new TreeNode(3);
    treeNode.left = new TreeNode(2);
    treeNode.left.right = new TreeNode(3);
    treeNode.right = new TreeNode(3);
    treeNode.right.right = new TreeNode(1);
    log.info("result 7 v.s. " + houseRobber3(treeNode));
  }

  class ResultType {
    int rob;
    int noRob;

    public ResultType(int rob, int noRob) {
      this.rob = rob;
      this.noRob = noRob;
    }

    public ResultType() {
    }
  }

  public int houseRobber3(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return 0;
    }

    visited = new HashMap<>();
    // return the final result
    ResultType resultType = dfs(root);
    return Math.max(resultType.rob, resultType.noRob);
  }

  HashMap<TreeNode, ResultType> visited;

  ResultType dfs(TreeNode root) {
    if (visited.containsKey(root)) {
      return visited.get(root);
    }
    if (root.left == null && root.right == null) {
      return new ResultType(root.val, 0);
    }

    int rob = root.val;
    int noRob = 0;
    if (root.left != null) {
      ResultType leftResult = dfs(root.left);
      rob += leftResult.noRob;
      noRob += Math.max(leftResult.rob, leftResult.noRob);
    }
    if (root.right != null) {
      ResultType rightResult = dfs(root.right);
      rob += rightResult.noRob;
      noRob += Math.max(rightResult.rob, rightResult.noRob);
    }
    visited.put(root, new ResultType(rob, noRob));
    return visited.get(root);
  }

}
