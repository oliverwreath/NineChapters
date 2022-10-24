package com.leetcode;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC543DiameterOfBinaryTree {

  public int diameterOfBinaryTree(TreeNode root) {
    maxDiameter = 0;
    maxDepth(root);
    return maxDiameter;
  }

  private int maxDiameter = 0;

  private int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    int maxLeft = maxDepth(root.left);
    int maxRight = maxDepth(root.right);
    maxDiameter = Math.max(maxDiameter, maxLeft + maxRight);
    return 1 + Math.max(maxLeft, maxRight);
  }
}
