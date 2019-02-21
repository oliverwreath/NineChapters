package com.Amazon.LeetCode.DFS;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by yanli on 2016-10-23.
 */
public class PathSum_112 {
    private static final Logger logger = LoggerFactory.getLogger(PathSum_112.class);

    public static void main(String[] arg) {
        new PathSum_112().testSameTree_100();
    }

    private void testSameTree_100() {
        logger.info("{}", hasPathSum(null, 22));
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        // write your code here
        // handle extreme cases
        if (root == null) {
            return false;
        }

        List<Integer> pathSum = getPathSum(root);
        for (Integer aSum : pathSum) {
            if (aSum == sum) {
                return true;
            }
        }

        return false;
    }

    public List<Integer> getPathSum(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }
        if (root.left != null) {
            List<Integer> leftSum = getPathSum(root.left);
            for (Integer aLeft : leftSum) {
                ans.add(aLeft + root.val);
            }
        }
        if (root.right != null) {
            List<Integer> rightSum = getPathSum(root.right);
            for (Integer aRight : rightSum) {
                ans.add(aRight + root.val);
            }
        }
        return ans;
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
