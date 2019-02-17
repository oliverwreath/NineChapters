package com.LeetCode.Weekly_124;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class CousinsInBinaryTree_993 {
    private final static Logger logger = LoggerFactory.getLogger(CousinsInBinaryTree_993.class);

    public static void main(String[] args) {
        CousinsInBinaryTree_993 thisClass = new CousinsInBinaryTree_993();
        thisClass.testCousinsInBinaryTree_993();
    }

    private void testCousinsInBinaryTree_993() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        logger.info("result {} v.s. {}", "false", isCousins(root, 4, 3));
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);
        logger.info("result {} v.s. {}", "true", isCousins(root, 5, 4));
        root.right.right = null;
        logger.info("result {} v.s. {}", "false", isCousins(root, 2, 3));
    }

    TreeNode xParent = null;
    TreeNode yParent = null;
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

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }

        static void debug() {
            if (isDebugging) {
                System.out.println(DEBUG + " = ");
            }
        }

        static void info() {
            if (isInfoing) {
                System.out.println(INFO + " = ");
            }
        }
    }
}
