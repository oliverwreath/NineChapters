package com.oliver.BinaryTree;

import com.oliver.BinaryTree.BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Stack;


/**
 * Created by Yanliang Han on 2016/6/10.
 */
public class BinaryTreeNonRecursion {
    public static void main(String[] args) {
        testPreorderTraversal();
        testInorderTraversal();
    }

    public static void testPreorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("root=" + root);
        ArrayList<Integer> result = preorderTraversal(root);
        System.out.println("result=" + result);
    }

    //1 non-recursive
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        //root left right
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.add(top.right);
            }
            if (top.left != null) {
                stack.add(top.left);
            }
        }

        return result;
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
        if (root == null) {
            return new ArrayList<Integer>();
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        //root left right
        TreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode == null) {
                currentNode = stack.pop();
            } else {
                while (currentNode.left != null) {
                    stack.add(currentNode);
                    currentNode = currentNode.left;
                }
            }
            result.add(currentNode.val);
            if (currentNode.right != null) {
                currentNode = currentNode.right;
            } else {
                currentNode = null;
            }
        }

        return result;
    }
}
