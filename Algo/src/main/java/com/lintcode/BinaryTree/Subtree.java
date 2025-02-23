package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class Subtree {

  public static void main(String[] arg) {
    new Subtree().testSubtree();
  }

  private void testSubtree() {
    log.info("{}", isSubtree(null, null));
  }

  /**
   * @param T1, T2: The roots of binary tree.
   * @return: True if T2 is a subtree of T1, or false.
   */
  public boolean isSubtree(TreeNode T1, TreeNode T2) {

    if (T2 == null) {
      return true;
    }
    if (T1 == null) {
      return false;
    }

    if (isEqual(T1, T2)) {
      return true;
    }
    if (isSubtree(T1.left, T2) || isSubtree(T1.right, T2)) {
      return true;
    }

    return false;
  }

  private boolean isEqual(TreeNode T1, TreeNode T2) {

    if (T1 == null || T2 == null) {
      return T1 == T2;
    }
    if (T1.val != T2.val) {
      return false;
    }
    return isEqual(T1.left, T2.left) && isEqual(T1.right, T2.right);
  }

}
