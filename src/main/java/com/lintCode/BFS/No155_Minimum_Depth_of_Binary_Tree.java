package com.lintCode.BFS;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class No155_Minimum_Depth_of_Binary_Tree {
  private static final Logger logger = LoggerFactory.getLogger(No155_Minimum_Depth_of_Binary_Tree.class);

  public static void main(String[] arg) {
    No155_Minimum_Depth_of_Binary_Tree tester = new No155_Minimum_Depth_of_Binary_Tree();
    tester.test();
  }

  private void test() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.right.left = new TreeNode(3);
    logger.info("{}", minDepth(treeNode));
    treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(3);
    treeNode.right.left = new TreeNode(4);
    treeNode.right.right = new TreeNode(5);
    logger.info("{}", minDepth(treeNode));
  }

  /**
   * @param root: The root of binary tree
   * @return: An integer
   */
  public int minDepth(TreeNode root) {
    // write your code here
    if (root == null) {
      return 0;
    }

    return bfs(root);
  }

  private int bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    Map<TreeNode, Integer> distance = new HashMap<>();
    queue.add(root);
    distance.put(root, 1);

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node.left == null && node.right == null) {
        return distance.get(node);
      }

      if (node.left != null) {
        queue.add(node.left);
        distance.put(node.left, distance.get(node) + 1);
      }
      if (node.right != null) {
        queue.add(node.right);
        distance.put(node.right, distance.get(node) + 1);
      }
    }

    return -1;
  }

  public class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
      this.val = val;
      this.left = this.right = null;
    }
  }
}
