package com.AJia.LeetCode.DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class BalancedBinaryTree_110 {
    private final static Logger logger = LoggerFactory.getLogger(BalancedBinaryTree_110.class);

    public static void main(String[] arg) {
        new BalancedBinaryTree_110().testBalancedBinaryTree_110();
    }

    private void testBalancedBinaryTree_110() {
        logger.info("{}", isBalanced(null));
        logger.info("{}", isBalanced(new TreeNode(0)));
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        logger.info("{}", isBalanced(root));
    }

    public boolean isBalanced(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return true;
        }

        return isBalancedHelper(root).isBalanced;
    }

    public ResultEntry isBalancedHelper(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return new ResultEntry(true, 0);
        } else {
            ResultEntry leftResult = isBalancedHelper(root.left);
            if (!leftResult.isBalanced) {
                return new ResultEntry(false, 0);
            }
            ResultEntry rightResult = isBalancedHelper(root.right);
            if (!rightResult.isBalanced) {
                return new ResultEntry(false, 0);
            }
//            myLogger.info("root = " + root);
//            myLogger.info("leftResult = " + leftResult);
//            myLogger.info("rightResult = " + rightResult);
            if (Math.abs(leftResult.depth - rightResult.depth) <= 1) {
                return new ResultEntry(true, Math.max(leftResult.depth, rightResult.depth) + 1);
            } else {
                return new ResultEntry(false, 0);
            }
        }
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
