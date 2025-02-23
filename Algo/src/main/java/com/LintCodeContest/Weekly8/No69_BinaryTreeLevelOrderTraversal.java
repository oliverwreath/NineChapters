package com.LintCodeContest.Weekly8;

import com.util.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No69_BinaryTreeLevelOrderTraversal {

  public static void main(String[] args) {
    No69_BinaryTreeLevelOrderTraversal No69_BinaryTreeLevelOrderTraversal = new No69_BinaryTreeLevelOrderTraversal();
    No69_BinaryTreeLevelOrderTraversal.testNo69_BinaryTreeLevelOrderTraversal();
  }

  private void testNo69_BinaryTreeLevelOrderTraversal() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    log.info("result 2 v.s. " + levelOrder(root));
  }

  List<List<Integer>> levelOrder(TreeNode root) {
    // filter abnormal cases
    List<List<Integer>> answer = new ArrayList<>();
    if (root == null) {
      return answer;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    HashMap<TreeNode, Integer> map = new HashMap<>();
    queue.add(root);
    map.put(root, 0);
    int currentLevel = -1;
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      if (map.get(node) > currentLevel) {
        answer.add(new ArrayList<>());
        currentLevel = map.get(node);
      }
      answer.get(answer.size() - 1).add(node.val);
      if (node.left != null) {
        queue.add(node.left);
        map.put(node.left, map.get(node) + 1);
      }
      if (node.right != null) {
        queue.add(node.right);
        map.put(node.right, map.get(node) + 1);
      }
    }

    // return the final result
    return answer;
  }

}
