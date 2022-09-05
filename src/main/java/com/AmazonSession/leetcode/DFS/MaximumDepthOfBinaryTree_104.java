package com.AmazonSession.leetcode.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class MaximumDepthOfBinaryTree_104 {
  public static void main(String[] arg) {
    new MaximumDepthOfBinaryTree_104().testMaximumDepthOfBinaryTree_104();
  }

  private void testMaximumDepthOfBinaryTree_104() {
    log.info("{}", maxDepth(null));
    log.info("{}", maxDepth(new TreeNode(0)));
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    log.info("{}", maxDepth(root));
  }

  public int maxDepth(TreeNode root) {

    if (root == null) {
      return 0;
    }

    return getHeight(root);
  }

  private int getHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int height = 1;
    height = Math.max(height, getHeight(root.left) + 1);
    height = Math.max(height, getHeight(root.right) + 1);
    return height;
  }
}
