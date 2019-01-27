package com.ATemplates_DataStructures.BinaryTree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Queue;

public class No632_BinaryTreeMaximumNode {
    private final static Logger logger = LoggerFactory.getLogger(No632_BinaryTreeMaximumNode.class);

    public static void main(String[] args) {
        No632_BinaryTreeMaximumNode No632_BinaryTreeMaximumNode = new No632_BinaryTreeMaximumNode();
        No632_BinaryTreeMaximumNode.testNo632_BinaryTreeMaximumNode();
    }

    private void testNo632_BinaryTreeMaximumNode() {
        MyLogger.info("result 2 v.s. " + maxNode(new TreeNode(2)));
    }

    TreeNode maxNode(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return root;
        }

        int max = root.val;
        TreeNode maxNode = root;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val > max) {
                max = node.val;
                maxNode = node;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        // return the final result
        return maxNode;
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
