package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
@Slf4j
public class MaxMinDepth {
  public static void main(String[] args) {
    testMaxDepth();
    testMinDepth();
  }

  public static void testMaxDepth() {
    TreeNode root = getTree();
    int i = maxDepth(root);
    log.debug("result=" + i);
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public static void testMinDepth() {
    TreeNode root = getTree();
    int i = minDepth(root);
    log.debug("result=" + i);
  }

  public static int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && (root.right == null)) {
      return 1;
    } else if (root.left == null) {
      return minDepth(root.right) + 1;
    } else if (root.right == null) {
      return minDepth(root.left) + 1;
    } else {
      return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
  }
}
