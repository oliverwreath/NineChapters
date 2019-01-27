package com.LeetCode.Weekly71;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;

public class No783_MinimumDistanceBetweenBSTNodes {
    private final static Logger logger = LoggerFactory.getLogger(No783_MinimumDistanceBetweenBSTNodes.class);

    public static void main(String[] args) {
        new No783_MinimumDistanceBetweenBSTNodes().testNo783_MinimumDistanceBetweenBSTNodes();
    }

    private void testNo783_MinimumDistanceBetweenBSTNodes() {
        TreeNode node = new TreeNode(-7);
        node.left = new TreeNode(-9);
        MyLogger.info("result 2 v.s. " + minDiffInBST(node));
    }

    public int minDiffInBST(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return 0;
        }

        nodes = new LinkedList<>();
        helper(root);

        // return the final result
        int answer = Integer.MAX_VALUE;
        int slow = nodes.getFirst();
        for (int i = 1; i < nodes.size(); i++) {
            int fast = nodes.get(i);
            answer = Math.min(answer, Math.abs(fast - slow));
            slow = fast;
        }
        return answer;
    }

    LinkedList<Integer> nodes;

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        nodes.add(root.val);
        helper(root.right);
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
