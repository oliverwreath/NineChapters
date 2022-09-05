package com.AmazonSession.leetcode.algorithms;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Author: Oliver
 */
@Slf4j
public class LC199BinaryTreeRightSideView {
  public List<Integer> rightSideView(TreeNode root) {
    if (root == null)
      return Collections.emptyList();

//    log.info("root = " + root);
    List<Integer> ans = bst(root);

    return ans;
  }

  private List<Integer> bst(TreeNode root) {
    if (root == null) {
      return new LinkedList<>();
    }

    Deque<TreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);
    List<Integer> ans = new LinkedList<>();
    while (!deque.isEmpty()) {
      ans.add(deque.peekLast().val);
//      log.info("size = " + deque.size() + "; deque.peekLast().val = " + deque.peekLast().val);
      int size = deque.size();
      for (int t = 0; t < size; t++) {
        TreeNode currentNode = deque.pollFirst();
        if (currentNode != null) {
          if (currentNode.left != null) {
            deque.addLast(currentNode.left);
          }
          if (currentNode.right != null) {
            deque.addLast(currentNode.right);
          }
        }
      }
    }
    return ans;
  }
}
