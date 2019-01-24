package com.Amazon.LeetCode.DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class MaximumDepthOfBinaryTree_104 {
    private final static Logger logger = LoggerFactory.getLogger(MaximumDepthOfBinaryTree_104.class);

    public static void main(String[] arg) {
        new MaximumDepthOfBinaryTree_104().testMaximumDepthOfBinaryTree_104();
    }

    private void testMaximumDepthOfBinaryTree_104() {
        logger.info("{}", maxDepth(null));
        logger.info("{}", maxDepth(new TreeNode(0)));
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        logger.info("{}", maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return 0;
        }

        return getHeight(root);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        height = Math.max(height, getHeight(root.left) + 1);
        height = Math.max(height, getHeight(root.right) + 1);
        return height;
    }

    private MyTmpLogger myLogger = new MyTmpLogger();

    private class MyTmpLogger {
        public MyTmpLogger() {
        }

        public void info(Object o) {
            if (isLogging) {
                System.out.println(o);
            }
        }
    }

    public static boolean isLogging = false;

    static {
        isLogging = true;
    }
}
