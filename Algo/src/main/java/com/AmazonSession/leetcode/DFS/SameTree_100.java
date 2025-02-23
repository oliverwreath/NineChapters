package com.AmazonSession.leetcode.DFS;

import com.util.TreeNode;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class SameTree_100 {

  public static void main(String[] arg) {
    new SameTree_100().testSameTree_100();
  }

  private void testSameTree_100() {
    log.info("{}", isSameTree(null, null));
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {

    if (p == null || q == null) {
      return p == q;
    }

    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

}
