package com.oliver.BinaryTree;

import com.oliver.BinaryTree.BinaryTree.TreeNode;

import static com.oliver.BinaryTree.BinaryTree.getTree;
import static com.oliver.BinaryTree.BinaryTree.getUnBalancedTree;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
public class IsBalancedSolution {
    public static void main(String[] args) {
        testIsBalanced();
    }

    public static void testIsBalanced() {
        TreeNode root = getTree();
        System.out.println("root=" + root);
        System.out.println("result=" + isBalanced(root));

        TreeNode unBalancedTree = getUnBalancedTree();
        System.out.println("root=" + unBalancedTree);
        System.out.println("result=" + isBalanced(unBalancedTree));
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

        boolean isBalanced = leftResult.isBalanced() && rightResult.isBalanced() && (Math.abs(leftResult.maxDepth - rightResult.maxDepth) <= 1);
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

//    //isBalanced
//    private class ResultType {
//        private boolean isBalanced;
//        private int depth;
//
//        public ResultType(int depth, boolean isBalanced) {
//            this.depth = depth;
//            this.isBalanced = isBalanced;
//        }
//    }
//
//    public boolean isBalanced(BinaryTree.TreeNode root) {
//        // write your code here
//        if (root == null) {
//            return true;
//        }
//
//        return isBalancedHelper(root).isBalanced;
//    }
//
//    public ResultType isBalancedHelper(BinaryTree.TreeNode root) {
//        // write your code here
//        if (root == null) {
//            return new ResultType(0, true);
//        }
//
//        ResultType leftResult = isBalancedHelper(root.left);
//        ResultType rightResult = isBalancedHelper(root.right);
//
//        int depth = 1 + Math.max(leftResult.depth, rightResult.depth);
//        boolean isBalanced = leftResult.isBalanced && rightResult.isBalanced && Math.abs(leftResult.depth - rightResult.depth) <= 1;
//        return new ResultType(depth, isBalanced);
//    }
//
//    public boolean isBalanced2(BinaryTree.TreeNode root) {
//        // write your code here
//        if (root == null) {
//            return true;
//        }
//
//        return maxDepth(root) != -1;
//    }
//
//    public int maxDepth(BinaryTree.TreeNode root) {
//        // write your code here
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
