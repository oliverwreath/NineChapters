package com.LeetCode.SmarkingAlgorithmContest;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 2016-10-22.
 */
public class PathSumIII_437 {
    private static final Logger logger = LoggerFactory.getLogger(PathSumIII_437.class);

    public static void main(String[] arg) {
        new PathSumIII_437().testPathSumIII_437();
    }

    private void testPathSumIII_437() {
        TreeNode sub = new TreeNode(3);
        sub.left = new TreeNode(3);
        sub.right = new TreeNode(-2);

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = sub;
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        root.left.right.right = new TreeNode(1);
        logger.info("{} \n{}", root, pathSum(root, 8));
    }

    private int counter;
    private int target;

    public int pathSum(TreeNode root, int sum) {
        // write your code here
        // handle extreme cases

        counter = 0;
        target = sum;

        ArrayList<Long> sums = getSums(root);
        myLogger.info("sums = " + sums);
        for (Long aLong : sums) {
            if (aLong == sum) {
                counter++;
            }
        }

        return counter;
    }

    private ArrayList<Long> getSums(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(0);
        }
        if (root.left == null && root.right == null) {
            ArrayList<Long> ans = new ArrayList<>(0);
            ans.add((long) root.val);
            return ans;
        }
        ArrayList<Long> ans = new ArrayList<>(0);
        ans.add((long) root.val);
        int myCounter = 0;
        if (root.left != null) {
            ArrayList<Long> lefts = getSums(root.left);
            for (Long aLeft : lefts) {
                ans.add(aLeft + root.val);
                if (aLeft == target) {
                    myCounter++;
                }
            }
        }
        if (root.right != null) {
            ArrayList<Long> rights = getSums(root.right);
            for (Long aRight : rights) {
                ans.add(aRight + root.val);
                if (aRight == target) {
                    myCounter++;
                }
            }
        }
        counter += myCounter;
        myLogger.info("root.val = " + root.val + "; ans = " + ans + "; myCounter = " + myCounter);
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

    private class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    "\n, right=" + right +
                    "}";
        }
    }
}
