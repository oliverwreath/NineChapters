package com.ATemplates_DataStructures.DFS_LeetCode.Recursion_Tree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class No111_MinimumDepthOfBinaryTree {
    private final static Logger logger = LoggerFactory.getLogger(No111_MinimumDepthOfBinaryTree.class);

    public static void main(String[] args) {
        testNo111_MinimumDepthOfBinaryTree();
    }

    private static void testNo111_MinimumDepthOfBinaryTree() {
        No111_MinimumDepthOfBinaryTree No111_MinimumDepthOfBinaryTree = new No111_MinimumDepthOfBinaryTree();
        MyLogger.info("result 0 v.s. " + No111_MinimumDepthOfBinaryTree.minDepth(null));
        MyLogger.info("result 1 v.s. " + No111_MinimumDepthOfBinaryTree.minDepth(new TreeNode(3)));
    }

    /**
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return 0;
        }

        // core logic
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, 1));
        while (!queue.isEmpty()) {
            Entry currentEntry = queue.remove();
            if (currentEntry.node.left == null && currentEntry.node.right == null) {
                return currentEntry.depth;
            } else {
                if (currentEntry.node.left != null) {
                    queue.add(new Entry(currentEntry.node.left, currentEntry.depth + 1));
                }
                if (currentEntry.node.right != null) {
                    queue.add(new Entry(currentEntry.node.right, currentEntry.depth + 1));
                }
            }
        }

        // return the final result
        return -1;
    }

    class Entry {
        TreeNode node;
        int depth;

        public Entry(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "node=" + node +
                    ", depth=" + depth +
                    '}';
        }
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
