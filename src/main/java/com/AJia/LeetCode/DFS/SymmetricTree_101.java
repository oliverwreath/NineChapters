package com.AJia.LeetCode.DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class SymmetricTree_101 {
    private final static Logger logger = LoggerFactory.getLogger(SymmetricTree_101.class);

    public static void main(String[] arg) {
        new SymmetricTree_101().testBalancedBinaryTree_110();
    }

    private void testBalancedBinaryTree_110() {
        logger.info("{}", isSymmetric(null));
        logger.info("{}", isSymmetric(new TreeNode(0)));
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        logger.info("{}", isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    public boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        // write your code here
        // handle extreme cases
        if (left == null || right == null) {
            return left == right;
        }

        return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    private class ResultEntry {
        boolean isBalanced;
        int depth;

        public ResultEntry(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "ResultEntry{" +
                    "isBalanced=" + isBalanced +
                    ", depth=" + depth +
                    '}';
        }
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
