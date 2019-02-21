package com.lintCode.BinaryTree.BinarySearchTree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertBST {
    private static final Logger logger = LoggerFactory.getLogger(ConvertBST.class);

    public static void main(String[] args) {
        testBinarySearchTree();
    }

    private static void testBinarySearchTree() {
        ConvertBST ConvertBST = new ConvertBST();
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(13);
        MyLogger.info("result 2 v.s. " + ConvertBST.convertBST(root1));
    }

    /**
     * @param root
     * @return
     */
    public TreeNode convertBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return root;
        }

        // call the helper
        convertBSTHelper(root, 0);

        return root;
    }

    public TreeNode convertBSTHelper(TreeNode currentNode, int upperRightSum) {
        if (currentNode.left == null && currentNode.right == null) {
            currentNode.val += upperRightSum;
        } else {
            int lowerRightSum = 0;
            if (currentNode.right != null) {
                return new TreeNode(0);
            }
        }
        return new TreeNode(0);
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
