package com.LeetCode;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yanli on 9/5/2016.
 */
public class No106_BinaryTreefromInorderandPostorder {
    private final static Logger logger = LoggerFactory.getLogger(No106_BinaryTreefromInorderandPostorder.class);

    public static void main(String[] arg) {
        testBuildTree();
    }

    private static void testBuildTree() {
        logger.info("{}", buildTree(new int[]{2, 1, 3}, new int[]{2, 3, 1}));
        logger.info("{}", buildTree(new int[]{2, 1}, new int[]{2, 1}));
        logger.info("{}", buildTree(new int[]{1, 3, 2}, new int[]{3, 2, 1}));
    }

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0) {
            return null;
        }

        // fill the map to speed up findRoot
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // find subtree root in inorder
        TreeNode root = buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        // return result
        return root;
    }

    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    static int findRoot(int target) {
        if (map.containsKey(target)) {
            return map.get(target);
        } else {
            return -1;
        }
    }

    static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inEnd - inStart < 0 || postEnd - postStart < 0) {
            return null;
        }

        // find subtree root in inorder
        int parentIndex = findRoot(postorder[postEnd]);
        TreeNode parent = new TreeNode(inorder[parentIndex]);
        int postParentIndex = postStart - inStart + parentIndex;
        parent.left = buildTreeHelper(inorder, inStart, parentIndex - 1, postorder, postStart, postParentIndex - 1);
        parent.right = buildTreeHelper(inorder, parentIndex + 1, inEnd, postorder, postParentIndex, postEnd - 1);

        // return result
        return parent;
    }
}
