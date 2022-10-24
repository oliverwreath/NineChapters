package com.leetcode;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC104MaximumDepthOfBinaryTree {

  public int maxDepth(TreeNode root) {
    if (root == null)
      return 0;

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }
}
