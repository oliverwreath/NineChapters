package com.ATemplatesDataStructures.DFS_LeetCode.Tree_DFS;

import com.util.TreeNode;
import java.util.LinkedList;
import java.util.Queue;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class No101_SymmetricTree {

  public static void main(String[] args) {
    testNo101_SymmetricTree();
  }

  private static void testNo101_SymmetricTree() {
    No101_SymmetricTree No101_SymmetricTree = new No101_SymmetricTree();
//        log.info("result 2 v.s. " + No101_SymmetricTree.isSymmetric("12"));
//        log.info("result 1 v.s. " + No101_SymmetricTree.isSymmetric("10"));
  }

  /**
   * @param root
   * @return
   */
  public boolean isSymmetric(TreeNode root) {
    if (root == null) {
      return true;
    }

    // core logic
    if (root.left == null) {
      return root.right == null;
    } else if (root.right == null) {
      return false;
    }

    Queue<TreeNode> queueLeft = new LinkedList<>();
    Queue<TreeNode> queueRight = new LinkedList<>();
    queueLeft.add(root.left);
    queueRight.add(root.right);
    while (!queueLeft.isEmpty()) {
      if (queueRight.isEmpty()) {
        return false;
      }
      TreeNode currentLeft = queueLeft.poll();
      TreeNode currentRight = queueRight.poll();
      if (currentLeft != null || currentRight != null) {
        if ((currentLeft == null) || (currentRight == null) || (currentLeft.val != currentRight.val)) {
          return false;
        }
        queueLeft.add(currentLeft.left);
        queueLeft.add(currentLeft.right);
        queueRight.add(currentRight.right);
        queueRight.add(currentRight.left);
      }
    }

    return true;
  }

}
