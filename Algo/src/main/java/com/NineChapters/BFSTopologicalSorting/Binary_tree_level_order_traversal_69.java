package com.NineChapters.BFSTopologicalSorting;

import com.util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Binary_tree_level_order_traversal_69 {

  public static void main(String[] args) {
    testBinary_tree_level_order_traversal_69();
  }

  private static void testBinary_tree_level_order_traversal_69() {
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    log.info("result _ v.s. {}", levelOrder(root));
  }

  public static List<List<Integer>> levelOrder(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return new LinkedList<>();
    }
    List<List<Integer>> result = new LinkedList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    List<Integer> level = new LinkedList<>();
    while (!queue.isEmpty()) {
      TreeNode currentTreeNode = queue.poll();
      if (currentTreeNode == null) {
        if (level.size() == 0) {
          break;
        }
        result.add(level);
        level = new LinkedList<>();
        queue.offer(null);
        continue;
      }

      level.add(currentTreeNode.val);
      if (currentTreeNode.left != null) {
        queue.offer(currentTreeNode.left);
      }
      if (currentTreeNode.right != null) {
        queue.offer(currentTreeNode.right);
      }
    }

    // return the final result
    return result;
  }

}
