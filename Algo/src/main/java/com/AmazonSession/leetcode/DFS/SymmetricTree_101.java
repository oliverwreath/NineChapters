package com.AmazonSession.leetcode.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SymmetricTree_101 {

  public static void main(String[] arg) {
    new SymmetricTree_101().testBalancedBinaryTree_110();
  }

  private void testBalancedBinaryTree_110() {
    log.info("{}", isSymmetric(null));
    log.info("{}", isSymmetric(new TreeNode(0)));
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
    log.info("{}", isSymmetric(root));
  }

  public boolean isSymmetric(TreeNode root) {

    if (root == null) {
      return true;
    }

    return isSymmetricHelper(root.left, root.right);
  }

  public boolean isSymmetricHelper(TreeNode left, TreeNode right) {

    if (left == null || right == null) {
      return left == right;
    }

    return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right,
        right.left);
  }

  private class ResultEntry {

    boolean isBalanced;
    int depth;

    public ResultEntry(boolean isBalanced, int depth) {
      this.isBalanced = isBalanced;
      this.depth = depth;
    }

    @Override
    public String toString() {
      return "ResultEntry{" +
          "isBalanced=" + isBalanced +
          ", depth=" + depth +
          '}';
    }
  }

}
