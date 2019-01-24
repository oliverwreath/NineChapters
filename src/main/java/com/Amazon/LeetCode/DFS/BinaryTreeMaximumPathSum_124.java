package com.Amazon.LeetCode.DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-23.
 */
public class BinaryTreeMaximumPathSum_124 {
    private final static Logger logger = LoggerFactory.getLogger(BinaryTreeMaximumPathSum_124.class);

    public static void main(String[] arg) {
        new BinaryTreeMaximumPathSum_124().testSameTree_100();
    }

    private void testSameTree_100() {
        logger.info("{}", maxPathSum(null));
        logger.info("{}", maxPathSum(new TreeNode(0)));
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        logger.info("{}", maxPathSum(root));
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        logger.info("{}", maxPathSum(root));
    }

    public int maxPathSum(TreeNode root) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return 0;
        }

        return getMaxPathSum(root).maxGlobal;
    }

    private ReturnResult getMaxPathSum(TreeNode root) {
        if (root.right == null) {
            if (root.left == null) {
                return new ReturnResult(root.val, root.val);
            } else {
                ReturnResult left = getMaxPathSum(root.left);
                int maxLocal = Math.max(left.maxLocal + root.val, root.val);
                return new ReturnResult(maxLocal, Math.max(left.maxGlobal, maxLocal));
            }
        } else {
            ReturnResult right = getMaxPathSum(root.right);
            if (root.left == null) {
                int maxLocal = Math.max(right.maxLocal + root.val, root.val);
                return new ReturnResult(maxLocal, Math.max(right.maxGlobal, maxLocal));
            } else {
                ReturnResult left = getMaxPathSum(root.left);
                int maxLocal = Math.max(Math.max(right.maxLocal, left.maxLocal) + root.val, root.val);
                int wow = left.maxLocal + right.maxLocal + root.val;
                return new ReturnResult(maxLocal, Math.max(Math.max(left.maxGlobal, right.maxGlobal), Math.max(maxLocal, wow)));
            }
        }
    }

    private class ReturnResult {
        int maxLocal;
        int maxGlobal;

        public ReturnResult(int maxLocal, int maxGlobal) {
            this.maxLocal = maxLocal;
            this.maxGlobal = maxGlobal;
        }

        @Override
        public String toString() {
            return "ReturnResult{" +
                    "maxLocal=" + maxLocal +
                    ", maxGlobal=" + maxGlobal +
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
