package com.AmazonSession.leetcode.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class BalancedBinaryTree_110 {

  public static void main(String[] arg) {
    new BalancedBinaryTree_110().testBalancedBinaryTree_110();
  }

  private void testBalancedBinaryTree_110() {
    log.info("{}", isBalanced(null));
    log.info("{}", isBalanced(new TreeNode(0)));
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(2);
    log.info("{}", isBalanced(root));
  }

  public boolean isBalanced(TreeNode root) {

    if (root == null) {
      return true;
    }

    return isBalancedHelper(root).isBalanced;
  }

  public ResultEntry isBalancedHelper(TreeNode root) {

    if (root == null) {
      return new ResultEntry(true, 0);
    } else {
      ResultEntry leftResult = isBalancedHelper(root.left);
      if (!leftResult.isBalanced) {
        return new ResultEntry(false, 0);
      }
      ResultEntry rightResult = isBalancedHelper(root.right);
      if (!rightResult.isBalanced) {
        return new ResultEntry(false, 0);
      }
//            log.info("root = " + root);
//            log.info("leftResult = " + leftResult);
//            log.info("rightResult = " + rightResult);
      if (Math.abs(leftResult.depth - rightResult.depth) <= 1) {
        return new ResultEntry(true, Math.max(leftResult.depth, rightResult.depth) + 1);
      } else {
        return new ResultEntry(false, 0);
      }
    }
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
