package com.leetcode.Weekly124;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 * <p>
 * Version 1: Simply Working.
 * TIME: O(MN)
 * SPACE: O(MN)
 * <p>
 * Version 2: TBD.
 * TIME: O(?)
 * SPACE: O(?)
 */
@Slf4j
public class LC993CousinsInBinaryTree {
  TreeNode xParent;
  TreeNode yParent;
  int xDepth = -1;
  int yDepth = -1;

  public boolean isCousins(TreeNode root, int x, int y) {
    // filter abnormal cases
    if (root == null) {
      return false;
    }

    // dp logic
    xParent = null;
    yParent = null;
    xDepth = -1;
    yDepth = -1;
    isCousinsHelper(root, null, 0, x, y);

    // return the final result
    return (xParent != null && xParent != yParent && xDepth == yDepth);
  }

  private void isCousinsHelper(TreeNode root, TreeNode parent, int depth, int x, int y) {
    if (root == null) {
      return;
    }

    if (xParent == null && root.val == x) {
      xParent = parent;
      xDepth = depth;
    }
    if (yParent == null && root.val == y) {
      yParent = parent;
      yDepth = depth;
    }

    isCousinsHelper(root.left, root, depth + 1, x, y);
    isCousinsHelper(root.right, root, depth + 1, x, y);
  }
}
