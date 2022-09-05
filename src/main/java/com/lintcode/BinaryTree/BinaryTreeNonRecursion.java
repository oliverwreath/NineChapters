package com.lintcode.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import static com.lintcode.BinaryTree.BinaryTree.getTree;

/**
 * Created by Yanliang Han on 2016/6/10.
 */
@Slf4j
public class BinaryTreeNonRecursion {
  public static void main(String[] args) {
    testPreorderTraversal();
    testInorderTraversal();
  }

  public static void testPreorderTraversal() {
    TreeNode root = getTree();
    ArrayList<Integer> result = preorderTraversal(root);
    log.debug("result=" + result);
  }

  //1 non-recursive
  public static ArrayList<Integer> preorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }

    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
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
    TreeNode root = getTree();
    ArrayList<Integer> result = inorderTraversal(root);
    log.debug("result=" + result);
  }

  public static ArrayList<Integer> inorderTraversal(TreeNode root) {
    if (root == null) {
      return new ArrayList<Integer>();
    }

    Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
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
