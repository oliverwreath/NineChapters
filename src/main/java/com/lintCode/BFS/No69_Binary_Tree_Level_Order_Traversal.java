package com.lintCode.BFS;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class No69_Binary_Tree_Level_Order_Traversal {
  private static final Logger logger = LoggerFactory.getLogger(No69_Binary_Tree_Level_Order_Traversal.class);

  public static void main(String[] arg) {
    No69_Binary_Tree_Level_Order_Traversal tester = new No69_Binary_Tree_Level_Order_Traversal();
    tester.test();
  }

  private void test() {
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(3);
    logger.info("{}", levelOrder(treeNode));
    treeNode = new TreeNode(1);
    treeNode.right = new TreeNode(2);
    treeNode.right.left = new TreeNode(3);
    logger.info("{}", levelOrder(treeNode));
  }

  /**
   * @param root: A Tree
   * @return: Level order a list of lists of integer
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // write your code here
    if (root == null) {
      return new LinkedList<>();
    }

    result = new LinkedList<>();
    bfs(root);
    return result;
  }

  private List<List<Integer>> result;

  private void bfs(TreeNode root) {
    Queue<TreeNode> queue = new ArrayDeque<>();
    Map<TreeNode, Integer> distance = new HashMap<>();
    queue.add(root);
    distance.put(root, 0);
    int currentDistance = -1;

    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (node == null) {
        continue;
      }
      if (distance.get(node) > currentDistance) {
        currentDistance++;
        result.add(new LinkedList<>());
      }
      result.get(currentDistance).add(node.val);

      if (node.left != null) {
        queue.add(node.left);
        distance.put(node.left, currentDistance + 1);
      }
      if (node.right != null) {
        queue.add(node.right);
        distance.put(node.right, currentDistance + 1);
      }
    }

    return;
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
