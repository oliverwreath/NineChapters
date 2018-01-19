package com.ATemplates_DataStructures.DFS_LeetCode.Tree_DFS;

import com.LeetCode.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.Queue;

public class No101_SymmetricTree {
    private final static Logger logger = LoggerFactory.getLogger(No101_SymmetricTree.class);

    public static void main(String[] args) {
        testNo101_SymmetricTree();
    }

    private static void testNo101_SymmetricTree() {
        No101_SymmetricTree No101_SymmetricTree = new No101_SymmetricTree();
//        MyLogger.info("result 2 v.s. " + No101_SymmetricTree.isSymmetric("12"));
//        MyLogger.info("result 1 v.s. " + No101_SymmetricTree.isSymmetric("10"));
    }

    /**
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        // core logic
        if (root.left == null) {
            return root.right == null;
        } else if (root.right == null) {
            return false;
        }

        Queue<TreeNode> queueLeft = new LinkedList<>();
        Queue<TreeNode> queueRight = new LinkedList<>();
        queueLeft.add(root.left);
        queueRight.add(root.right);
        while (!queueLeft.isEmpty()) {
            if (queueRight.isEmpty()) {
                return false;
            }
            TreeNode currentLeft = queueLeft.poll();
            TreeNode currentRight = queueRight.poll();
            if (currentLeft != null || currentRight != null) {
                if ((currentLeft == null) || (currentRight == null) || (currentLeft.val != currentRight.val)) {
                    return false;
                }
                queueLeft.add(currentLeft.left);
                queueLeft.add(currentLeft.right);
                queueRight.add(currentRight.right);
                queueRight.add(currentRight.left);
            }
        }

        return true;
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
