package com.ATemplatesDataStructures.DFS_LeetCode.Tree_BFS_LevelOrderTraversal;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Slf4j
public class No102_BinaryTreeLevelOrderTraversal {
  public static void main(String[] args) {
    testNo102_BinaryTreeLevelOrderTraversal();
  }

  private static void testNo102_BinaryTreeLevelOrderTraversal() {
    No102_BinaryTreeLevelOrderTraversal No102_BinaryTreeLevelOrderTraversal = new No102_BinaryTreeLevelOrderTraversal();
    log.info("result 0 v.s. " + No102_BinaryTreeLevelOrderTraversal.levelOrder(null));
    log.info("result 1 v.s. " + No102_BinaryTreeLevelOrderTraversal.levelOrder(new TreeNode(3)));
  }

  /**
   * @param root
   * @return
   */
  public List<List<Integer>> levelOrder(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return new LinkedList<>();
    }

    // core logic
    Queue<Entry> queue1 = new LinkedList<>();
    Queue<Entry> queue2 = new LinkedList<>();
    queue1.add(new Entry(root, 1));
    List<List<Integer>> resultList = new LinkedList<>();
    while (true) {
      if (queue1.isEmpty()) {
        return resultList;
      }
      List<Integer> row = new LinkedList<>();
      rowProcessing(queue1, queue2, row);
      resultList.add(row);
      Queue<Entry> tmp = queue1;
      queue1 = queue2;
      queue2 = tmp;
    }
  }

  private void rowProcessing(Queue<Entry> queue1, Queue<Entry> queue2, List<Integer> row) {
    while (!queue1.isEmpty()) {
      Entry currentEntry = queue1.remove();
      row.add(currentEntry.node.val);
      if (currentEntry.node.left != null) {
        queue2.add(new Entry(currentEntry.node.left, currentEntry.depth + 1));
      }
      if (currentEntry.node.right != null) {
        queue2.add(new Entry(currentEntry.node.right, currentEntry.depth + 1));
      }
    }
  }

  class Entry {
    TreeNode node;
    int depth;

    public Entry(TreeNode node, int depth) {
      this.node = node;
      this.depth = depth;
    }

    @Override
    public String toString() {
      return "Entry{" +
              "node=" + node +
              ", depth=" + depth +
              '}';
    }
  }

}
