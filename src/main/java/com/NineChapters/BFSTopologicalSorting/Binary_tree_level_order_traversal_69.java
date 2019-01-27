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
        Queue<NodeLevel> queue = new LinkedList<>();
        queue.add(new NodeLevel(root, 0));
        int currentLevel = -1;
        while (!queue.isEmpty()) {
            NodeLevel currentNodeLevel = ((LinkedList<NodeLevel>) queue).pop();
            if (currentLevel < currentNodeLevel.getLevel()) {
                result.add(new LinkedList<>());
                currentLevel = currentNodeLevel.getLevel();
            }
            result.get(currentLevel).add(currentNodeLevel.node.val);
            if (currentNodeLevel.getNode().left != null) {
                ((LinkedList<NodeLevel>) queue).addLast(new NodeLevel(currentNodeLevel.getNode().left, currentLevel + 1));
            }
            if (currentNodeLevel.getNode().right != null) {
                ((LinkedList<NodeLevel>) queue).addLast(new NodeLevel(currentNodeLevel.getNode().right, currentLevel + 1));
            }
        }

        // return the final result
        return result;
    }

    static class NodeLevel {
        private TreeNode node;
        private int level;

        public NodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }

        public TreeNode getNode() {
            return node;
        }

        public void setNode(TreeNode node) {
            this.node = node;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }
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
