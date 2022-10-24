package com.lintcode.BinaryTree;

import static com.lintcode.BinaryTree.BinaryTree.getTree;
import static com.lintcode.BinaryTree.BinaryTree.getUnBalancedTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
@Slf4j
public class IsBalancedSolution {

  public static void main(String[] args) {
    testIsBalanced();
  }

  public static void testIsBalanced() {
    TreeNode root = getTree();
    log.debug("result=" + isBalanced(root));

    TreeNode unBalancedTree = getUnBalancedTree();
    log.debug("result=" + isBalanced(unBalancedTree));
  }

  public static boolean isBalanced(TreeNode root) {
    return isBalancedHelper(root).isBalanced();
  }

  public static ResultType isBalancedHelper(TreeNode root) {
    if (root == null) {
      return new ResultType(true, 0);
    }

    ResultType leftResult = isBalancedHelper(root.left);
    ResultType rightResult = isBalancedHelper(root.right);

    boolean isBalanced =
        leftResult.isBalanced() && rightResult.isBalanced() && (Math.abs(leftResult.maxDepth - rightResult.maxDepth)
            <= 1);
    int maxDepth = Math.max(leftResult.maxDepth, rightResult.maxDepth) + 1;
    return new ResultType(isBalanced, maxDepth);
  }

  private static class ResultType {

    private boolean isBalanced = true;
    private int maxDepth = 0;

    public ResultType(boolean isBalanced, int maxDepth) {
      this.isBalanced = isBalanced;
      this.maxDepth = maxDepth;
    }

    public boolean isBalanced() {
      return isBalanced;
    }
  }

//    public boolean isBalanced2(TreeNode root) {
//    
//        if (root == null) {
//            return true;
//        }
//
//        return maxDepth(root) != -1;
//    }
//
//    public int maxDepth(TreeNode root) {
//    
//        if (root == null) {
//            return 0;
//        }
//
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
//            return -1;
//        } else {
//            return 1 + Math.max(left, right);
//        }
//    }
}
