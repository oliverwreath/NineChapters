package com.leetcode.Weekly71;

import com.util.TreeNode;
import java.util.LinkedList;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LC783MinimumDistanceBetweenBSTNodes {

  public static void main(String[] args) {
    new LC783MinimumDistanceBetweenBSTNodes().testNo783_MinimumDistanceBetweenBSTNodes();
  }

  private void testNo783_MinimumDistanceBetweenBSTNodes() {
    TreeNode node = new TreeNode(-7);
    node.left = new TreeNode(-9);
    log.info("result 2 v.s. " + minDiffInBST(node));
  }

  public int minDiffInBST(TreeNode root) {
    // filter abnormal cases
    if (root == null) {
      return 0;
    }

    nodes = new LinkedList<>();
    helper(root);

    // return the final result
    int answer = Integer.MAX_VALUE;
    int slow = nodes.getFirst();
    for (int i = 1; i < nodes.size(); i++) {
      int fast = nodes.get(i);
      answer = Math.min(answer, Math.abs(fast - slow));
      slow = fast;
    }
    return answer;
  }

  LinkedList<Integer> nodes;

  public void helper(TreeNode root) {
    if (root == null) {
      return;
    }
    helper(root.left);
    nodes.add(root.val);
    helper(root.right);
  }

}
