package com.oliver.BinaryTree;

import java.util.LinkedList;
import java.util.List;

import com.oliver.BinaryTree.BinaryTree.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Yanliang Han on 2016/6/11.
 */
public class InorderSuccessor {
    private final static Logger logger = LoggerFactory.getLogger(InorderSuccessor.class);

    public static void main(String[] args) {
        testInorderSuccessor();
    }

    public static TreeNode getBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);

        logger.trace("root = {}", root);
        return root;
    }

    public static void testInorderSuccessor() {
        TreeNode root = getBST();
        System.out.println("result=" + inorderSuccessor(root, root));
        System.out.println("result=" + inorderSuccessor(getBST(), null));
        System.out.println("result=" + inorderSuccessor(null, null));
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        if (root == null || p == null) {
            return successor;
        }

        while (root != null && root != p) {
            if (p.val < root.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static TreeNode inorderSuccessorWithHelper(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }

        List<TreeNode> inorderList = inorderTraverse(root);
        int pIndex = inorderList.indexOf(p);
        if (pIndex != -1) {
            if (pIndex + 1 < inorderList.size()) {
                return inorderList.get(pIndex + 1);
            }
        }
        return null;
    }

    public static List<TreeNode> inorderTraverse(TreeNode root) {
        LinkedList<TreeNode> ret = new LinkedList<TreeNode>();
        if (root == null) {
            return ret;
        }

        List<TreeNode> left = inorderTraverse(root.left);
        List<TreeNode> right = inorderTraverse(root.right);
        ret.addAll(left);
        ret.add(root);
        ret.addAll(right);

        return ret;
    }
}
