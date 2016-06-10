package com.oliver.BinaryTree;

import com.oliver.BinaryTree.BinaryTree.TreeNode;

import java.util.ArrayList;

public class BinaryTreeDivide_Conquer {
    public static void main(String[] args) {
        testPreorderTraversal();
        testInorderTraversal();
        testPostorderTraversal();
    }

    public static void testPreorderTraversal() {
        BinaryTree.TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = preorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);

        ret.add(root.val);
        ret.addAll(left);
        ret.addAll(right);
        return ret;
    }

    public static void testInorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = inorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        ArrayList<Integer> left = inorderTraversal(root.left);
        ArrayList<Integer> right = inorderTraversal(root.right);

        ret.addAll(left);
        ret.add(root.val);
        ret.addAll(right);
        return ret;
    }

    public static void testPostorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = postorderTraversal(root);
        System.out.println("result=" + result);
    }

    public static ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }

        ArrayList<Integer> left = postorderTraversal(root.left);
        ArrayList<Integer> right = postorderTraversal(root.right);

        ret.addAll(left);
        ret.addAll(right);
        ret.add(root.val);
        return ret;
    }
}

