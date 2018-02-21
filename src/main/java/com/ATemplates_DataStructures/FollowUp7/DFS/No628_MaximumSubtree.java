package com.ATemplates_DataStructures.FollowUp7.DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * dfs simple
 */
public class No628_MaximumSubtree {
    private final static Logger logger = LoggerFactory.getLogger(No628_MaximumSubtree.class);

    public static void main(String[] args) {
        No628_MaximumSubtree No628_MaximumSubtree = new No628_MaximumSubtree();
        No628_MaximumSubtree.testNo628_MaximumSubtree();
    }

    private void testNo628_MaximumSubtree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(-5);
        treeNode.left.left = new TreeNode(0);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(-4);
        treeNode.right.right = new TreeNode(-5);
        MyLogger.info("result 3 v.s. " + findSubtree(treeNode));
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public TreeNode findSubtree(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return root;
        }

        answer = null;
        max = Integer.MIN_VALUE;
        dfs(root);

        // return the final result
        return answer;
    }

    TreeNode answer;
    int max;

    int dfs(TreeNode root) {
        int sum = root.val;
        if (root.left == null && root.right == null) {
            if (sum > max) {
                max = sum;
                answer = root;
            }
            return sum;
        }

        if (root.left != null) {
            sum += dfs(root.left);
        }
        if (root.right != null) {
            sum += dfs(root.right);
        }
        if (sum > max) {
            max = sum;
            answer = root;
        }
        return sum;
    }

    private static class MyLogger {
        static boolean isDebugging = false;
        static boolean isInfoing = true;

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println("MyLogger.Debugging = " + message);
            }
        }
    }
}
