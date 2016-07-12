package com.oliver.BinaryTree;

import com.oliver.BinaryTree.BinaryTree.TreeNode;

import static com.oliver.BinaryTree.BinaryTree.getSmallTree;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
public class MaxPathSum {
    public static void main(String[] args) {
        testMaxPathSum2();
        testMaxPathSum();
    }

    public static void testMaxPathSum2() {
        BinaryTree.TreeNode root = getSmallTree();
        System.out.println("result=" + maxPathSum2(root));
    }

    public static int maxPathSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxPathSum2(root.left);
        int right = maxPathSum2(root.right);

        int max = Math.max(left, right);
        return root.val + Math.max(0, max);
    }

    public static void testMaxPathSum() {
        BinaryTree.TreeNode root = getSmallTree();
        System.out.println("result=" + maxPathSum(root));
    }

    private static class ResultType {
        private int singleMax = 0;
        private int fullMax = Integer.MIN_VALUE;

        public ResultType(int singleMax, int fullMax) {
            this.singleMax = singleMax;
            this.fullMax = fullMax;
        }
    }

    public static int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).fullMax;
    }

    public static ResultType maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        ResultType left = maxPathSumHelper(root.left);
        ResultType right = maxPathSumHelper(root.right);

        int singleMax = Math.max(0, root.val + Math.max(left.singleMax, right.singleMax));
        int fullMax = Math.max(left.fullMax, right.fullMax);
        fullMax = Math.max(fullMax, root.val + left.singleMax + right.singleMax);

        return new ResultType(singleMax, fullMax);
    }
}
