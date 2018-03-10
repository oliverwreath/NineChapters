package com.LintCodeContest.Weekly8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class No69_BinaryTreeLevelOrderTraversal {
    private final static Logger logger = LoggerFactory.getLogger(No69_BinaryTreeLevelOrderTraversal.class);

    public static void main(String[] args) {
        No69_BinaryTreeLevelOrderTraversal No69_BinaryTreeLevelOrderTraversal = new No69_BinaryTreeLevelOrderTraversal();
        No69_BinaryTreeLevelOrderTraversal.testNo69_BinaryTreeLevelOrderTraversal();
    }

    private void testNo69_BinaryTreeLevelOrderTraversal() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        MyLogger.info("result 2 v.s. " + levelOrder(root));
    }

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    List<List<Integer>> levelOrder(TreeNode root) {
        // filter abnormal cases
        List<List<Integer>> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        HashMap<TreeNode, Integer> map = new HashMap<>();
        queue.add(root);
        map.put(root, 0);
        int currentLevel = -1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (map.get(node) > currentLevel) {
                answer.add(new ArrayList<>());
                currentLevel = map.get(node);
            }
            answer.get(answer.size() - 1).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                map.put(node.left, map.get(node) + 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                map.put(node.right, map.get(node) + 1);
            }
        }

        // return the final result
        return answer;
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
