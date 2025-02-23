package com.lintcode.BinaryTree;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

import com.util.TreeNode;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeDivide_Conquer {

  public static void main(String[] args) {
    testPreorderTraversal();
    testInorderTraversal();
    testPostorderTraversal();
  }

  public static void testPreorderTraversal() {
    TreeNode root = getTree();
    ArrayList<Integer> result = preorderTraversal(root);
    log.debug("result=" + result);
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
    TreeNode root = getTree();
    ArrayList<Integer> result = inorderTraversal(root);
    log.debug("result=" + result);
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
    TreeNode root = getTree();
    ArrayList<Integer> result = postorderTraversal(root);
    log.debug("result=" + result);
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

