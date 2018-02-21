package com.ATemplates_DataStructures.FollowUp7.DFS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class No535_HouseRobberIII {
    private final static Logger logger = LoggerFactory.getLogger(No535_HouseRobberIII.class);

    public static void main(String[] args) {
        No535_HouseRobberIII No535_HouseRobberIII = new No535_HouseRobberIII();
        No535_HouseRobberIII.testNo535_HouseRobberIII();
    }

    private void testNo535_HouseRobberIII() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        treeNode.right = new TreeNode(3);
        treeNode.right.right = new TreeNode(1);
        MyLogger.info("result 7 v.s. " + houseRobber3(treeNode));
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

    class ResultType {
        int rob;
        int noRob;

        public ResultType(int rob, int noRob) {
            this.rob = rob;
            this.noRob = noRob;
        }

        public ResultType() {
        }
    }

    public int houseRobber3(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return 0;
        }

        visited = new HashMap<>();
        // return the final result
        ResultType resultType = dfs(root);
        return Math.max(resultType.rob, resultType.noRob);
    }

    HashMap<TreeNode, ResultType> visited;

    ResultType dfs(TreeNode root) {
        if (visited.containsKey(root)) {
            return visited.get(root);
        }
        if (root.left == null && root.right == null) {
            return new ResultType(root.val, 0);
        }

        int rob = root.val;
        int noRob = 0;
        if (root.left != null) {
            ResultType leftResult = dfs(root.left);
            rob += leftResult.noRob;
            noRob += Math.max(leftResult.rob, leftResult.noRob);
        }
        if (root.right != null) {
            ResultType rightResult = dfs(root.right);
            rob += rightResult.noRob;
            noRob += Math.max(rightResult.rob, rightResult.noRob);
        }
        visited.put(root, new ResultType(rob, noRob));
        return visited.get(root);
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
