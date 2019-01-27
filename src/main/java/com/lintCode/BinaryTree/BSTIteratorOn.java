package com.lintCode.BinaryTree;

import com.TreesUtil.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

import static com.lintCode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/12.
 */
public class BSTIteratorOn {
    private final static Logger logger = LoggerFactory.getLogger(BSTIteratorOn.class);
    private List<TreeNode> treeNodes = new LinkedList<TreeNode>();
    private int index = -1;

    public static void main(String[] args) {
        testBSTIterator();
    }

    public static void testBSTIterator() {
        TreeNode root = getTree();
        BSTIteratorOn iterator = new BSTIteratorOn(root);
        while (iterator.hasNext()) {
            TreeNode node = iterator.next();
            System.out.println(node.val);
        }
    }

    //@param root: The root of binary tree.
    public BSTIteratorOn(TreeNode root) {
        treeNodes.clear();
        this.treeNodes = inorder2List(root);
        this.index = -1;
    }

    private static List<TreeNode> inorder2List(TreeNode root) {
        List<TreeNode> ret = new LinkedList<TreeNode>();
        if (root == null) {
            return ret;
        }

        List<TreeNode> left = inorder2List(root.left);
        List<TreeNode> right = inorder2List(root.right);

        ret.addAll(left);
        ret.add(root);
        ret.addAll(right);
        return ret;
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return (index + 1 < treeNodes.size());
    }

    //@return: return next node
    public TreeNode next() {
        return treeNodes.get(++index);
    }
}
