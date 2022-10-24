package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Yanliang Han on 2016/6/10.
 */
@Slf4j
public class BinaryTree {

  public static void main(String[] args) {
    TreeNode root = getTree();

//        log.debug("maxPathSum(root)=" + maxPathSum(root));
    MaxPathSumSolution maxPathSumSolution = new MaxPathSumSolution();
    log.debug("result=" + maxPathSumSolution.maxPathSum(root.right));
//        log.debug("result=" + maxPathSum(root.left));
//        log.debug("result=" + maxPathSum(root.right.left));
//        log.debug("result=" + maxPathSum(root.right.right));
  }

  public static TreeNode getSmallTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);

    log.trace("root = {}", root);
    return root;
  }

  public static TreeNode getTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);
    root.left.left.left = new TreeNode(8);

    log.trace("root = {}", root);
    return root;
  }

  public static TreeNode getUnBalancedTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.left.left = new TreeNode(8);

    log.trace("root = {}", root);
    return root;
  }

  private static class MaxPathSumSolution {

    //最大路径和
    class ResultType {

      private int singleMax;
      private int fullMax;

      public ResultType(int singleMax, int fullMax) {
        this.singleMax = singleMax;
        this.fullMax = fullMax;
      }
    }

    //version1
    public int maxPathSum(TreeNode root) {
      ResultType resultType = maxPathSumHelper(root);
      return resultType.fullMax;
    }

    public ResultType maxPathSumHelper(TreeNode root) {

      if (root == null) {
        return new ResultType(0, Integer.MIN_VALUE);
      }

      //Divide
      ResultType left = maxPathSumHelper(root.left);
      ResultType right = maxPathSumHelper(root.right);

      //Conquer
      int singleMax = Math.max(0, root.val + Math.max(left.singleMax, right.singleMax));

      int fullMax = Math.max(left.fullMax, right.fullMax);
      fullMax = Math.max(fullMax, left.singleMax + root.val + right.singleMax);

      return new ResultType(singleMax, fullMax);
    }

    //version2
    public int maxPathSum2(TreeNode root) {
      ResultType resultType = maxPathSumHelper(root);
      return resultType.fullMax;
    }

    public ResultType maxPathSumHelper2(TreeNode root) {

      if (root == null) {
        return new ResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
      }

      //Divide
      ResultType left = maxPathSumHelper2(root.left);
      ResultType right = maxPathSumHelper2(root.right);

      //Conquer
      int singleMax = root.val + Math.max(0, Math.max(left.singleMax, right.singleMax));

      int fullMax = Math.max(left.fullMax, right.fullMax);
      fullMax = Math.max(fullMax, Math.max(0, left.singleMax) + root.val + Math.max(0, right.singleMax));

      return new ResultType(singleMax, fullMax);
    }
  }
}
