package com.NineChapters.TreeBasedDFS.SumPath;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Minimum_subtree_596 {

  public static void main(String[] args) {
    testMinimum_subtree_596();
  }

  private static void testMinimum_subtree_596() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(-5);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(-4);
    root.right.right = new TreeNode(-5);
    log.info("result 1 v.s. {}", findSubtree(root));
  }

  private static TreeNode subtree = null;
  private static int subtreeSum = Integer.MAX_VALUE;

  public static TreeNode findSubtree(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return root;
    }

    subtree = null;
    subtreeSum = Integer.MAX_VALUE;
    helper(root);

    // return the final result
    return subtree;
  }

  private static int helper(TreeNode node) {
    if (node == null) {
      return Integer.MAX_VALUE;
    }

    int sum = node.val;
    if (node.left != null) {
      sum += helper(node.left);
    }
    if (node.right != null) {
      sum += helper(node.right);
    }
    if (sum < subtreeSum) {
      subtreeSum = sum;
      subtree = node;
    }
    return sum;
  }

}
