package com.ATemplates_DataStructures.DFS_LeetCode.Tree_DFS;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

public class No257_BinaryTreePaths {
    private final static Logger logger = LoggerFactory.getLogger(No257_BinaryTreePaths.class);

    public static void main(String[] args) {
        testNo257_BinaryTreePaths();
    }

    private static void testNo257_BinaryTreePaths() {
        No257_BinaryTreePaths No257_BinaryTreePaths = new No257_BinaryTreePaths();
//        MyLogger.info("result 2 v.s. " + No257_BinaryTreePaths.binaryTreePaths("12"));
//        MyLogger.info("result 1 v.s. " + No257_BinaryTreePaths.binaryTreePaths("10"));
    }

    /**
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }

        if (root.left == null && root.right == null) {
            globalResult.add(Integer.toString(root.val));
            return globalResult;
        }
        if (root.left != null) {
            dfsHelp(root.left, Integer.toString(root.val));
        }
        if (root.right != null) {
            dfsHelp(root.right, Integer.toString(root.val));
        }
        return globalResult;
    }

    private List<String> globalResult = new LinkedList<>();

    public void dfsHelp(TreeNode node, String prefixString) {
        if (node == null) {
            return;
        }

        String newPrefixString = prefixString + "->" + node.val;
        if (node.left == null && node.right == null) {
            globalResult.add(newPrefixString);
        } else {
            if (node.left != null) {
                dfsHelp(node.left, newPrefixString);
            }
            if (node.right != null) {
                dfsHelp(node.right, newPrefixString);
            }
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
