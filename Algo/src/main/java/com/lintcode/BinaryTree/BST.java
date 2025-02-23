package com.lintcode.BinaryTree;

import static com.lintcode.BinaryTree.BinaryTree.getSmallTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
@Slf4j
public class BST {

  public static void main(String[] args) {
    testIsValidBST();
  }

  public static TreeNode getBST() {
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(3);
    root.right = new TreeNode(6);
    root.left.left = new TreeNode(1);

    log.trace("root = {}", root);
    return root;
  }

  public static void testIsValidBST() {
    TreeNode root = getSmallTree();
    log.debug("result=" + isValidBST(root));
    log.debug("result=" + isValidBST(getBST()));
    log.debug("result=" + isValidBST(null));
  }

  private static class ResultType {

    boolean isValidBST;
    int min;
    int max;

    public ResultType(boolean isValidBST, int min, int max) {
      this.isValidBST = isValidBST;
      this.min = min;
      this.max = max;
    }

    public boolean isValidBST() {
      return isValidBST;
    }
  }

  public static boolean isValidBST(TreeNode root) {
    return isValidBSTHelper(root).isValidBST();
  }

  public static ResultType isValidBSTHelper(TreeNode root) {
    if (root == null) {
      return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    ResultType left = isValidBSTHelper(root.left);
    ResultType right = isValidBSTHelper(root.right);
    boolean isValidBST = left.isValidBST() && right.isValidBST();
    if (root.left != null) {
      isValidBST = isValidBST && root.val > left.max;
    }
    if (root.right != null) {
      isValidBST = isValidBST && root.val < right.min;
    }
    int min = Math.min(root.val, Math.min(left.min, right.min));
    int max = Math.max(root.val, Math.max(left.max, right.max));

    return new ResultType(isValidBST, min, max);
  }
}
