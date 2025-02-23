package com.AmazonSession.leetcode.DFS;

import com.util.TreeNode;
import java.util.LinkedList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class PathSum_112 {

  public static void main(String[] arg) {
    new PathSum_112().testSameTree_100();
  }

  private void testSameTree_100() {
    log.info("{}", hasPathSum(null, 22));
  }

  public boolean hasPathSum(TreeNode root, int sum) {

    if (root == null) {
      return false;
    }

    List<Integer> pathSum = getPathSum(root);
    for (Integer aSum : pathSum) {
      if (aSum == sum) {
        return true;
      }
    }

    return false;
  }

  public List<Integer> getPathSum(TreeNode root) {
    LinkedList<Integer> ans = new LinkedList<>();
    if (root == null) {
      return ans;
    }
    if (root.left == null && root.right == null) {
      ans.add(root.val);
      return ans;
    }
    if (root.left != null) {
      List<Integer> leftSum = getPathSum(root.left);
      for (Integer aLeft : leftSum) {
        ans.add(aLeft + root.val);
      }
    }
    if (root.right != null) {
      List<Integer> rightSum = getPathSum(root.right);
      for (Integer aRight : rightSum) {
        ans.add(aRight + root.val);
      }
    }
    return ans;
  }

}
