package com.NineChapters.BFSTopologicalSorting;

import com.NineChapters.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_tree_level_order_traversal_69 {
    private final static Logger logger = LoggerFactory.getLogger(Binary_tree_level_order_traversal_69.class);

    public static void main(String[] args) {
        testBinary_tree_level_order_traversal_69();
    }

    private static void testBinary_tree_level_order_traversal_69() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        logger.info("result _ v.s. {}", levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // filter abnormal cases
        if (root == null) {
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        List<Integer> level = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode currentTreeNode = queue.poll();
            if (currentTreeNode == null) {
                if (level.size() == 0) {
                    break;
                }
                result.add(level);
                level = new LinkedList<>();
                queue.offer(null);
                continue;
            }

            level.add(currentTreeNode.val);
            if (currentTreeNode.left != null) {
                queue.offer(currentTreeNode.left);
            }
            if (currentTreeNode.right != null) {
                queue.offer(currentTreeNode.right);
            }
        }

        // return the final result
        return result;
    }

    private static class MyLogger {
        private static final boolean isDebugging = false;
        private static final boolean isInfoing = true;
        private static final String DEBUG = "[DEBUG]";
        private static final String INFO = "[INFO]";

        static void debug(Object message) {
            if (isDebugging) {
                System.out.println(DEBUG + " = " + message);
            }
        }

        static void info(Object message) {
            if (isInfoing) {
                System.out.println(INFO + " = " + message);
            }
        }
    }
}
