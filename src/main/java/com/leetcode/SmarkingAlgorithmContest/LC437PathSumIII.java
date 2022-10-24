package com.leetcode.SmarkingAlgorithmContest;

import com.util.TreeNode;
import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: Oliver
 */
@Slf4j
public class LC437PathSumIII {

  public static void main(String[] arg) {
    new LC437PathSumIII().testPathSumIII_437();
  }

  private void testPathSumIII_437() {
    TreeNode sub = new TreeNode(3);
    sub.left = new TreeNode(3);
    sub.right = new TreeNode(-2);

    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(5);
    root.left.left = sub;
    root.left.right = new TreeNode(2);
    root.left.right.right = new TreeNode(1);

    root.right = new TreeNode(-3);
    root.right.right = new TreeNode(11);

    root.left.right.right = new TreeNode(1);
    log.info("{} \n{}", root, pathSum(root, 8));
  }

  private int counter;
  private int target;

  public int pathSum(TreeNode root, int sum) {

    counter = 0;
    target = sum;

    ArrayList<Long> sums = getSums(root);
    log.info("sums = " + sums);
    for (Long aLong : sums) {
      if (aLong == sum) {
        counter++;
      }
    }

    return counter;
  }

  private ArrayList<Long> getSums(TreeNode root) {
    if (root == null) {
      return new ArrayList<>(0);
    }
    if (root.left == null && root.right == null) {
      ArrayList<Long> ans = new ArrayList<>(0);
      ans.add((long) root.val);
      return ans;
    }
    ArrayList<Long> ans = new ArrayList<>(0);
    ans.add((long) root.val);
    int myCounter = 0;
    if (root.left != null) {
      ArrayList<Long> lefts = getSums(root.left);
      for (Long aLeft : lefts) {
        ans.add(aLeft + root.val);
        if (aLeft == target) {
          myCounter++;
        }
      }
    }
    if (root.right != null) {
      ArrayList<Long> rights = getSums(root.right);
      for (Long aRight : rights) {
        ans.add(aRight + root.val);
        if (aRight == target) {
          myCounter++;
        }
      }
    }
    counter += myCounter;
    log.info("root.val = " + root.val + "; ans = " + ans + "; myCounter = " + myCounter);
    return ans;
  }
}
