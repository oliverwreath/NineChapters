package com.LeetCode;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

/**
 * Created by yanli on 9/5/2016.
 */
public class No105_BinaryTreeFromPreorderAndInorder {
    private final static Logger logger = LoggerFactory.getLogger(No105_BinaryTreeFromPreorderAndInorder.class);

    public static void main(String[] arg) {
        testBuildTree();
    }

    private static void testBuildTree() {
        logger.info("{}", buildTree(new int[]{1, 2, 3}, new int[]{2, 1, 3}));
        logger.info("{}", buildTree(new int[]{2, 1}, new int[]{2, 1}));
        logger.info("{}", buildTree(new int[]{}, new int[]{}));
    }

    static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        // fill the map to speed up findRoot
        map.clear();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        // find subtree root in inorder
        TreeNode root = buildTreeHelper(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);

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

    static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] preorder, int preStart, int preEnd) {
        if (inEnd - inStart < 0 || preEnd - preStart < 0) {
            return null;
        }

        // find subtree root in inorder
        int parentIndex = findRoot(preorder[preStart]);
        TreeNode parent = new TreeNode(inorder[parentIndex]);
        int preAnchorIndex = preStart - inStart + parentIndex;
        parent.left = buildTreeHelper(inorder, inStart, parentIndex - 1, preorder, preStart + 1, preAnchorIndex);
        parent.right = buildTreeHelper(inorder, parentIndex + 1, inEnd, preorder, preAnchorIndex + 1, preEnd);

        // return result
        return parent;
    }
}
