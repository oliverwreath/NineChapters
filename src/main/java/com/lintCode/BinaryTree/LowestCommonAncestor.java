package com.lintCode.BinaryTree;

import com.TreesUtil.TreeNode;

import static com.lintCode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
public class LowestCommonAncestor {
    public static void main(String[] args) {
        testLowestCommonAncestor();
    }

    public static void testLowestCommonAncestor() {
        TreeNode root = getTree();
        System.out.println("result=" + lowestCommonAncestor(root, root.left, root.right));
    }

    //LCA - lowest common ancestor
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        } else if (left != null) {
            return left;
        } else if (right != null) {
            return right;
        }
        return null;
    }
}
