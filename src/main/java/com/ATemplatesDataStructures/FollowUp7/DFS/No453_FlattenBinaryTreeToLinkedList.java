package com.ATemplatesDataStructures.FollowUp7.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Slf4j
public class No453_FlattenBinaryTreeToLinkedList {
  public static void main(String[] args) {
    No453_FlattenBinaryTreeToLinkedList No453_FlattenBinaryTreeToLinkedList = new No453_FlattenBinaryTreeToLinkedList();
    No453_FlattenBinaryTreeToLinkedList.testNo453_FlattenBinaryTreeToLinkedList();
  }

  private void testNo453_FlattenBinaryTreeToLinkedList() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.left.left = new TreeNode(3);
    treeNode.left.right = new TreeNode(4);
    treeNode.right = new TreeNode(5);
    treeNode.right.right = new TreeNode(6);
    flatten(treeNode);
  }

  public void flatten(TreeNode root) {
    // filter abnormal cases
    if (root == null || (root.left == null && root.right == null)) {
      return;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.add(root);
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      if (node.right != null) {
        stack.push(node.right);
      }
      if (node.left != null) {
        stack.push(node.left);
      }

      node.left = null;
      if (!stack.isEmpty()) {
        node.right = stack.peek();
      } else {
        node.right = null;
      }
    }

    // return the final result
    return;
  }

//    public void flatten(TreeNode root) {
//        // filter abnormal cases
//        if (root == null || (root.left == null && root.right == null)) {
//            return;
//        }
//
//        combinations.clear();
//        preOrder(root);
//        for (int i = 0; i < combinations.size() - 1; i++) {
//            combinations.get(i).left = null;
//            combinations.get(i).right = combinations.get(i + 1);
//        }
//
//        // return the final result
//        return;
//    }

  List<TreeNode> list = new ArrayList<>();

  public void preOrder(TreeNode root) {
    if (root == null) {
      return;
    }

    //root -> left -> right
    list.add(root);
    if (root.left != null) {
      preOrder(root.left);
    }
    if (root.right != null) {
      preOrder(root.right);
    }
  }

}
