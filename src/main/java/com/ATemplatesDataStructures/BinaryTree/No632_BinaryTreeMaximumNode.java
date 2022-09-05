package com.ATemplatesDataStructures.BinaryTree;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Queue;

@Slf4j
public class No632_BinaryTreeMaximumNode {
  public static void main(String[] args) {
    No632_BinaryTreeMaximumNode No632_BinaryTreeMaximumNode = new No632_BinaryTreeMaximumNode();
    No632_BinaryTreeMaximumNode.testNo632_BinaryTreeMaximumNode();
  }

  private void testNo632_BinaryTreeMaximumNode() {
    log.info("result 2 v.s. " + maxNode(new TreeNode(2)));
  }

  TreeNode maxNode(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return root;
    }

    int max = root.val;
    TreeNode maxNode = root;
    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.val > max) {
        max = node.val;
        maxNode = node;
      }
      if (node.left != null) {
        queue.add(node.left);
      }
      if (node.right != null) {
        queue.add(node.right);
      }
    }

    // return the final result
    return maxNode;
  }

}
