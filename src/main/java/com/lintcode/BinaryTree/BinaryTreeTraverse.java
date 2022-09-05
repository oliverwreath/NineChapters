package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/10.
 */
@Slf4j
public class BinaryTreeTraverse {
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
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    preorderTraverse(root, result);
    return result;
  }

  public static void preorderTraverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }

    result.add(root.val);
    preorderTraverse(root.left, result);
    preorderTraverse(root.right, result);
    return;
  }

  public static void testInorderTraversal() {
    TreeNode root = getTree();
    ArrayList<Integer> result = inorderTraversal(root);
    log.debug("result=" + result);
  }

  public static ArrayList<Integer> inorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    inorderTraverse(root, result);
    return result;
  }

  public static void inorderTraverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }

    inorderTraverse(root.left, result);
    result.add(root.val);
    inorderTraverse(root.right, result);
    return;
  }

  public static void testPostorderTraversal() {
    TreeNode root = getTree();
    ArrayList<Integer> result = postorderTraversal(root);
    log.debug("result=" + result);
  }

  public static ArrayList<Integer> postorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    if (root == null) {
      return result;
    }

    postorderTraverse(root, result);
    return result;
  }

  public static void postorderTraverse(TreeNode root, ArrayList<Integer> result) {
    if (root == null) {
      return;
    }

    postorderTraverse(root.left, result);
    postorderTraverse(root.right, result);
    result.add(root.val);
    return;
  }
}
